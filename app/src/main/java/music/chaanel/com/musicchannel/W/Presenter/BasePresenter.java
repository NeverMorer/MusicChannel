package music.chaanel.com.musicchannel.W.Presenter;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import music.chaanel.com.musicchannel.W.Moudel.BaseMoudel;
import music.chaanel.com.musicchannel.W.View.BaseView;

/**
 * /**
 * <p>
 * ----------Dragon be here!----------/
 * 　　　 ┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 */


public abstract class BasePresenter {
    public BaseView view;
    public Context context;
    public Map<BaseMoudel, String> moudelMap;
    public boolean isAdd;

    public void setAdd(boolean add) {
        isAdd = add;
    }

    public boolean getAdd() {
        return isAdd;
    }

    public BasePresenter(BaseView view, Context context) {
        this.view = view;
        this.context = context;
        moudelMap = new HashMap<>();
    }

    public BasePresenter(BaseView view, Context context, boolean isAdd) {
        this.view = view;
        this.context = context;
        moudelMap = new HashMap<>();
        this.isAdd = isAdd;
    }

    abstract public BasePresenter go(String location, int page);

    public void cancelAll() {
        Set<BaseMoudel> baseMoudels = moudelMap.keySet();
        for (BaseMoudel baseMoudel : baseMoudels) {
            if (baseMoudel != null) {
                try {
                    baseMoudel.cancel();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
