package music.chaanel.com.musicchannel.utils;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/10/12.
 */

public class SceenUtil {
    public static int getWidth(Context context){
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();
        return width;
    }
}
