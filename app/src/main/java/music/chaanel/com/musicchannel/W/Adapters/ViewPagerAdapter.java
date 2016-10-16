package music.chaanel.com.musicchannel.W.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;

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


public class ViewPagerAdapter extends PagerAdapter {
    private List<View> list;
    private Context context;
    private int tag = -1;

    public ViewPagerAdapter(List<View> list, Context context ,int tag) {
        this.list = list;
        this.context = context;
        this.tag = tag;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) list.get(position);
        container.addView(ptrClassicFrameLayout);
        return ptrClassicFrameLayout;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (tag) {
            case 0:
                switch (position) {
                    case 0:
                        return "内地";
                    case 1:
                        return "港台";
                    case 2:
                        return "欧美";
                    case 3:
                        return "韩国";
                    case 4:
                        return "日本";
                }
                break;
            case 1:
                switch (position) {
                    case 0:
                        return "内地专辑销量榜";
                    case 1:
                        return "进口专辑销量榜";
                }
                break;

            case 2:
                switch (position) {
                    case 0:
                        return "CHINA VCHART TOP 30";
                    case 1:
                        return "Billboard THE HOT 100";
                }
                break;
            default:
                break;
        }
        return "";
    }
}
