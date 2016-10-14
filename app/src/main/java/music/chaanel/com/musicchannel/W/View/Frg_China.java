package music.chaanel.com.musicchannel.W.View;


import android.support.v4.app.Fragment;

import music.chaanel.com.musicchannel.W.Adapters.RecyclerAdapter;
import music.chaanel.com.musicchannel.W.Beans.BBBean;
import music.chaanel.com.musicchannel.W.Beans.BaseBean;
import music.chaanel.com.musicchannel.W.Beans.CVCBean;
import music.chaanel.com.musicchannel.W.Presenter.bbPresenter;
import music.chaanel.com.musicchannel.W.Presenter.cvcPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frg_China extends VFragment {

    private bbPresenter bbPresenter;

    @Override
    public void requestData() {
        presenter = new cvcPresenter(this,getActivity());
        presenter.go("cvc",0);
        bbPresenter = new bbPresenter(this,getActivity());
        bbPresenter.go("bb",0);
    }

    @Override
    public void requestDataForRefresh(String location) {
        if(presenter==null)
            presenter = new cvcPresenter(this,getActivity());
        if (bbPresenter==null)
            bbPresenter = new bbPresenter(this,getActivity());
        switch (location) {
            case "bb":
                bbPresenter.go("bb",0);
                break;
            case "cvc":
                presenter.go("cvc",0);
                break;
        }
    }

    @Override
    public void requestData(String location, String id, int page) {

    }

    @Override
    public void putTag(int tag, RecyclerAdapter adapter) {
        switch (tag) {
            case 0:
                adapterMap.put("cvc", adapter);
                break;
            case 1:
                adapterMap.put("bb",adapter);
                break;
        }
    }

    @Override
    public void setFragmentTag() {
        TAG = 2;
    }

    @Override
    public void setRecyclerviewCount() {
        recyclerviewCount = 2;
    }

    @Override
    public void showData(BaseBean baseBean, String location, boolean isAdd) {
        if(baseBean instanceof BBBean)
            adapterMap.get(location).refresh(((BBBean) baseBean).getData().getVideos());
        else if (baseBean instanceof CVCBean)
            adapterMap.get(location).refresh(((CVCBean) baseBean).getData().getVideos());
        if (frame != null && frame.isRefreshing())
            frame.refreshComplete();
    }

}
