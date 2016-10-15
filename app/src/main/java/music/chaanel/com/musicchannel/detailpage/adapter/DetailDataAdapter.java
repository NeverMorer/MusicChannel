package music.chaanel.com.musicchannel.detailpage.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import music.chaanel.com.musicchannel.R;
import music.chaanel.com.musicchannel.detailpage.beans.CommentVideoBean;
import music.chaanel.com.musicchannel.detailpage.beans.DetailVideoBean;
import music.chaanel.com.musicchannel.homepage.beans.ArtistsBean;
import music.chaanel.com.musicchannel.homepage.beans.HomeDataBean;
import music.chaanel.com.musicchannel.utils.MyCircleTransformation;
import music.chaanel.com.musicchannel.utils.MyRoundedTransformation;
import music.chaanel.com.musicchannel.utils.SceenUtil;

/**
 * Created by Administrator on 2016/10/14.
 */

public class DetailDataAdapter extends RecyclerView.Adapter<DetailDataAdapter.MyViewHolder> {
    private DetailVideoBean detailVideoBean;
    private CommentVideoBean commentVideoBean;

    private Context context;
    private LayoutInflater inflater;
    private int[] ids = {
            R.layout.item_detail_barrage,
            R.layout.item_detail_content,
            R.layout.item_scroll_detail,
            R.layout.item_related_detail,
            R.layout.item_comment_head_detail,
            R.layout.item_comment_content_detail
    };

    public static final String TAG = "SUNCHAO";
    private MyCircleTransformation circle_trans;
    private MyRoundedTransformation round_trans;


    public DetailDataAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        circle_trans = new MyCircleTransformation();
        round_trans = new MyRoundedTransformation(5,0);
    }

    public void setData(DetailVideoBean detailVideoBean) {
        this.detailVideoBean = detailVideoBean;
        notifyDataSetChanged();
    }

    public void setCommentData(CommentVideoBean commentVideoBean) {
        this.commentVideoBean = commentVideoBean;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 1:
                view = inflater.inflate(ids[0], parent, false);
                break;
            case 2:
                view = inflater.inflate(ids[1], parent, false);
                break;
            case 3:
                view = inflater.inflate(ids[2], parent, false);
                break;
            case 4:
                view = inflater.inflate(ids[3], parent, false);
                break;
            case 5:
                view = inflater.inflate(ids[4], parent, false);
                break;
        }
        if (viewType > 5) {
            view = inflater.inflate(ids[5], parent, false);
        }
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DetailVideoBean.DataBean data = detailVideoBean.getData();
        switch (position) {
            case 0:
                break;
            case 1:
                holder.iv_expend.setOnClickListener(holder);
                holder.iv_expend.setTag(0);
                holder.tv_singer.setText(data.getArtistName());
                holder.tv_content.setText(data.getDesc());
                holder.tv_date.setText(data.getRegdate());
                holder.tv_artist.setText(data.getCreator().getNickName());
                holder.tv_playtimes.setText("播放数: " + data.getTotalView() + "");
                Picasso.with(context)
                        .load(data.getArtists().get(0).getArtistAvatar())
                        .transform(circle_trans)
                        .into(holder.iv_avatar);

                break;
            case 2:
                List<HomeDataBean> mostPeopleVideos = data.getMostPeopleVideos();
                if (holder.container_scroll_detail.getChildCount() > 0) {
                    return;
                }
                for (HomeDataBean mostPeopleVideo : mostPeopleVideos) {
                    View view = inflater.inflate(R.layout.item_list_home, holder.container_scroll_detail, false);
                    ImageView iv = (ImageView) view.findViewById(R.id.iv_list_home);
                    TextView tv_name = (TextView) view.findViewById(R.id.tv_name_list_home);
                    TextView tv_author = (TextView) view.findViewById(R.id.tv_author_list_home);
                    TextView tv_playtimes = (TextView) view.findViewById(R.id.tv_playtimes_list_home);
                    tv_name.setTextColor(Color.WHITE);
                    tv_name.setTextSize(14);
                    tv_author.setTextSize(12);
                    round_trans = new MyRoundedTransformation(5,0);
                    Picasso.with(context).load(mostPeopleVideo.getPosterPic())
                            .placeholder(R.mipmap.ad_video_default)
                            .transform(round_trans)
                            .into(iv);
                    tv_name.setText(mostPeopleVideo.getTitle());
                    List<ArtistsBean> artists = mostPeopleVideo.getArtists();
                    if (artists != null && artists.size() > 0) {
                        tv_author.setText(artists.get(0).getArtistName());
                    }
                    tv_playtimes.setText("播放量: " + mostPeopleVideo.getTotalView());
                    holder.container_scroll_detail.addView(view);
                }
                break;
            case 3:
                if (holder.container_related_detail.getChildCount() > 0) {
                    return;
                }
                List<HomeDataBean> relatedPlayList = data.getRelatedVideos();
                for (HomeDataBean relatedPlayListBean : relatedPlayList) {
                    View view = inflater.inflate(R.layout.item_list_home, holder.container_related_detail, false);
                    ImageView iv = (ImageView) view.findViewById(R.id.iv_list_home);
                    TextView tv_name = (TextView) view.findViewById(R.id.tv_name_list_home);
                    TextView tv_author = (TextView) view.findViewById(R.id.tv_author_list_home);
                    TextView tv_playtimes = (TextView) view.findViewById(R.id.tv_playtimes_list_home);
                    tv_name.setTextColor(Color.WHITE);
                    tv_name.setTextSize(14);
                    tv_author.setTextSize(12);
                    Picasso.with(context).load(relatedPlayListBean.getPosterPic())
                            .placeholder(R.mipmap.ad_video_default)
                            .transform(round_trans)
                            .into(iv);
                    tv_name.setText(relatedPlayListBean.getTitle());
                    List<ArtistsBean> artists = relatedPlayListBean.getArtists();
                    if (artists != null && artists.size() > 0) {
                        tv_author.setText(artists.get(0).getArtistName());
                    }
                    tv_playtimes.setText("播放量: " + relatedPlayListBean.getTotalView());
                    int width = SceenUtil.getWidth(context);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width / 2 - 5, ViewGroup.LayoutParams.WRAP_CONTENT);
                    holder.container_related_detail.addView(view, layoutParams);
                }
                break;
            case 4:
                break;
        }
        if (position > 4) {

            CommentVideoBean.DataBean.CommentsBean commentsBean = commentVideoBean.getData().getComments().get(position - 5);
            holder.tv_name_comment.setText(commentsBean.getCommentUser().getNickName());
            holder.tv_content_comment.setText(commentsBean.getContent());
            holder.tv_ago_comment.setText(commentsBean.getDateCreated());
            holder.tv_like_comment.setText(commentsBean.getFloorInt()+"");
            circle_trans = new MyCircleTransformation();
            Picasso.with(context)
                    .load(commentsBean.getCommentUser().getLargeAvatar())
                    .transform(circle_trans)
                    .into(holder.iv_avatar_comment);
        }
    }



    @Override
    public int getItemCount() {
        int count = detailVideoBean == null ? 0 : (ids.length - 1) + (commentVideoBean == null ? 0 : 10);
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        return position + 1;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Nullable
        @BindView(R.id.tv_singer_detail)
        TextView tv_singer;
        @BindView(R.id.tv_playtimes_detail)
        @Nullable
        TextView tv_playtimes;
        @BindView(R.id.tv_content_detail)
        @Nullable
        TextView tv_content;
        @BindView(R.id.tv_artist_detail)
        @Nullable
        TextView tv_artist;
        @BindView(R.id.tv_date_detail)
        @Nullable
        TextView tv_date;
        @BindView(R.id.iv_icon_avatar)
        @Nullable
        ImageView iv_avatar;
        @BindView(R.id.iv_expend_detail)
        @Nullable
        ImageView iv_expend;

        @BindView(R.id.container_scroll_detail)
        @Nullable
        LinearLayout container_scroll_detail;

        @BindView(R.id.container_related_home)
        @Nullable
        GridLayout container_related_detail;

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
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv_expend_detail:
                    switch (((int) view.getTag())) {
                        case 0:
                            tv_content.setMaxLines(100);
                            iv_expend.setBackgroundResource(R.mipmap.video_img_show_desc);
                            view.setTag(1);
                            break;
                        case 1:
                            tv_content.setMaxLines(2);
                            iv_expend.setBackgroundResource(R.mipmap.video_img_hide_desc);
                            view.setTag(0);
                            break;
                    }

                    break;
            }

        }
    }
}
