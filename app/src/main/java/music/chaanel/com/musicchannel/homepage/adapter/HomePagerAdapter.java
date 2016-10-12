package music.chaanel.com.musicchannel.homepage.adapter;

import android.content.Context;
import android.support.v4.util.Pools;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import music.chaanel.com.musicchannel.R;
import music.chaanel.com.musicchannel.homepage.beans.HomeDataBean;

/**
 * Created by Administrator on 2016/10/12.
 */

public class HomePagerAdapter extends PagerAdapter {
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
        }
        ImageView imageView = (ImageView) acquire.findViewById(R.id.iv_pager_home);
        Picasso.with(context)
                .load(homeDataBean.getPosterPic())
                .placeholder(R.drawable.ad_video_default)
                .into(imageView);

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
}
