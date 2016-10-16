package music.chaanel.com.musicchannel.W.Presenter;

import android.content.Context;
import android.widget.Toast;

import music.chaanel.com.musicchannel.W.Beans.BBBean;
import music.chaanel.com.musicchannel.W.Moudel.BaseMoudel;
import music.chaanel.com.musicchannel.W.Moudel.bbMoudel;
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


public class bbPresenter extends BasePresenter implements OnLoadComplete<BBBean>{
    public bbPresenter(BaseView view, Context context) {
        super(view, context);
    }

    @Override
    public BasePresenter go(String location, int page) {
        bbMoudel bbMoudel = new bbMoudel(location,page);
        bbMoudel.getData(this);
        moudelMap.put(bbMoudel, location);
        return null;
    }

    @Override
    public void callback(Response<BBBean> response, BaseMoudel baseMoudel) {
        if (response.body() == null || response.body().getData() == null) {
            Toast.makeText(context, "没有更多数据了", Toast.LENGTH_SHORT).show();
            view.showData(null,moudelMap.get(baseMoudel),false);
        } else
            view.showData(response.body(),moudelMap.get(baseMoudel),false);
    }

    @Override
    public void errorCallback(String info) {
        view.loadError(info);
    }
}
