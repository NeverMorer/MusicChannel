package music.chaanel.com.musicchannel.detailpage.view;

import music.chaanel.com.musicchannel.detailpage.beans.CommentVideoBean;
import music.chaanel.com.musicchannel.detailpage.beans.DetailVideoBean;
import music.chaanel.com.musicchannel.detailpage.presenter.IDetailPresenter;

/**
 * Created by Administrator on 2016/10/13.
 */

public interface IDetailView<P extends IDetailPresenter> {
    void showData(DetailVideoBean detailVideoBean);
    void showData(CommentVideoBean commentVideoBean);
    void failedToShow(Throwable t);
    P getPresenter();
}
