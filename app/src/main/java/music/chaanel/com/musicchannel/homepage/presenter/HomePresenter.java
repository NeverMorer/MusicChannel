package music.chaanel.com.musicchannel.homepage.presenter;

import android.util.Log;

import music.chaanel.com.musicchannel.homepage.beans.HomeBean;
import music.chaanel.com.musicchannel.homepage.server.CompoentServer;
import music.chaanel.com.musicchannel.homepage.utils.HomeInfo;
import music.chaanel.com.musicchannel.homepage.view.IHomeView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/10/12.
 */

public class HomePresenter implements IHomePresenter{
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
                .baseUrl(HomeInfo.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Call<HomeBean> call = retrofit.create(CompoentServer.class).getCall();
        call.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                HomeBean homeBean = response.body();
                getView().showData(homeBean);
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
            }
        });

    }

    @Override
    public IHomeView getView() {
        return view;
    }
}
