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
import music.chaanel.com.musicchannel.W.Beans.AlbumBean;
import music.chaanel.com.musicchannel.W.Beans.BBBean;
import music.chaanel.com.musicchannel.W.Beans.BaseBean;
import music.chaanel.com.musicchannel.W.Beans.CVCBean;
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
        if(viewType!=-1)
        {
            View view = LayoutInflater.from(context).inflate(viewType, parent, false);
            return new mHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(mHolder holder, int position) {
        if (holder==null)
            return;
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
        }else if (bean instanceof AlbumBean.DataBean.VideosBean)
        {
            holder.tv_tittle_alb.setText(((AlbumBean.DataBean.VideosBean) bean).getTitle());
            holder.album_cover.setImageURI(((AlbumBean.DataBean.VideosBean) bean).getPosterPic());
            holder.album_cover_sm.setImageURI(((AlbumBean.DataBean.VideosBean) bean).getPosterPic());
            holder.tv_name.setText(((AlbumBean.DataBean.VideosBean) bean).getArtistName());
            holder.tv_num.setText(((AlbumBean.DataBean.VideosBean) bean).getRank());
//            if(((AlbumBean.DataBean.VideosBean) bean).getRank().equals("1"))
//            {
//                holder.tv_num.setTextColor(context.getResources().getColor(R.color.PINK));
//            }
//            else if(((AlbumBean.DataBean.VideosBean) bean).getRank().equals("2"))
//            {
//                holder.tv_num.setTextColor(context.getResources().getColor(R.color.BLUE));
//            }else if(((AlbumBean.DataBean.VideosBean) bean).getRank().equals("3"))
//            {
//                holder.tv_num.setTextColor(context.getResources().getColor(R.color.GREEN3));
//            }else {
//                holder.tv_num.setTextColor(context.getResources().getColor(R.color.GRAY));
//            }
            setColor(holder.tv_num,((AlbumBean.DataBean.VideosBean) bean).getRank());
            if (((AlbumBean.DataBean.VideosBean) bean).isLatest())
            {
                holder.iv_new.setVisibility(View.VISIBLE);
            }
        }else if (bean instanceof CVCBean.DataBean.VideosBean)
        {
            holder.tv_tittle_cvc.setText(((CVCBean.DataBean.VideosBean) bean).getTitle());
            holder.cvc_cover.setImageURI(((CVCBean.DataBean.VideosBean) bean).getAlbumImg());
            StringBuilder sb = new StringBuilder();
            for (CVCBean.DataBean.VideosBean.ArtistsBean artistsBean:((CVCBean.DataBean.VideosBean) bean).getArtists()) {
                sb.append(artistsBean.getArtistName()).append(" ");
            }
            holder.tv_name_cvc.setText(sb.toString());
            holder.tv_score_cvc.setText(((CVCBean.DataBean.VideosBean) bean).getExtend().getScore());
            holder.tv_num_cvc.setText(((CVCBean.DataBean.VideosBean) bean).getExtend().getNumber());
            setColor(holder.tv_num_cvc,((CVCBean.DataBean.VideosBean) bean).getExtend().getNumber());
            setColor(holder.tv_score_cvc,((CVCBean.DataBean.VideosBean) bean).getExtend().getNumber());
        }else if(bean instanceof BBBean.DataBean.VideosBean)
        {
            holder.bb_cover.setImageURI(((BBBean.DataBean.VideosBean) bean).getPosterPic());
            holder.tv_num_bb.setText(((BBBean.DataBean.VideosBean) bean).getExtend().getNumber());
            setColor(holder.tv_num_bb,((BBBean.DataBean.VideosBean) bean).getExtend().getNumber());
            holder.tv1_bb.setText(((BBBean.DataBean.VideosBean) bean).getTitle());
            StringBuilder sb = new StringBuilder();
            for (BBBean.DataBean.VideosBean.ArtistsBean artistsBean:((BBBean.DataBean.VideosBean) bean).getArtists()) {
                sb.append(artistsBean.getArtistName()).append(" ");
            }
            holder.tv2_bb.setText(sb.toString());
            holder.tv3_bb.setText("LAST WEEK: "+((BBBean.DataBean.VideosBean) bean).getExtend().getHistoryCount());
            holder.tv4_bb.setText("PEAK POSITION: "+((BBBean.DataBean.VideosBean) bean).getExtend().getBestPosition());
            holder.tv5_bb.setText("WKS ON CHART: "+((BBBean.DataBean.VideosBean) bean).getExtend().getPrePosition());
        }
    }

    public void setColor(TextView tv,String rank){
        if(rank.equals("1"))
        {
            tv.setTextColor(context.getResources().getColor(R.color.PINK));
        }
        else if(rank.equals("2"))
        {
            tv.setTextColor(context.getResources().getColor(R.color.BLUE));
        }else if(rank.equals("3"))
        {
            tv.setTextColor(context.getResources().getColor(R.color.GREEN3));
        }else {
            tv.setTextColor(context.getResources().getColor(R.color.GRAY));
        }
    }


    @Override
    public int getItemViewType(int position) {
        BaseBean baseBean = list.get(position);
        if(baseBean instanceof MVBean.DataBean.VideosBean)
            return R.layout.mv_inflated;
        else if(baseBean instanceof AlbumBean.DataBean.VideosBean)
            return R.layout.album_inflated;
        else if(baseBean instanceof CVCBean.DataBean.VideosBean)
            return R.layout.cvc_inflated;
        else if(baseBean instanceof BBBean.DataBean.VideosBean)
            return R.layout.bb_inflated;
        return -1;
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    static class mHolder extends RecyclerView.ViewHolder{
        private final TextView tv3_bb;
        private final TextView tv4_bb;
        private final TextView tv5_bb;
        private TextView tv2_bb;
        private TextView tv_groupname;
        private TextView tv_num;
        private TextView tv_score;
        private TextView tv_tittle;
        private TextView tv_double;
        private SimpleDraweeView iv_albumimg;
        private TextView tv_name;
        private View iv_hot;
        private View iv_new;
        private SimpleDraweeView album_cover_sm;
        private SimpleDraweeView album_cover;
        private TextView tv_tittle_alb;
        private SimpleDraweeView cvc_cover;
        private TextView tv_name_cvc;
        private TextView tv_num_cvc;
        private TextView tv_score_cvc;
        private TextView tv_tittle_cvc;
        private SimpleDraweeView bb_cover;
        private TextView tv_num_bb;
        private TextView tv1_bb;

        public mHolder(View v) {
            super(v);
            tv_groupname = (TextView) v.findViewById(R.id.tv_grooupname);
            tv_num = (TextView) v.findViewById(R.id.tv_num);
            tv_score = ((TextView) v.findViewById(R.id.tv_score));
            tv_tittle = ((TextView) v.findViewById(R.id.tv_tiltle));
            tv_double = ((TextView) v.findViewById(R.id.tv_double));
            iv_albumimg = ((SimpleDraweeView) v.findViewById(R.id.iv_albumimg));
            tv_name = ((TextView) v.findViewById(R.id.tv_name));
            iv_hot = ((View) v.findViewById(R.id.iv_hot));
            iv_new = ((View) v.findViewById(R.id.iv_new));
            album_cover_sm = ((SimpleDraweeView) v.findViewById(R.id.album_cover_sm));
            album_cover = ((SimpleDraweeView) v.findViewById(R.id.album_cover));
            tv_tittle_alb = ((TextView) v.findViewById(R.id.tv_tittle_alb));
            cvc_cover = ((SimpleDraweeView) v.findViewById(R.id.cvc_cover));
            tv_name_cvc = ((TextView) v.findViewById(R.id.tv_name_cvc));
            tv_num_cvc = ((TextView) v.findViewById(R.id.tv_num_cvc));
            tv_score_cvc = ((TextView) v.findViewById(R.id.tv_score_cvc));
            tv_tittle_cvc = ((TextView) v.findViewById(R.id.tv_tittle_cvc));
            bb_cover = ((SimpleDraweeView) v.findViewById(R.id.bb_cover));
            tv_num_bb = ((TextView) v.findViewById(R.id.tv_num_bb));
            tv1_bb = ((TextView) v.findViewById(R.id.tv1_bb));
            tv2_bb = ((TextView) v.findViewById(R.id.tv2_bb));
            tv3_bb = ((TextView) v.findViewById(R.id.tv3_bb));
            tv4_bb = ((TextView) v.findViewById(R.id.tv4_bb));
            tv5_bb = ((TextView) v.findViewById(R.id.tv5_bb));
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
