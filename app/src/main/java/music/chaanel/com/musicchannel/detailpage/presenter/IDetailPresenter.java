package music.chaanel.com.musicchannel.detailpage.presenter;

import music.chaanel.com.musicchannel.detailpage.view.IDetailView;

/**
 * Created by Administrator on 2016/10/13.
 */

public interface IDetailPresenter {
    void bingView(IDetailView view);
    void unBindView();
    void handleData(String videoId,int type);
    void handleCommentData(String videoId);
}
