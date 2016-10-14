package music.chaanel.com.musicchannel.W.Presenter;

import android.content.Context;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import music.chaanel.com.musicchannel.W.Beans.MVBean;
import music.chaanel.com.musicchannel.W.Moudel.BaseMoudel;
import music.chaanel.com.musicchannel.W.Moudel.mMoudel;
import music.chaanel.com.musicchannel.W.View.BaseView;
import retrofit2.Response;

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


public class Presenter implements OnLoadComplete<MVBean> {
    private BaseView view;
    private Context context;
    private Map<BaseMoudel, String> moudelMap;
    private boolean isAdd;

    public void setAdd(boolean add) {
        isAdd = add;
    }

    public boolean getAdd() {
        return isAdd;
    }

    public Presenter(BaseView view, Context context) {
        this.view = view;
        this.context = context;
        moudelMap = new HashMap<>();
    }

    public Presenter(BaseView view, Context context, boolean isAdd) {
        this.view = view;
        this.context = context;
        moudelMap = new HashMap<>();
        this.isAdd = isAdd;
    }

    public Presenter go(String location, int page) {
        mMoudel moudel = new mMoudel(location, page);
        moudel.getData(this);
        moudelMap.put(moudel, location);
        return this;
    }

    @Override
    public void callback(Response<MVBean> response, BaseMoudel baseMoudel) {
        if (response.body() == null || response.body().getData() == null) {
            Toast.makeText(context, "解析数据出错", Toast.LENGTH_SHORT).show();
        } else
            view.showData(response.body(), moudelMap.get(baseMoudel), isAdd);
    }

    @Override
    public void errorCallback(String info) {
        view.loadError(info);
    }

    public void cancelAll() {
        Set<BaseMoudel> baseMoudels = moudelMap.keySet();
        for (BaseMoudel baseMoudel : baseMoudels) {
            if (baseMoudel != null) {
                try {
                    ((mMoudel) baseMoudel).cancel();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

