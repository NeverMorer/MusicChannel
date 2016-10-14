package music.chaanel.com.musicchannel.W.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import music.chaanel.com.musicchannel.R;
import music.chaanel.com.musicchannel.W.Beans.BaseBean;
import music.chaanel.com.musicchannel.W.Beans.MVBean;

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


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.mHolder> {

    private List<BaseBean> list;
    private Context context;

    public RecyclerAdapter(List<BaseBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public mHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(viewType, parent, false);
        return new mHolder(view);
    }

    @Override
    public void onBindViewHolder(mHolder holder, int position) {
        BaseBean bean = list.get(position);
        if(bean instanceof MVBean.DataBean.VideosBean)
        {
            holder.iv_albumimg.setImageURI(((MVBean.DataBean.VideosBean) bean).getAlbumImg());
            holder.tv_tittle.setText(((MVBean.DataBean.VideosBean) bean).getTitle());
            StringBuilder sb = new StringBuilder();
            for (MVBean.DataBean.VideosBean.ArtistsBean artistsBean : ((MVBean.DataBean.VideosBean) bean).getArtists()) {
                sb.append(artistsBean.getArtistName()).append(" ");
            }
            holder.tv_groupname.setText(sb.toString());
            holder.tv_num.setText(((MVBean.DataBean.VideosBean) bean).getExtend().getNumber());
            holder.tv_score.setText(((MVBean.DataBean.VideosBean) bean).getExtend().getScore());
            if (((MVBean.DataBean.VideosBean) bean).getExtend().isUp()) {
                holder.tv_double.setBackgroundResource(R.drawable.bg_red);
            }else {
                holder.tv_double.setBackgroundResource(R.drawable.bg_green);
            }
            holder.tv_double.setText(((MVBean.DataBean.VideosBean) bean).getExtend().getTrendScore());
        }
    }


    @Override
    public int getItemViewType(int position) {
        BaseBean baseBean = list.get(position);
        if(baseBean instanceof MVBean.DataBean.VideosBean)
            return R.layout.mv_inflated;
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    static class mHolder extends RecyclerView.ViewHolder{
        private TextView tv_groupname;
        private TextView tv_num;
        private TextView tv_score;
        private TextView tv_tittle;
        private TextView tv_double;
        private SimpleDraweeView iv_albumimg;

        public mHolder(View v) {
            super(v);
            tv_groupname = (TextView) v.findViewById(R.id.tv_grooupname);
            tv_num = (TextView) v.findViewById(R.id.tv_num);
            tv_score = ((TextView) v.findViewById(R.id.tv_score));
            tv_tittle = ((TextView) v.findViewById(R.id.tv_tiltle));
            tv_double = ((TextView) v.findViewById(R.id.tv_double));
            iv_albumimg = ((SimpleDraweeView) v.findViewById(R.id.iv_albumimg));
        }
    }

    public void addAll(List<BaseBean> list){
        this.list.addAll(list);
        notifyItemRangeInserted(this.list.size(),list.size());
    }

    public void add(BaseBean baseBean){
        list.add(baseBean);
        notifyItemInserted(list.size()-1);
    }

    public void add(BaseBean baseBean,int position)
    {
        list.add(position,baseBean);
        notifyItemInserted(position);
    }

    public void delete(int position)
    {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void clearAll(){
        int size = list.size();
        list.clear();
        notifyItemRangeRemoved(0,size-1);
    }

    public void refresh(List<? extends BaseBean> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}
