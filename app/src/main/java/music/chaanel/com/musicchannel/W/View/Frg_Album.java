package music.chaanel.com.musicchannel.W.View;


import android.support.v4.app.Fragment;

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
        ((albumPresenter) presenter).goback(location,page,id);
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
        adapterMap.get(location).refresh(((AlbumBean) baseBean).getData().getVideos());
//        btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                requestData(location,((AlbumBean) baseBean).getData().getPreId(),0);
//            }
//        });
        if (frame != null && frame.isRefreshing())
            frame.refreshComplete();
    }
}
