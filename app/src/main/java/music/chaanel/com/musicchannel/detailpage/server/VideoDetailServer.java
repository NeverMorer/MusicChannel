package music.chaanel.com.musicchannel.detailpage.server;

import music.chaanel.com.musicchannel.detailpage.beans.DetailVideoBean;
import music.chaanel.com.musicchannel.utils.RequestInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/10/13.
 */

public interface VideoDetailServer {
    @Headers({
            RequestInfo.AUTHORIZATION,
            RequestInfo.DEVICE_INFO,
            RequestInfo.APP_ID,
            RequestInfo.DEVICE_ID,
            RequestInfo.DEVICE_N,
            RequestInfo.DEVICE_V
    })
    @GET(RequestInfo.VIDEO)
    Call<DetailVideoBean> getCall(@Query("videoId") String id );
}
