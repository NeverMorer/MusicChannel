package music.chaanel.com.musicchannel.homepage.beans;

import android.support.annotation.Nullable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import music.chaanel.com.musicchannel.homepage.gen.DaoSession;
import music.chaanel.com.musicchannel.homepage.gen.HomeDataBeanDao;
import music.chaanel.com.musicchannel.homepage.gen.HomeWrapBeanDao;

/**
 * Created by Administrator on 2016/10/12.
 */
@Entity
public class HomeWrapBean {
    /**
     * {
     "type":1,
     "title":"首图轮播",
     "showTitle":false,
     "size":10,
     "moreData":{
     "supportPage":false,
     "supportTransverseSlider":false,
     "show":false
     },
     "data":Array[10],
     "pathKey":"CAROUSEL"
     }
     */
    @Id(autoincrement = true)
    private Long id;
    @Nullable
    private Long homeId;

    private int type;
    private String title;
    private String showTitle;
    private int size;

    @Transient
    private MoreData moreData;
    @ToMany(referencedJoinProperty = "homeWrapId")
    private List<HomeDataBean> data;
    private String pathKey;
    private String enTitle;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 2096654460)
    private transient HomeWrapBeanDao myDao;



    @Generated(hash = 1148245333)
    public HomeWrapBean(Long id, Long homeId, int type, String title, String showTitle, int size,
            String pathKey, String enTitle) {
        this.id = id;
        this.homeId = homeId;
        this.type = type;
        this.title = title;
        this.showTitle = showTitle;
        this.size = size;
        this.pathKey = pathKey;
        this.enTitle = enTitle;
    }

    @Generated(hash = 281844610)
    public HomeWrapBean() {
    }



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MoreData getMoreData() {
        return moreData;
    }

    public void setMoreData(MoreData moreData) {
        this.moreData = moreData;
    }

   

    public void setData(List<HomeDataBean> data) {
        this.data = data;
    }

    public String getPathKey() {
        return pathKey;
    }

    public void setPathKey(String pathKey) {
        this.pathKey = pathKey;
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 560118040)
    public List<HomeDataBean> getData() {
        if (data == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HomeDataBeanDao targetDao = daoSession.getHomeDataBeanDao();
            List<HomeDataBean> dataNew = targetDao._queryHomeWrapBean_Data(id);
            synchronized (this) {
                if (data == null) {
                    data = dataNew;
                }
            }
        }
        return data;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1283600904)
    public synchronized void resetData() {
        data = null;
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



    public void setId(Long id) {
        this.id = id;
    }

    public void setHomeId(Long homeId) {
        this.homeId = homeId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 732850570)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHomeWrapBeanDao() : null;
    }

    public Long getId() {
        return this.id;
    }

    public Long getHomeId() {
        return this.homeId;
    }

    public static class MoreData{
        /**
         * "supportPage":false,
         "supportTransverseSlider":false,
         "show":false
         */

        private boolean supportPage;
        private boolean supportTransverseSlider;
        private boolean show;

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

        public boolean isShow() {
            return show;
        }

        public void setShow(boolean show) {
            this.show = show;
        }
    }

}
