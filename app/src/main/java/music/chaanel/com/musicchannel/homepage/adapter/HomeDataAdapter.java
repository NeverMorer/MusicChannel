package music.chaanel.com.musicchannel.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import music.chaanel.com.musicchannel.detailpage.view.DetailActivity;
import music.chaanel.com.musicchannel.homepage.beans.ArtistsBean;
import music.chaanel.com.musicchannel.homepage.beans.HomeDataBean;
import music.chaanel.com.musicchannel.homepage.beans.HomeWrapBean;
import music.chaanel.com.musicchannel.utils.SceenUtil;

/**
 * Created by Administrator on 2016/10/12.
 */

public class HomeDataAdapter extends RecyclerView.Adapter<HomeDataAdapter.MyViewHolder> implements View.OnClickListener {

    private List<HomeWrapBean> list;
    private Context context;
    private LayoutInflater inflater;
    private int[] ids = {
            R.layout.item_home_vp,
            R.layout.layout_group_home,
            R.layout.layout_list_home
    };
    private RecyclerView recyclerView;

    public HomeDataAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        list = new ArrayList<>();
        this.context = context;
    }

    public void setData(List<HomeWrapBean> list){
        if (this.list.size() > 0) {
            this.list.clear();
            this.list = list;
            notifyItemRangeChanged(0,list.size()-1);
        }else{
            this.list.clear();
            this.list = list;
            notifyItemRangeInserted(0,list.size()-1);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
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
                //view.setOnClickListener(this);
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
                Picasso.with(context).load(homeWrapBean.getData().get(0).getIcon()).placeholder(R.mipmap.ad_video_default).into(holder.iv_group_1);
                Picasso.with(context).load(homeWrapBean.getData().get(1).getIcon()).placeholder(R.mipmap.ad_video_default).into(holder.iv_group_2);
                Picasso.with(context).load(homeWrapBean.getData().get(2).getIcon()).placeholder(R.mipmap.ad_video_default).into(holder.iv_group_3);
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
                    iv.setTag(i);
                    iv.setOnClickListener(this);
                    TextView tv_name = (TextView) view.findViewById(R.id.tv_name_list_home);
                    TextView tv_author = (TextView) view.findViewById(R.id.tv_author_list_home);
                    TextView tv_playtimes = (TextView) view.findViewById(R.id.tv_playtimes_list_home);
                    HomeDataBean homeDataBean = list_hdb.get(i);
                    Picasso.with(context).load(homeDataBean.getPosterPic()).placeholder(R.mipmap.ad_video_default).into(iv);
                    tv_name.setText(homeDataBean.getTitle());
                    List<ArtistsBean> artists = homeDataBean.getArtists();
                    if (artists != null && artists.size() > 0) {
                        tv_author.setText(artists.get(0).getArtistName());
                    }
                    tv_playtimes.setText("播放量: "+homeDataBean.getTotalView());
                    int width = SceenUtil.getWidth(context);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width / 2 - 5, ViewGroup.LayoutParams.WRAP_CONTENT  );
                    holder.container_list.addView(view,layoutParams);
                }
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        int type = list.get(position).getType();
        return type;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        int position = recyclerView.getChildAdapterPosition((View) view.getParent().getParent().getParent());
        HomeDataBean homeDataBean = list.get(position).getData().get(((int) view.getTag()));
        String type = homeDataBean.getType();
        if (!TextUtils.isEmpty(type)) {
            Long videoId = homeDataBean.getVideoId();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("id",videoId+"");
            intent.putExtra("type",1);

            context.startActivity(intent);
        }

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
