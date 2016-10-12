package music.chaanel.com.musicchannel.homepage.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import music.chaanel.com.musicchannel.R;
import music.chaanel.com.musicchannel.homepage.beans.HomeBean;
import music.chaanel.com.musicchannel.homepage.presenter.IHomePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment implements IHomeView{


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
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_home);
    }

    @Override
    public void showData(HomeBean homeBean) {

    }

    @Override
    public IHomePresenter getPresenter() {
        return null;
    }
}
