package music.chaanel.com.musicchannel.detailpage.presenter;


import music.chaanel.com.musicchannel.detailpage.beans.DetailVideoBean;
import music.chaanel.com.musicchannel.detailpage.server.VideoDetailServer;
import music.chaanel.com.musicchannel.detailpage.view.IDetailView;
import music.chaanel.com.musicchannel.utils.RequestInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/10/13.
 */

public class DetailPresenter implements IDetailPresenter {
    private IDetailView view;

    @Override
    public void bingView(IDetailView view) {
        this.view = view;
    }

    @Override
    public void unBindView() {
        view = null;
    }

    @Override
    public void handleData(String videoId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RequestInfo.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VideoDetailServer server = retrofit.create(VideoDetailServer.class);
        Call<DetailVideoBean> call = server.getCall(videoId,"1");
        call.enqueue(new Callback<DetailVideoBean>() {
            @Override
            public void onResponse(Call<DetailVideoBean> call, Response<DetailVideoBean> response) {
                DetailVideoBean detailVideoBean = response.body();
                view.showData(detailVideoBean);
            }

            @Override
            public void onFailure(Call<DetailVideoBean> call, Throwable t) {
                view.failedToShow(t);
            }
        });

    }
}
