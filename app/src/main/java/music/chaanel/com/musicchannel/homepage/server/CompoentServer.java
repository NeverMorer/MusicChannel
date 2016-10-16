package music.chaanel.com.musicchannel.homepage.server;

import music.chaanel.com.musicchannel.homepage.beans.HomeBean;
import music.chaanel.com.musicchannel.utils.RequestInfo;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

/**
 * Created by Administrator on 2016/10/12.
 */

public interface CompoentServer {
    @Headers({
            RequestInfo.AUTHORIZATION,
            RequestInfo.DEVICE_INFO,
            RequestInfo.APP_ID,
            RequestInfo.DEVICE_ID,
            RequestInfo.DEVICE_N,
            RequestInfo.DEVICE_V
    })
    @GET(RequestInfo.COMPONENT)
    Observable<HomeBean> getCall();
}
