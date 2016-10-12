package music.chaanel.com.musicchannel.homepage.beans;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */

public class HomeDataBean {

    /**
     * videoId : 2699281
     * type : play
     * title : 暖萌奶爸也是王菲迷弟 - 马天宇专访
     * desc : 安静的美男子马天宇的专访来喽!每次把机场当成签售会的明星,台哥还是头回见!与专属挂件Jackson的甜蜜日常也是让wuli暖萌小奶爸十分怀念~提到王菲秒变迷弟,更为看演唱会推掉通告!已经出道十年还会举办演唱会?羽毛们,本期节目播放量突破100万,还会解锁马天宇独家萌萌哒Morning Call哦!
     * posterPic : http://img2.c.yinyuetai.com/others/mobile_front_page/161011/0/-M-1453ef5b0b9c03bea10429c95d2fe71c_0x0.jpg
     * artists : [{"artistId":30971,"artistName":"STAR!调查团"},{"artistId":87,"artistName":"马天宇"}]
     * videoTypes : [1,2,3,4]
     * totalView : 59885
     * clickUrl : http://mapiv2.yinyuetai.com/statistics/click.json?id=4691
     * regdate : 2016-10-11 17:53
     * isVchart : false
     * dataTypeUrl : http://img2.c.yinyuetai.com/others/ad/160627/0/-M-c78aa0e2daafe509c640d7559d2fa8b1_0x0.png
     * ad : false
     */

    private int videoId;
    private String type;
    private String title;
    private String desc;
    private String posterPic;
    private int totalView;
    private String clickUrl;
    private String regdate;
    private boolean isVchart;
    private String dataTypeUrl;
    private boolean ad;
    /**
     * artistId : 30971
     * artistName : STAR!调查团
     */

    private List<ArtistsBean> artists;
    private List<Integer> videoTypes;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPosterPic() {
        return posterPic;
    }

    public void setPosterPic(String posterPic) {
        this.posterPic = posterPic;
    }

    public int getTotalView() {
        return totalView;
    }

    public void setTotalView(int totalView) {
        this.totalView = totalView;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public boolean isIsVchart() {
        return isVchart;
    }

    public void setIsVchart(boolean isVchart) {
        this.isVchart = isVchart;
    }

    public String getDataTypeUrl() {
        return dataTypeUrl;
    }

    public void setDataTypeUrl(String dataTypeUrl) {
        this.dataTypeUrl = dataTypeUrl;
    }

    public boolean isAd() {
        return ad;
    }

    public void setAd(boolean ad) {
        this.ad = ad;
    }

    public List<ArtistsBean> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistsBean> artists) {
        this.artists = artists;
    }

    public List<Integer> getVideoTypes() {
        return videoTypes;
    }

    public void setVideoTypes(List<Integer> videoTypes) {
        this.videoTypes = videoTypes;
    }

    public static class ArtistsBean {
        private int artistId;
        private String artistName;

        public int getArtistId() {
            return artistId;
        }

        public void setArtistId(int artistId) {
            this.artistId = artistId;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }
    }
}
