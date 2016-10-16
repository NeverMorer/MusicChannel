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


public abstract class BaseMoudel<T> implements Callback<T> {
    public String location;
    public int page;
    public OnLoadComplete onLoadComplete;
    public Call<MVBean> call;

    public BaseMoudel(String location, int page) {
        this.location = location;
        this.page = page;
    }

    public void getData(OnLoadComplete<T> onLoadComplete){
        this.onLoadComplete = onLoadComplete;
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(Urls.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UrlServer urlServer = retrofit.create(UrlServer.class);
        getCall(urlServer).enqueue(this);
    }

    public void cancel() {
        call.cancel();
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onLoadComplete.callback(response, this);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onLoadComplete.errorCallback(location);
    }

    abstract public Call<T> getCall(UrlServer urlServer);
}
