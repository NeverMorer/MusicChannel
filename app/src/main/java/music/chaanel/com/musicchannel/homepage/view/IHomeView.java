package music.chaanel.com.musicchannel.homepage.view;

import music.chaanel.com.musicchannel.homepage.beans.HomeBean;
import music.chaanel.com.musicchannel.homepage.presenter.IHomePresenter;

/**
 * Created by Administrator on 2016/10/12.
 */

public interface IHomeView<P extends IHomePresenter> {
    void showData(HomeBean homeBean);
    void failedToShow(Throwable t);
    P getPresenter();
}
