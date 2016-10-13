package music.chaanel.com.musicchannel.homepage.dao;

import android.content.Context;

import music.chaanel.com.musicchannel.homepage.gen.DaoMaster;

/**
 * Created by Administrator on 2016/10/13.
 */

public class MyOpenHelper extends DaoMaster.OpenHelper {
    public MyOpenHelper(Context context, String name) {
        super(context, name);
    }
}
