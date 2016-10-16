package music.chaanel.com.musicchannel.homepage.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pools;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import music.chaanel.com.musicchannel.R;
import music.chaanel.com.musicchannel.detailpage.view.DetailActivity;
import music.chaanel.com.musicchannel.homepage.beans.HomeDataBean;

/**
 * Created by Administrator on 2016/10/12.
 */

public class HomePagerAdapter extends PagerAdapter implements View.OnClickListener {
    private List<HomeDataBean> list;
    private Pools.Pool<View> pool ;
    private Context context;
    private LayoutInflater inflater;

    public HomePagerAdapter(List<HomeDataBean> list, Context context) {
        this.list = list;
        this.context = context;
        pool = new Pools.SimplePool<>(list.size());
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        HomeDataBean homeDataBean = list.get(position);
        View acquire = pool.acquire();
        if (acquire == null) {
            acquire = inflater.inflate(R.layout.item_pager_home,container,false);
            //acquire.setOnClickListener(this);
            acquire.setTag(position);
        }
        ImageView imageView = (ImageView) acquire.findViewById(R.id.iv_pager_home);
        ImageView iv_type = (ImageView) acquire.findViewById(R.id.iv_type_page_home);
        Picasso.with(context)
                .load(homeDataBean.getPosterPic())
                .placeholder(R.drawable.ad_video_default)
                .into(imageView);
        Picasso.with(context)
                .load(homeDataBean.getDataTypeUrl())
                .into(iv_type);
        container.addView(acquire);
        return acquire;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        pool.release((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        HomeDataBean homeDataBean = list.get(position);
        String type = homeDataBean.getType();
        if (!TextUtils.isEmpty(type)) {
            Long videoId = homeDataBean.getVideoId();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("id",videoId+"");

            context.startActivity(intent);
        }

    }

}
