package music.chaanel.com.musicchannel.homepage.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import music.chaanel.com.musicchannel.gen.DaoSession;
import music.chaanel.com.musicchannel.gen.HomeWrapBeanDao;
import music.chaanel.com.musicchannel.gen.HomeBeanDao;

/**
 * Created by Administrator on 2016/10/12.
 */
@Entity
public class HomeBean {
    /**
     * {
     "code":"0",
     "msg":"SUCCESS",
     "now":1476235356810,
     "data":Array[9],
     "cost":46
     }
     */

    @Id
    private Long _id;
    private int code;
    private String msg;
    private String now;

    @ToMany(referencedJoinProperty = "homeId")
    private List<HomeWrapBean> data;

    private int cost;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1933114728)
    private transient HomeBeanDao myDao;

    @Generated(hash = 1994914113)
    public HomeBean(Long _id, int code, String msg, String now, int cost) {
        this._id = _id;
        this.code = code;
        this.msg = msg;
        this.now = now;
        this.cost = cost;
    }

    @Generated(hash = 931577662)
    public HomeBean() {
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNow() {
        return this.now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 234746536)
    public List<HomeWrapBean> getData() {
        if (data == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HomeWrapBeanDao targetDao = daoSession.getHomeWrapBeanDao();
            List<HomeWrapBean> dataNew = targetDao._queryHomeBean_Data(_id);
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

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 369277473)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHomeBeanDao() : null;
    }


}
