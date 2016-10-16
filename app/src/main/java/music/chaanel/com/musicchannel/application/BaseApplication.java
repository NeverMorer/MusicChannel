package music.chaanel.com.musicchannel.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import music.chaanel.com.musicchannel.homepage.dao.GreenDaoManager;

/**
 * Created by Administrator on 2016/10/13.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GreenDaoManager.init(this);
        Fresco.initialize(this);
    }
}
