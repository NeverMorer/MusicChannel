package music.chaanel.com.musicchannel.detailpage.presenter;


import music.chaanel.com.musicchannel.detailpage.beans.CommentVideoBean;
import music.chaanel.com.musicchannel.detailpage.beans.DetailVideoBean;
import music.chaanel.com.musicchannel.detailpage.server.CommentDataServer;
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
    public void handleData(String videoId,int type) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RequestInfo.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VideoDetailServer server = retrofit.create(VideoDetailServer.class);
        Call<DetailVideoBean> call = server.getCall(type,videoId);
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

    @Override
    public void handleCommentData(final String videoId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RequestInfo.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Call<CommentVideoBean> call = retrofit.create(CommentDataServer.class).getCall(videoId);
        call.enqueue(new Callback<CommentVideoBean>() {
            @Override
            public void onResponse(Call<CommentVideoBean> call, Response<CommentVideoBean> response) {
                if (view != null) {
                    view.showData(response.body());
                }
            }

            @Override
            public void onFailure(Call<CommentVideoBean> call, Throwable t) {
                if (view != null) {
                    view.failedToShow(t);
                }
            }
        });

    }
}
