package music.chaanel.com.musicchannel.homepage.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import music.chaanel.com.musicchannel.homepage.beans.HomeBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HOME_BEAN".
*/
public class HomeBeanDao extends AbstractDao<HomeBean, Long> {

    public static final String TABLENAME = "HOME_BEAN";

    /**
     * Properties of entity HomeBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property Code = new Property(1, int.class, "code", false, "CODE");
        public final static Property Msg = new Property(2, String.class, "msg", false, "MSG");
        public final static Property Now = new Property(3, String.class, "now", false, "NOW");
        public final static Property Cost = new Property(4, int.class, "cost", false, "COST");
    }

    private DaoSession daoSession;


    public HomeBeanDao(DaoConfig config) {
        super(config);
    }
    
    public HomeBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HOME_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: _id
                "\"CODE\" INTEGER NOT NULL ," + // 1: code
                "\"MSG\" TEXT," + // 2: msg
                "\"NOW\" TEXT," + // 3: now
                "\"COST\" INTEGER NOT NULL );"); // 4: cost
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HOME_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, HomeBean entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getCode());
 
        String msg = entity.getMsg();
        if (msg != null) {
            stmt.bindString(3, msg);
        }
 
        String now = entity.getNow();
        if (now != null) {
            stmt.bindString(4, now);
        }
        stmt.bindLong(5, entity.getCost());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, HomeBean entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getCode());
 
        String msg = entity.getMsg();
        if (msg != null) {
            stmt.bindString(3, msg);
        }
 
        String now = entity.getNow();
        if (now != null) {
            stmt.bindString(4, now);
        }
        stmt.bindLong(5, entity.getCost());
    }

    @Override
    protected final void attachEntity(HomeBean entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public HomeBean readEntity(Cursor cursor, int offset) {
        HomeBean entity = new HomeBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.getInt(offset + 1), // code
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // msg
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // now
            cursor.getInt(offset + 4) // cost
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, HomeBean entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCode(cursor.getInt(offset + 1));
        entity.setMsg(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setNow(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCost(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(HomeBean entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(HomeBean entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(HomeBean entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}