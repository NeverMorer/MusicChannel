package music.chaanel.com.musicchannel.homepage.server;

import music.chaanel.com.musicchannel.homepage.beans.HomeBean;
import music.chaanel.com.musicchannel.homepage.utils.HomeInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/10/12.
 */

public interface CompoentServer {
    @Headers({
            HomeInfo.AUTHORIZATION,
            HomeInfo.DEVICE_INFO,
            HomeInfo.APP_ID,
            HomeInfo.DEVICE_ID,
            HomeInfo.DEVICE_N,
            HomeInfo.DEVICE_V
    })
    @GET(HomeInfo.COMPONENT)
    Observable<HomeBean> getCall();
}
