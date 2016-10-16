package music.chaanel.com.musicchannel.homepage.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import music.chaanel.com.musicchannel.gen.DaoSession;
import music.chaanel.com.musicchannel.gen.ArtistsBeanDao;
import music.chaanel.com.musicchannel.gen.HomeDataBeanDao;

/**
 * Created by Administrator on 2016/10/12.
 */
@Entity
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
    @Id
    private Long videoId;

    private Long homeWrapId;
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
    @ToMany(referencedJoinProperty = "homeDataId")
    private List<ArtistsBean> artists;
    @Transient
    private List<Integer> videoTypes;
    /**
     * icon : http://img4.c.yinyuetai.com/others/admin/160920/0/-M-e485d2f7a6799aa7012f14e74b2aecde_100x100.png
     * extend : {"style":"PLAYLIST","supportPage":false,"supportTransverseSlider":false,"type":0,"custom":false}
     * pathKey : PLAYLIST_BUTTON
     */

    private String icon;
    /**
     * style : PLAYLIST
     * supportPage : false
     * supportTransverseSlider : false
     * type : 0
     * custom : false
     */
    @Transient
    private ExtendBean extend;
    private String pathKey;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 398848359)
    private transient HomeDataBeanDao myDao;

    @Generated(hash = 1225426227)
    public HomeDataBean(Long videoId, Long homeWrapId, String type, String title, String desc, String posterPic, int totalView, String clickUrl, String regdate,
            boolean isVchart, String dataTypeUrl, boolean ad, String icon, String pathKey) {
        this.videoId = videoId;
        this.homeWrapId = homeWrapId;
        this.type = type;
        this.title = title;
        this.desc = desc;
        this.posterPic = posterPic;
        this.totalView = totalView;
        this.clickUrl = clickUrl;
        this.regdate = regdate;
        this.isVchart = isVchart;
        this.dataTypeUrl = dataTypeUrl;
        this.ad = ad;
        this.icon = icon;
        this.pathKey = pathKey;
    }

    @Generated(hash = 92414925)
    public HomeDataBean() {
    }

    /**
     *  "title":"悦 单",
     "icon":"http://img4.c.yinyuetai.com/others/admin/160920/0/-M-e485d2f7a6799aa7012f14e74b2aecde_100x100.png",
     "extend":Object{...},
     "pathKey":"PLAYLIST_BUTTON"
     * @return
     */





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



    public void setArtists(List<ArtistsBean> artists) {
        this.artists = artists;
    }

    public List<Integer> getVideoTypes() {
        return videoTypes;
    }

    public void setVideoTypes(List<Integer> videoTypes) {
        this.videoTypes = videoTypes;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ExtendBean getExtend() {
        return extend;
    }

    public void setExtend(ExtendBean extend) {
        this.extend = extend;
    }

    public String getPathKey() {
        return pathKey;
    }

    public void setPathKey(String pathKey) {
        this.pathKey = pathKey;
    }

    public boolean getIsVchart() {
        return this.isVchart;
    }

    public boolean getAd() {
        return this.ad;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 749747179)
    public List<ArtistsBean> getArtists() {
        if (artists == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ArtistsBeanDao targetDao = daoSession.getArtistsBeanDao();
            List<ArtistsBean> artistsNew = targetDao._queryHomeDataBean_Artists(videoId);
            synchronized (this) {
                if (artists == null) {
                    artists = artistsNew;
                }
            }
        }
        return artists;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1544541877)
    public synchronized void resetArtists() {
        artists = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public long getHomeWrapId() {
        return this.homeWrapId;
    }

    public void setHomeWrapId(long homeWrapId) {
        this.homeWrapId = homeWrapId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public void setHomeWrapId(Long homeWrapId) {
        this.homeWrapId = homeWrapId;
    }

    public Long getVideoId() {
        return this.videoId;
    }

    public String getType() {
        return this.type;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1769562015)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHomeDataBeanDao() : null;
    }



    @Entity
    public static class ExtendBean {
        private String style;
        private boolean supportPage;
        private boolean supportTransverseSlider;
        private int type;
        private boolean custom;

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public boolean isSupportPage() {
            return supportPage;
        }

        public void setSupportPage(boolean supportPage) {
            this.supportPage = supportPage;
        }

        public boolean isSupportTransverseSlider() {
            return supportTransverseSlider;
        }

        public void setSupportTransverseSlider(boolean supportTransverseSlider) {
            this.supportTransverseSlider = supportTransverseSlider;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public boolean isCustom() {
            return custom;
        }

        public void setCustom(boolean custom) {
            this.custom = custom;
        }
    }
}
