package music.chaanel.com.musicchannel.homepage.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import music.chaanel.com.musicchannel.R;
import music.chaanel.com.musicchannel.homepage.beans.ArtistsBean;
import music.chaanel.com.musicchannel.homepage.beans.HomeDataBean;
import music.chaanel.com.musicchannel.homepage.beans.HomeWrapBean;
import music.chaanel.com.musicchannel.homepage.utils.SceenUtil;

/**
 * Created by Administrator on 2016/10/12.
 */

public class HomeDataAdapter extends RecyclerView.Adapter<HomeDataAdapter.MyViewHolder> {

    private List<HomeWrapBean> list;
    private Context context;
    private LayoutInflater inflater;
    private int[] ids = {
            R.layout.item_home_vp,
            R.layout.layout_group_home,
            R.layout.layout_list_home
    };

    public HomeDataAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        list = new ArrayList<>();
        this.context = context;
    }

    public void setData(List<HomeWrapBean> list){
        this.list.clear();
        this.list = list;
        notifyDataSetChanged();

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("sunc", "onCreateViewHolder: " );
        View view;
        MyViewHolder holder = null;
        switch (viewType) {
            case 1:
                view = inflater.inflate(ids[0],parent,false);
                holder = new MyViewHolder(view);
                holder.setType(1);
                break;
            case 2:
                view = inflater.inflate(ids[1],parent,false);
                holder = new MyViewHolder(view);
                holder.setType(2);
                break;
            case 6:
                view = inflater.inflate(ids[2],parent,false);
                holder = new MyViewHolder(view);
                holder.setType(6);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (holder == null) {
            return;
        }
        HomeWrapBean homeWrapBean = list.get(position);
        List<HomeDataBean> data = homeWrapBean.getData();
        switch (holder.getType()) {
            case 1:
                HomePagerAdapter homePagerAdapter = new HomePagerAdapter(data, context);
                holder.viewPager.setAdapter(homePagerAdapter);
                holder.progressBar.setMax(data.size());
                holder.viewPager.addOnPageChangeListener(holder);
                holder.startScroll();
                break;
            case 2:
                Picasso.with(context).load(homeWrapBean.getData().get(0).getIcon()).into(holder.iv_group_1);
                Picasso.with(context).load(homeWrapBean.getData().get(1).getIcon()).into(holder.iv_group_2);
                Picasso.with(context).load(homeWrapBean.getData().get(2).getIcon()).into(holder.iv_group_3);
                holder.tv_group_1.setText(homeWrapBean.getData().get(0).getTitle());
                holder.tv_group_2.setText(homeWrapBean.getData().get(1).getTitle());
                holder.tv_group_3.setText(homeWrapBean.getData().get(2).getTitle());

                break;
            case 6:
                if (holder.container_list.getChildCount() > 0) {
                    holder.container_list.removeAllViews();
                }
                holder.tv_title_list.setText(homeWrapBean.getTitle());
                holder.tv_sub_list.setText(homeWrapBean.getEnTitle());
                List<HomeDataBean> list_hdb = homeWrapBean.getData();
                for (int i = 0; i < list_hdb.size(); i++) {
                    View view = inflater.inflate(R.layout.item_list_home, holder.container_list, false);
                    ImageView iv = (ImageView) view.findViewById(R.id.iv_list_home);
                    TextView tv_name = (TextView) view.findViewById(R.id.tv_name_list_home);
                    TextView tv_author = (TextView) view.findViewById(R.id.tv_author_list_home);
                    TextView tv_playtimes = (TextView) view.findViewById(R.id.tv_playtimes_list_home);
                    HomeDataBean homeDataBean = list_hdb.get(i);
                    Picasso.with(context).load(homeDataBean.getPosterPic()).into(iv);
                    tv_name.setText(homeDataBean.getTitle());
                    List<ArtistsBean> artists = homeDataBean.getArtists();
                    if (artists != null && artists.size() > 0) {
                        tv_author.setText(artists.get(0).getArtistName());
                    }
                    tv_playtimes.setText("播放量: "+homeDataBean.getTotalView());
                    int width = SceenUtil.getWidth(context);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width / 2, ViewGroup.LayoutParams.WRAP_CONTENT);
                    holder.container_list.addView(view,layoutParams);
                }
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        Log.e("sunc", "getItemViewType: "+ position);
        int type = list.get(position).getType();
        return type;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements ViewPager.OnPageChangeListener {

        private int type;
        @BindView(R.id.vp_home)
        @Nullable
        ViewPager viewPager;

        @BindView(R.id.iv_group_home_1)
        @Nullable
        ImageView iv_group_1;
        @BindView(R.id.iv_group_home_2)
        @Nullable
        ImageView iv_group_2;
        @BindView(R.id.iv_group_home_3)
        @Nullable
        ImageView iv_group_3;
        @BindView(R.id.tv_group_home_1)
        @Nullable
        TextView tv_group_1;
        @BindView(R.id.tv_group_home_2)
        @Nullable
        TextView tv_group_2;
        @BindView(R.id.tv_group_home_3)
        @Nullable
        TextView tv_group_3;

        @BindView(R.id.pb)
        @Nullable
        ProgressBar progressBar;

        @BindView(R.id.tv_title_list_home)
        @Nullable
        TextView tv_title_list;
        @BindView(R.id.tv_sub_list_home)
        @Nullable
        TextView tv_sub_list;
        @BindView(R.id.container_list_home)
        @Nullable
        GridLayout container_list;

        private Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 100:
                        int currentItem = viewPager.getCurrentItem();
                        if (currentItem == viewPager.getAdapter().getCount()-1) {
                            currentItem = -1;
                        }
                        viewPager.setCurrentItem(currentItem + 1,true);
                        sendEmptyMessageDelayed(100,3000);
                        break;
                }
            }
        };


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            progressBar.setProgress(position+1);
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        public void startScroll(){
            handler.removeMessages(100);
            handler.sendEmptyMessageDelayed(100,2000);
        }
    }
}
