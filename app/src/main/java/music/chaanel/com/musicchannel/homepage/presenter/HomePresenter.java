package music.chaanel.com.musicchannel.homepage.presenter;

import java.util.List;

import music.chaanel.com.musicchannel.homepage.beans.ArtistsBean;
import music.chaanel.com.musicchannel.homepage.beans.HomeBean;
import music.chaanel.com.musicchannel.homepage.beans.HomeDataBean;
import music.chaanel.com.musicchannel.homepage.beans.HomeWrapBean;
import music.chaanel.com.musicchannel.homepage.dao.GreenDaoManager;
import music.chaanel.com.musicchannel.homepage.gen.ArtistsBeanDao;
import music.chaanel.com.musicchannel.homepage.gen.DaoSession;
import music.chaanel.com.musicchannel.homepage.gen.HomeBeanDao;
import music.chaanel.com.musicchannel.homepage.gen.HomeDataBeanDao;
import music.chaanel.com.musicchannel.homepage.gen.HomeWrapBeanDao;
import music.chaanel.com.musicchannel.homepage.server.CompoentServer;
import music.chaanel.com.musicchannel.utils.RequestInfo;
import music.chaanel.com.musicchannel.homepage.view.IHomeView;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/10/12.
 */

public class HomePresenter implements IHomePresenter {
    private IHomeView view;
    public static final String TAG = "SUNCHAO";

    @Override
    public void bingView(IHomeView view) {
        this.view = view;
    }

    @Override
    public void unBindView() {
        this.view = null;
    }

    @Override
    public void handleData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RequestInfo.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        CompoentServer compoentServer = retrofit.create(CompoentServer.class);
        Observable<HomeBean> observable = compoentServer.getCall();
        observable.subscribeOn(Schedulers.io())
                .map(new Func1<HomeBean, HomeBean>() {
                    @Override
                    public HomeBean call(HomeBean homeBean) {
                        insertIntoDb(homeBean);
                        return homeBean;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HomeBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().failedToShow(e);
                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        getView().showData(homeBean);
                    }
                });
    }

    @Override
    public IHomeView getView() {
        return view;
    }

    public void insertIntoDb(HomeBean homeBean){
        homeBean.set_id(2l);
        DaoSession session = GreenDaoManager.getInstance().getSession();
        HomeBeanDao homeBeanDao = session.getHomeBeanDao();
        HomeWrapBeanDao homeWrapBeanDao = session.getHomeWrapBeanDao();
        HomeDataBeanDao homeDataBeanDao = session.getHomeDataBeanDao();
        ArtistsBeanDao artistsBeanDao = session.getArtistsBeanDao();

        homeWrapBeanDao.deleteAll();

        homeBeanDao.insertOrReplace(homeBean);
        List<HomeWrapBean> homeWrapBeens = homeBean.getData();
        //homeWrapBeanDao.insertOrReplaceInTx(homeWrapBeens);
        for (HomeWrapBean homeWrapBeen : homeWrapBeens) {
            homeWrapBeen.setHomeId(homeBean.get_id());
            homeWrapBeanDao.insertOrReplaceInTx(homeWrapBeen);
            List<HomeDataBean> homeDataBeens = homeWrapBeen.getData();
            //homeDataBeanDao.insertOrReplaceInTx(homeDataBeens);
            for (HomeDataBean homeDataBeen : homeDataBeens) {
                homeDataBeen.setHomeWrapId(homeWrapBeen.getId());
                homeDataBeanDao.insertOrReplaceInTx(homeDataBeen);
                List<ArtistsBean> artists = homeDataBeen.getArtists();
                //artistsBeanDao.insertOrReplaceInTx(artists);
                for (ArtistsBean artist : artists) {
                    artist.setHomeDataId(homeDataBeen.getVideoId());
                    artistsBeanDao.insertOrReplaceInTx(artist);
                }
            }
        }
    }
}
