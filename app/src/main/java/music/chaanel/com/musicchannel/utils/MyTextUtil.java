package music.chaanel.com.musicchannel.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/14.
 */

public class MyTextUtil {
    public static String getPlayTime(int ms){
        Date date = new Date(ms);
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        String format = sdf.format(date);
        return format;
    }
}
