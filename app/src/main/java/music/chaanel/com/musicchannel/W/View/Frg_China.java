package music.chaanel.com.musicchannel.W.View;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

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
        switch (location) {
            case "cvc":
                RecyclerAdapter adapter = adapterMap.get(location);
                adapter.delete(adapter.getItemCount()-1);
                break;
            case "bb":
                presenter = new bbPresenter(this,getActivity());
                presenter.go(location,page);
                break;
        }
    }

    @Override
    protected void Scrolled(RecyclerView recyclerView, int dx, int dy) {

    }

    @Override
    public void ScrollStateChanged(RecyclerView recyclerView, int newState) {

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
        RecyclerAdapter adapter = adapterMap.get(location);
        if (baseBean!=null&&!adapter.isRefreshing)
        {
            if(baseBean instanceof BBBean)
                adapter.refresh(((BBBean) baseBean).getData().getVideos());
            else if (baseBean instanceof CVCBean)
                adapter.refresh(((CVCBean) baseBean).getData().getVideos());
        }else if(adapter.isRefreshing)
        {
            adapter.delete(adapter.getItemCount()-1);
            switch (location) {
                case "cvc":
                    break;
                case "bb":
                    if(baseBean!=null)
                        adapter.addAll(((BBBean) baseBean).getData().getVideos());
                    break;
            }
        }
        adapter.isRefreshing = false;
        if (frame != null && frame.isRefreshing())
            frame.refreshComplete();
    }

}
