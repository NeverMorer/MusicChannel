package music.chaanel.com.musicchannel.W.View;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import music.chaanel.com.musicchannel.R;
import music.chaanel.com.musicchannel.W.Adapters.RecyclerAdapter;
import music.chaanel.com.musicchannel.W.Adapters.ViewPagerAdapter;
import music.chaanel.com.musicchannel.W.Beans.BaseBean;
import music.chaanel.com.musicchannel.W.Beans.Refresh;
import music.chaanel.com.musicchannel.W.Presenter.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class VFragment extends Fragment implements PtrHandler, View.OnClickListener,BaseView {
    ViewPager viewpager;
    TabLayout tab;
    TextView tv_time;
    TextView tv_updatetime;
    ViewPagerAdapter pagerAdapter;
    Map<String,RecyclerAdapter> adapterMap;
    public static int TAG;
    BasePresenter presenter;
    PtrFrameLayout frame;
    int recyclerviewCount;
    View btn_back;
    View btn_go;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.data_common, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setFragmentTag();
        setRecyclerviewCount();
        adapterMap = new HashMap<>();
        viewpager = ((ViewPager) view.findViewById(R.id.viewpager_v));
//        ViewGroup.LayoutParams params = view.findViewById(R.id.time_layout).getLayoutParams();
//        ((AppBarLayout.LayoutParams) params).setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        btn_back = ((View) view.findViewById(R.id.btn_back));
        btn_go = ((View) view.findViewById(R.id.btn_go));
        tab = ((TabLayout) view.findViewById(R.id.tab_frgv));
        view.findViewById(R.id.tv_rules).setOnClickListener(this);
        tv_time = ((TextView) view.findViewById(R.id.tv_time));
        tv_updatetime = ((TextView) view.findViewById(R.id.tv_updatetime));
        List<View> list = new ArrayList<>();
        for (int i = 0; i < recyclerviewCount; i++) {
            list.add(getRecycler(i));
        }
        pagerAdapter = new ViewPagerAdapter(list,getActivity(),TAG);
        viewpager.setOffscreenPageLimit(pagerAdapter.getCount());
        viewpager.setAdapter(pagerAdapter);
        tab.setupWithViewPager(viewpager);
        requestData();
    }

    abstract public void requestData();

    abstract public void requestDataForRefresh(String location);

    public void requestData(String location,String id)
    {

    }

    abstract public void requestData(String location,String id,int page);

    private PtrClassicFrameLayout getRecycler(int tag) {
        PtrClassicFrameLayout layout = (PtrClassicFrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview, null);
        layout.setPtrHandler(this);
        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<BaseBean> list = new ArrayList<>();
        RecyclerAdapter adapter = new RecyclerAdapter(list,getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                ScrollStateChanged(recyclerView,newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                RecyclerAdapter recyclerAdapter = (RecyclerAdapter) recyclerView.getAdapter();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                int itemCount = recyclerAdapter.getItemCount();
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                if(!recyclerAdapter.isRefreshing&&recyclerAdapter.hasMore&&itemCount - lastVisibleItemPosition<=3)
                {
                    for (Map.Entry<String, RecyclerAdapter> entry : adapterMap.entrySet()) {
                        if(entry.getValue()==recyclerAdapter)
                        {
                            recyclerAdapter.add(new Refresh());
                            requestData(entry.getKey(),"",itemCount);
                            recyclerAdapter.isRefreshing = true;
                        }
                    }
                }
                Scrolled(recyclerView, dx, dy);
            }
        });
        putTag(tag, adapter);
        return layout;
    }

    protected abstract void Scrolled(RecyclerView recyclerView, int dx, int dy);

    abstract public void ScrollStateChanged(RecyclerView recyclerView, int newState);

    abstract public void putTag(int tag, RecyclerAdapter adapter);

    abstract public void setFragmentTag();

    abstract public void setRecyclerviewCount();

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        try {
            if (content instanceof RecyclerView) {
                int position = ((LinearLayoutManager) ((RecyclerView) content).getLayoutManager()).findFirstVisibleItemPosition();
//                Log.e("自定义标签", "类名==Frg_MV" + "position  =  "+position);
//                Log.e("自定义标签", "类名==Frg_MV" + "getTop  =  " + ((RecyclerView) content).getChildAt(position).getTop());
                if (position == 0 && ((RecyclerView) content).getChildAt(position).getTop() >= 0) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        this.frame = frame;
//        frame.refreshComplete();
        RecyclerAdapter adapter = (RecyclerAdapter) ((RecyclerView) frame.getChildAt(0)).getAdapter();
        String location;
        if (adapterMap.size() != 0) {
            Set<Map.Entry<String, RecyclerAdapter>> entries = adapterMap.entrySet();
            for (Map.Entry<String, RecyclerAdapter> entry : entries) {
                if (entry.getValue() == adapter) {
                    location = entry.getKey();
                    requestDataForRefresh(location);
                    break;
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_rules:

                break;
        }
    }

    @Override
    public void showData(BaseBean baseBean) {

    }

    @Override
    public void showData(BaseBean baseBean, String location) {

    }

    @Override
    public void showData(BaseBean baseBean, String location, boolean isAdd) {

    }

    @Override
    public void loadError(final String info) {
        if (frame != null && frame.isRefreshing())
            frame.refreshComplete();
        Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT).show();
        if (adapterMap.get(info) != null) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    requestDataForRefresh(info);
                }
            }, 3000);
        }
    }

    @Override
    public void onDestroy() {
        presenter.cancelAll();
        super.onDestroy();
    }
}
