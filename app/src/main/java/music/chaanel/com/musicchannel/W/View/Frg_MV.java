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
import music.chaanel.com.musicchannel.W.Beans.MVBean;
import music.chaanel.com.musicchannel.W.Beans.Urls;
import music.chaanel.com.musicchannel.W.Presenter.Presenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frg_MV extends Fragment implements BaseView, View.OnClickListener, PtrHandler {


    private ViewPager viewpager;
    private TabLayout tab;
    private TextView tv_time;
    private TextView tv_updatetime;
    private ViewPagerAdapter pagerAdapter;
    private Map<String,RecyclerAdapter> adapterMap;
    public static final int MV_TAG = 0;
    private Presenter presenter;
    private PtrFrameLayout frame;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.data_common, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterMap = new HashMap<>();
        viewpager = ((ViewPager) view.findViewById(R.id.viewpager_v));
//        ViewGroup.LayoutParams params = view.findViewById(R.id.time_layout).getLayoutParams();
//        ((AppBarLayout.LayoutParams) params).setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        tab = ((TabLayout) view.findViewById(R.id.tab_frgv));
        view.findViewById(R.id.tv_rules).setOnClickListener(this);
        tv_time = ((TextView) view.findViewById(R.id.tv_time));
        tv_updatetime = ((TextView) view.findViewById(R.id.tv_updatetime));
        List<View> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(getRecycler(i));
        }
        pagerAdapter = new ViewPagerAdapter(list,getActivity(),MV_TAG);
        viewpager.setOffscreenPageLimit(pagerAdapter.getCount());
        viewpager.setAdapter(pagerAdapter);
        tab.setupWithViewPager(viewpager);
        requestData();
    }

    private void requestData() {
        presenter = new Presenter(this, getActivity(),false);
        presenter.go(Urls.ml,0)
        .go(Urls.us,0)
        .go(Urls.jp,0)
        .go(Urls.kr,0)
        .go(Urls.gangtai,0);
    }

    private void requestDataForRefresh(String location){
        if(presenter==null)
            presenter = new Presenter(this,getActivity(),false);
        else
            presenter.go(location,0);
    }

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
        switch (tag) {
            case 0:
                adapterMap.put(Urls.ml,adapter);
                break;
            case 1:
                adapterMap.put(Urls.gangtai,adapter);
                break;
            case 2:
                adapterMap.put(Urls.us,adapter);
                break;
            case 3:
                adapterMap.put(Urls.kr,adapter);
                break;
            case 4:
                adapterMap.put(Urls.jp,adapter);
                break;
        }
        return layout;
    }

    @Override
    public void showData(BaseBean baseBean) {

    }

    @Override
    public void showData(BaseBean baseBean, String location) {

    }

    @Override
    public void showData(BaseBean baseBean,String location,boolean isAdd) {
        if(baseBean instanceof MVBean)
        {
            tv_time.setText(((MVBean) baseBean).getData().getDateCode()+" ");
            tv_updatetime.setText(((MVBean) baseBean).getData().getBeginDateText()+"  第"+((MVBean) baseBean).getData().getPeriods()+"期  ");
            adapterMap.get(location).refresh(((MVBean) baseBean).getData().getVideos());
        }
        if(frame!=null&&frame.isRefreshing())
            frame.refreshComplete();
    }

    @Override
    public void loadError(final String info) {
        if(frame!=null&&frame.isRefreshing())
            frame.refreshComplete();
        Toast.makeText(getActivity(),"网络异常",Toast.LENGTH_SHORT).show();
        if (adapterMap.get(info)!=null) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    requestDataForRefresh(info);
                }
            },3000);
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
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        try{
            if(content instanceof RecyclerView)
            {
            int position = ((LinearLayoutManager) ((RecyclerView) content).getLayoutManager()).findFirstVisibleItemPosition();
//                Log.e("自定义标签", "类名==Frg_MV" + "position  =  "+position);
//                Log.e("自定义标签", "类名==Frg_MV" + "getTop  =  " + ((RecyclerView) content).getChildAt(position).getTop());
                if (position==0&&((RecyclerView) content).getChildAt(position).getTop()>=8) {
                return true;
            }
        }}catch (Exception e){}
        return false;
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        this.frame = frame;
//        frame.refreshComplete();
        RecyclerAdapter adapter = (RecyclerAdapter) ((RecyclerView) frame.getChildAt(0)).getAdapter();
        String location;
        if(adapterMap.size()!=0)
        {
            Set<Map.Entry<String, RecyclerAdapter>> entries = adapterMap.entrySet();
            for (Map.Entry<String, RecyclerAdapter> entry : entries) {
                if(entry.getValue()==adapter)
                {
                    location=entry.getKey();
                    requestDataForRefresh(location);
                    break;
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        presenter.cancelAll();
        super.onDestroy();
    }
}
