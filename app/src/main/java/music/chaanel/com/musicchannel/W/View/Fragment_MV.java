package music.chaanel.com.musicchannel.W.View;

import android.support.v7.widget.RecyclerView;

import music.chaanel.com.musicchannel.W.Adapters.RecyclerAdapter;
import music.chaanel.com.musicchannel.W.Beans.BaseBean;
import music.chaanel.com.musicchannel.W.Beans.MVBean;
import music.chaanel.com.musicchannel.W.Beans.Urls;
import music.chaanel.com.musicchannel.W.Presenter.mvPresenter;

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


public class Fragment_MV extends VFragment {

    @Override
    public void requestData() {
        presenter = new mvPresenter(this, getActivity(), false);
        presenter.go(Urls.ml, 0)
                .go(Urls.us, 0)
                .go(Urls.jp, 0)
                .go(Urls.kr, 0)
                .go(Urls.gangtai, 0);
    }

    @Override
    public void requestDataForRefresh(String location) {
        {
            if(presenter==null)
                presenter = new mvPresenter(this,getActivity(),false);
            presenter.go(location,0);
        }
    }

    @Override
    public void requestData(String location, String id, int page) {
        if(presenter==null)
            presenter = new mvPresenter(this,getActivity(),false);
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
                adapterMap.put(Urls.ml, adapter);
                break;
            case 1:
                adapterMap.put(Urls.gangtai, adapter);
                break;
            case 2:
                adapterMap.put(Urls.us, adapter);
                break;
            case 3:
                adapterMap.put(Urls.kr, adapter);
                break;
            case 4:
                adapterMap.put(Urls.jp, adapter);
                break;
        }
    }

    @Override
    public void setFragmentTag() {
        TAG = 0;
    }

    @Override
    public void setRecyclerviewCount() {
        recyclerviewCount=5;
    }

    @Override
    public void showData(BaseBean baseBean, String location, boolean isAdd) {
        RecyclerAdapter adapter = adapterMap.get(location);
        if(baseBean!=null&&!adapter.isRefreshing)
        {
            tv_time.setText(((MVBean) baseBean).getData().getDateCode() + " ");
            tv_updatetime.setText(((MVBean) baseBean).getData().getBeginDateText() + "  第" + ((MVBean) baseBean).getData().getPeriods() + "期  ");
            adapter.refresh(((MVBean) baseBean).getData().getVideos());
        }else if(adapter.isRefreshing)
        {
            adapter.delete(adapter.getItemCount()-1);
            if(baseBean!=null)
                adapter.addAll(((MVBean) baseBean).getData().getVideos());
        }
        adapter.isRefreshing = false;
        if (frame != null && frame.isRefreshing())
            frame.refreshComplete();

    }
}
