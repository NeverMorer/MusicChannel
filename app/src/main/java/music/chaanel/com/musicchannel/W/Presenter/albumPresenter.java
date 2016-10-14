package music.chaanel.com.musicchannel.W.Presenter;

import android.content.Context;
import android.widget.Toast;

import music.chaanel.com.musicchannel.W.Beans.AlbumBean;
import music.chaanel.com.musicchannel.W.Moudel.BaseMoudel;
import music.chaanel.com.musicchannel.W.Moudel.albumMoudel;
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


public class albumPresenter extends BasePresenter implements OnLoadComplete<AlbumBean>{
    public albumPresenter(BaseView view, Context context, boolean isAdd) {
        super(view, context, isAdd);
    }

    @Override
    public BasePresenter go(String location, int page) {
        albumMoudel albumMoudel = new albumMoudel(location,page);
        albumMoudel.getData(this);
        moudelMap.put(albumMoudel, location);
        return this;
    }

    public void goback(String location,int page,String id){
        albumMoudel albumMoudel = new albumMoudel(location,page,id);
        albumMoudel.getData(this);
        moudelMap.put(albumMoudel, location);
    }


    @Override
    public void callback(Response<AlbumBean> response, BaseMoudel baseMoudel) {
        if (response.body() == null || response.body().getData() == null) {
            Toast.makeText(context, "解析数据出错", Toast.LENGTH_SHORT).show();
        } else
            view.showData(response.body(), moudelMap.get(baseMoudel), isAdd);
    }

    @Override
    public void errorCallback(String info) {
        view.loadError(info);
    }
}
