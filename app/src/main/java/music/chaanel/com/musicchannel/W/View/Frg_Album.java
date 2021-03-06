package music.chaanel.com.musicchannel.W.View;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import music.chaanel.com.musicchannel.W.Adapters.RecyclerAdapter;
import music.chaanel.com.musicchannel.W.Beans.AlbumBean;
import music.chaanel.com.musicchannel.W.Beans.BaseBean;
import music.chaanel.com.musicchannel.W.Beans.Urls;
import music.chaanel.com.musicchannel.W.Presenter.albumPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frg_Album extends VFragment {

    @Override
    public void requestData() {
        if (presenter == null)
            presenter = new albumPresenter(this, getActivity(), false);
        presenter.go(Urls.neidi, 0).go(Urls.jinkou, 0);
    }

    @Override
    public void requestDataForRefresh(String location) {
        if (presenter == null)
            presenter = new albumPresenter(this, getActivity(), false);
        presenter.go(location, 0);
    }

    @Override
    public void requestData(String location, String id, int page) {
        if (presenter == null)
            presenter = new albumPresenter(this, getActivity(), false);
        presenter.go(location,page);
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
                adapterMap.put(Urls.neidi, adapter);
                break;
            case 1:
                adapterMap.put(Urls.jinkou, adapter);
                break;
        }
    }

    @Override
    public void setFragmentTag() {
        TAG = 1;
    }

    @Override
    public void setRecyclerviewCount() {
        recyclerviewCount = 2;
    }

    @Override
    public void showData(final BaseBean baseBean, final String location, boolean isAdd) {
        RecyclerAdapter adapter = adapterMap.get(location);
        if(!adapter.isRefreshing&&baseBean!=null)
        {
            adapter.refresh(((AlbumBean) baseBean).getData().getVideos());
        }else if(adapter.isRefreshing)
        {
            adapter.delete(adapter.getItemCount()-1);
            if(baseBean!=null)
                adapter.addAll(((AlbumBean) baseBean).getData().getVideos());
        }
        adapter.isRefreshing = false;
        if (frame != null && frame.isRefreshing())
            frame.refreshComplete();
    }
}
