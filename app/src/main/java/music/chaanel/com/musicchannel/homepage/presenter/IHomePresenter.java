package music.chaanel.com.musicchannel.homepage.presenter;

import music.chaanel.com.musicchannel.homepage.view.IHomeView;

/**
 * Created by Administrator on 2016/10/12.
 */

public interface IHomePresenter {
    void bingView(IHomeView view);
    void unBindView();
    void handleData();
    IHomeView getView();
}
