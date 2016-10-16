package music.chaanel.com.musicchannel.W.Presenter;

import android.content.Context;
import android.widget.Toast;

import music.chaanel.com.musicchannel.W.Beans.CVCBean;
import music.chaanel.com.musicchannel.W.Moudel.BaseMoudel;
import music.chaanel.com.musicchannel.W.Moudel.cvcMoudel;
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


public class cvcPresenter extends BasePresenter implements OnLoadComplete<CVCBean>{
    public cvcPresenter(BaseView view, Context context) {
        super(view, context);
    }

    public cvcPresenter(BaseView view, Context context, boolean isAdd) {
        super(view, context, isAdd);
    }

    @Override
    public BasePresenter go(String location, int page) {
        cvcMoudel cvcMoudel = new cvcMoudel(location,page);
        cvcMoudel.getData(this);
        moudelMap.put(cvcMoudel, location);
        return this;
    }

    @Override
    public void callback(Response<CVCBean> response, BaseMoudel baseMoudel) {
        if (response.body() == null || response.body().getData() == null) {
            Toast.makeText(context, "解析数据出错", Toast.LENGTH_SHORT).show();
        } else
            view.showData(response.body(),moudelMap.get(baseMoudel),false);
    }

    @Override
    public void errorCallback(String info) {
        view.loadError(info);
    }
}
