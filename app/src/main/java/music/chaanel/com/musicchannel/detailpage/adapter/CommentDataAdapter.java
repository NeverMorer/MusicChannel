package music.chaanel.com.musicchannel.detailpage.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import music.chaanel.com.musicchannel.R;
import music.chaanel.com.musicchannel.detailpage.beans.CommentVideoBean;
import music.chaanel.com.musicchannel.utils.MyCircleTransformation;

/**
 * Created by Administrator on 2016/10/15.
 */

public class CommentDataAdapter extends RecyclerView.Adapter<CommentDataAdapter.MyViewHolder>
        implements StickyRecyclerHeadersAdapter<DetailDataAdapter.MyViewHolder> {
    private List<CommentVideoBean.DataBean.CommentsBean> list;
    private Context context;
    private LayoutInflater inflater;
    private int[] ids = {
            R.layout.item_comment_head_detail,
            R.layout.item_comment_content_detail
    };
    private MyCircleTransformation myCircleTransformation;

    public CommentDataAdapter(List<CommentVideoBean.DataBean.CommentsBean> list,Context context,MyCircleTransformation myCircleTransformation) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.myCircleTransformation = myCircleTransformation;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 0:
                view = inflater.inflate(ids[0],parent,false);
                break;
            case 1:
                view = inflater.inflate(ids[1],parent,false);
                break;
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (position == 0) {

        }else{
            CommentVideoBean.DataBean.CommentsBean commentsBean = list.get(position - 1);
            holder.tv_name_comment.setText(commentsBean.getCommentUser().getNickName());
            holder.tv_content_comment.setText(commentsBean.getContent());
            holder.tv_ago_comment.setText(commentsBean.getDateCreated());
            holder.tv_like_comment.setText(commentsBean.getFloorInt()+"");
            holder.tv_content_comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View parent = ((View) view.getParent());
                    Log.e("xixixi", "onBindViewHolder: " + parent.getMeasuredHeight() +" " + parent.getHeight() +" "+ parent.getLayoutParams().height);
                }
            });
            Picasso.with(context)
                    .load(commentsBean.getCommentUser().getLargeAvatar())
                    //.transform(myCircleTransformation)
                    .into(holder.iv_avatar_comment);
        }
    }

    @Override
    public long getHeaderId(int position) {
        return 0;
    }

    @Override
    public DetailDataAdapter.MyViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = inflater.inflate(ids[0], parent, false);
        return new DetailDataAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(DetailDataAdapter.MyViewHolder holder, int position) {

    }


    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 0 : 1;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_avatar_comment)
        @Nullable
        ImageView iv_avatar_comment;
        @BindView(R.id.tv_content_comment)
        @Nullable
        TextView tv_content_comment;
        @BindView(R.id.tv_ago_comment)
        @Nullable
        TextView tv_ago_comment;
        @BindView(R.id.tv_like_comment)
        @Nullable
        TextView tv_like_comment;
        @BindView(R.id.tv_name_comment)
        @Nullable
        TextView tv_name_comment;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
