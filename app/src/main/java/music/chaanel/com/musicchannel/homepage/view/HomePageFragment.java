package music.chaanel.com.musicchannel.homepage.view;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import music.chaanel.com.musicchannel.R;
import music.chaanel.com.musicchannel.homepage.adapter.HomeDataAdapter;
import music.chaanel.com.musicchannel.homepage.beans.HomeBean;
import music.chaanel.com.musicchannel.homepage.beans.HomeWrapBean;
import music.chaanel.com.musicchannel.homepage.dao.GreenDaoManager;
import music.chaanel.com.musicchannel.homepage.gen.DaoSession;
import music.chaanel.com.musicchannel.homepage.gen.HomeBeanDao;
import music.chaanel.com.musicchannel.homepage.presenter.HomePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment implements IHomeView<HomePresenter>, SwipeRefreshLayout.OnRefreshListener {
    private HomePresenter presenter;
    private RecyclerView recyclerView;
    private HomeDataAdapter homeDataAdapter;
    private SwipeRefreshLayout swipe;

    public static final String TAG = "SUNCHAO";

    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        presenter = getPresenter();
        presenter.bingView(this);
        swipe = ((SwipeRefreshLayout) view.findViewById(R.id.swipe_home));
        swipe.setOnRefreshListener(this);
        recyclerView = ((RecyclerView) view.findViewById(R.id.recycler_home));
        homeDataAdapter = new HomeDataAdapter(getContext());
        recyclerView.setAdapter(homeDataAdapter);
        getDataFromDb();
        swipe.setRefreshing(true);
        presenter.handleData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void showData(HomeBean homeBean) {
        swipe.setRefreshing(false);
        homeDataAdapter.setData(homeBean.getData());
        Toast.makeText(getContext(), "读取数据成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failedToShow(Throwable t) {
        swipe.setRefreshing(false);
        Toast.makeText(getContext(), "当前网络不佳", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "failedToShow: ",t);
    }

    @Override
    public HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unBindView();
    }

    @Override
    public void onRefresh() {
        presenter.handleData();
    }

    public void getDataFromDb(){
        DaoSession session = GreenDaoManager.getInstance().getSession();
        HomeBeanDao homeBeanDao = session.getHomeBeanDao();
        HomeBean unique = homeBeanDao.queryBuilder()
                .where(HomeBeanDao.Properties._id.eq(2l))
                .build()
                .unique();
        //unique.__setDaoSession(session);
        if (unique != null) {
            List<HomeWrapBean> data = unique.getData();
            homeDataAdapter.setData(data);
        }
    }
}
