package music.chaanel.com.musicchannel.detailpage.beans;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */

public class DetailVideoBean {

    /**
     * code : 0
     * msg : SUCCESS
     * now : 1476358362690
     * data : {"specialType":"common","status":200,"hdUrl":"http://hc.yinyuetai.com/uploads/videos/common/BA710157626FB47F1B68C35E974120C7.flv?sc=318c0cc7eb491aca&br=779&rd=Android","videoSize":13949199,"url":"http://dd.yinyuetai.com/uploads/videos/common/FB9F015764670D84208D2976358A0D7F.mp4?sc=2f64eedfeda207a6&br=578&rd=Android","videoTypes":[1,2,3,4],"uhdUrl":"http://hd.yinyuetai.com/uploads/videos/common/2226015764670D997908B9CD587D3D26.flv?sc=a5a66d8fdc6bf0b0&br=1099&rd=Android","shdUrl":"http://he.yinyuetai.com/uploads/videos/common/24EA015764670D93BCBD1CAE85C212B3.flv?sc=7b19f0dc1103e67e&br=3139&rd=Android","shdVideoSize":75713164,"title":"让我心动(Only One)  完整版","hdVideoSize":18791345,"duration":192,"videoId":2687649,"ad":false,"uhdVideoSize":26525856}
     * cost : 1
     */

    private String code;
    private String msg;
    private long now;
    /**
     * specialType : common
     * status : 200
     * hdUrl : http://hc.yinyuetai.com/uploads/videos/common/BA710157626FB47F1B68C35E974120C7.flv?sc=318c0cc7eb491aca&br=779&rd=Android
     * videoSize : 13949199
     * url : http://dd.yinyuetai.com/uploads/videos/common/FB9F015764670D84208D2976358A0D7F.mp4?sc=2f64eedfeda207a6&br=578&rd=Android
     * videoTypes : [1,2,3,4]
     * uhdUrl : http://hd.yinyuetai.com/uploads/videos/common/2226015764670D997908B9CD587D3D26.flv?sc=a5a66d8fdc6bf0b0&br=1099&rd=Android
     * shdUrl : http://he.yinyuetai.com/uploads/videos/common/24EA015764670D93BCBD1CAE85C212B3.flv?sc=7b19f0dc1103e67e&br=3139&rd=Android
     * shdVideoSize : 75713164
     * title : 让我心动(Only One)  完整版
     * hdVideoSize : 18791345
     * duration : 192
     * videoId : 2687649
     * ad : false
     * uhdVideoSize : 26525856
     */

    private DataBean data;
    private int cost;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static class DataBean {
        private String specialType;
        private int status;
        private String hdUrl;
        private int videoSize;
        private String url;
        private String uhdUrl;
        private String shdUrl;
        private int shdVideoSize;
        private String title;
        private int hdVideoSize;
        private int duration;
        private int videoId;
        private boolean ad;
        private int uhdVideoSize;
        private List<Integer> videoTypes;

        public String getSpecialType() {
            return specialType;
        }

        public void setSpecialType(String specialType) {
            this.specialType = specialType;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getHdUrl() {
            return hdUrl;
        }

        public void setHdUrl(String hdUrl) {
            this.hdUrl = hdUrl;
        }

        public int getVideoSize() {
            return videoSize;
        }

        public void setVideoSize(int videoSize) {
            this.videoSize = videoSize;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUhdUrl() {
            return uhdUrl;
        }

        public void setUhdUrl(String uhdUrl) {
            this.uhdUrl = uhdUrl;
        }

        public String getShdUrl() {
            return shdUrl;
        }

        public void setShdUrl(String shdUrl) {
            this.shdUrl = shdUrl;
        }

        public int getShdVideoSize() {
            return shdVideoSize;
        }

        public void setShdVideoSize(int shdVideoSize) {
            this.shdVideoSize = shdVideoSize;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getHdVideoSize() {
            return hdVideoSize;
        }

        public void setHdVideoSize(int hdVideoSize) {
            this.hdVideoSize = hdVideoSize;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public boolean isAd() {
            return ad;
        }

        public void setAd(boolean ad) {
            this.ad = ad;
        }

        public int getUhdVideoSize() {
            return uhdVideoSize;
        }

        public void setUhdVideoSize(int uhdVideoSize) {
            this.uhdVideoSize = uhdVideoSize;
        }

        public List<Integer> getVideoTypes() {
            return videoTypes;
        }

        public void setVideoTypes(List<Integer> videoTypes) {
            this.videoTypes = videoTypes;
        }
    }
}
