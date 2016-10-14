package music.chaanel.com.musicchannel.W.Moudel;

import music.chaanel.com.musicchannel.W.Beans.MVBean;
import music.chaanel.com.musicchannel.W.Beans.Urls;
import music.chaanel.com.musicchannel.W.Presenter.OnLoadComplete;
import music.chaanel.com.musicchannel.W.Servers.UrlServer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * /**
 * <p>
 * ----------Dragon be here!----------/
 * 　　　 ┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 */


public class mMoudel implements BaseMoudel<MVBean>,Callback<MVBean> {
    private String location;
    private int page;
    private OnLoadComplete onLoadComplete;
    private Call<MVBean> call;


    public mMoudel(String location, int page) {
        this.location = location;
        this.page = page;
    }

    @Override
    public void getData(OnLoadComplete onLoadComplete) {
        this.onLoadComplete = onLoadComplete;
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(Urls.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UrlServer urlServer = retrofit.create(UrlServer.class);
        call = urlServer.getMV(location,page);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<MVBean> call, Response<MVBean> response) {
        onLoadComplete.callback(response,this);
    }

    @Override
    public void onFailure(Call<MVBean> call, Throwable t) {
        onLoadComplete.errorCallback(location);
    }

    public void cancel(){
        call.cancel();
    }
}
