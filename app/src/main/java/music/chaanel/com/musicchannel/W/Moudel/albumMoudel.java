package music.chaanel.com.musicchannel.W.Moudel;

import music.chaanel.com.musicchannel.W.Beans.AlbumBean;
import music.chaanel.com.musicchannel.W.Servers.UrlServer;
import retrofit2.Call;

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


public class albumMoudel extends BaseMoudel<AlbumBean> {
    String id;

    public albumMoudel(String location, int page) {
        super(location, page);
    }

    public albumMoudel(String location,int page,String id)
    {
        super(location,page);
        this.id = id;
    }

    @Override
    public Call<AlbumBean> getCall(UrlServer urlServer) {
        return urlServer.getAlbum(page,20,location,id);
    }
}
