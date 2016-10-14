package music.chaanel.com.musicchannel.homepage.dao;

import android.content.Context;

import music.chaanel.com.musicchannel.homepage.gen.DaoMaster;
import music.chaanel.com.musicchannel.homepage.gen.DaoSession;

/**
 * Created by Administrator on 2016/10/13.
 */

public class GreenDaoManager {

    private static GreenDaoManager instance;
    private DaoSession session;
    private DaoMaster daoMaster;


    private GreenDaoManager(Context context) {
        MyOpenHelper myOpenHelper = new MyOpenHelper(context, "home");
        daoMaster = new DaoMaster(myOpenHelper.getWritableDatabase());
        session = daoMaster.newSession();
    }

    public static GreenDaoManager getInstance(){
        if (instance != null) {
            return instance;
        }
        return null;
    }

    public DaoSession getSession(){
        if (session == null) {
            session = daoMaster.newSession();
        }
        return session;
    }

    public static void init(Context context){
        if (instance == null) {
            instance = new GreenDaoManager(context);
        }
    }

}
