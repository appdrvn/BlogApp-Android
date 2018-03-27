package com.appdrvn.blogapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.delegates.GlideApp;
import com.appdrvn.blogapp.delegates.UtilityFunctions;
import com.appdrvn.blogapp.models.ActivityObject;

import java.util.ArrayList;

/**
 * Created by kelvynlaw on 13/02/2018.
 */

public class ActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    ArrayList<ActivityObject> data = new ArrayList<>();

    int galleryBannerHeight;

    public ActivityAdapter(Context context) {
        this.context = context;

        galleryBannerHeight = UtilityFunctions.getBannerHeight(UtilityFunctions.getScreenSize((Activity) context).x - (context.getResources().getDimensionPixelSize(R.dimen.activity_margin) * 3) - context.getResources().getDimensionPixelSize(R.dimen.double_activity_margin));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder vh = null;
        View v;
        switch (viewType) {
            case ActivityObject.TYPE_ARTICLE_POST:
                v = inflater.inflate(R.layout.item_activity_article_post, parent, false);
                vh = new ArticleViewHolder(v);
                break;
            case ActivityObject.TYPE_GALLERY_POST:
                v = inflater.inflate(R.layout.item_activity_gallery_post, parent, false);
                vh = new GalleryViewHolder(v);
                ((GalleryViewHolder) vh).vContentLayout.getLayoutParams().height = galleryBannerHeight;
                break;
            case ActivityObject.TYPE_LIKE:
                v = inflater.inflate(R.layout.item_activity_like, parent, false);
                vh = new LikeViewHolder(v);
                break;
            case ActivityObject.TYPE_COMMENT:
                v = inflater.inflate(R.layout.item_activity_comment, parent, false);
                vh = new CommentViewHolder(v);
                break;
        }
        return vh;
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ArticleViewHolder) {
            bindVH((ArticleViewHolder) holder, position);
        } else if (holder instanceof GalleryViewHolder) {
            bindVH((GalleryViewHolder) holder, position);
        } else if (holder instanceof LikeViewHolder) {
            bindVH((LikeViewHolder) holder, position);
        } else if (holder instanceof CommentViewHolder) {
            bindVH((CommentViewHolder) holder, position);
        }
    }

    private void bindVH(GalleryViewHolder holder, int position) {
        ActivityObject item = data.get(position);
        holder.tvTitle.setText(item.contentObject.title);
        holder.tvDate.setText(UtilityFunctions.formatEllapseTime(item.datetime, "dd MMM yyyy", context));
        GlideApp.with(context)
                .load(item.contentObject.thumbnail)
                .placeholder(R.drawable.img_placeholder_wide)
                .centerCrop()
                .into(holder.ivThumbnail);
    }

    private void bindVH(LikeViewHolder holder, int position) {
        ActivityObject item = data.get(position);
        holder.tvName.setText(item.contentObject.author.name);
        holder.tvTitle.setText(item.contentObject.title);
        holder.tvDate.setText(UtilityFunctions.formatEllapseTime(item.datetime, "dd MMM yyyy", context));

    }

    private void bindVH(ArticleViewHolder holder, int position) {
        ActivityObject item = data.get(position);
        holder.tvTitle.setText(item.contentObject.title);
        holder.tvDate.setText(UtilityFunctions.formatEllapseTime(item.datetime, "dd MMM yyyy", context));
        GlideApp.with(context)
                .load(item.contentObject.thumbnail)
                .placeholder(R.drawable.img_placeholder_wide)
                .centerCrop()
                .into(holder.ivThumbnail);
    }

    private void bindVH(CommentViewHolder holder, int position) {
        ActivityObject item = data.get(position);
        holder.tvName.setText(item.contentObject.author.name);
        holder.tvTitle.setText(item.contentObject.title);
        holder.tvDate.setText(UtilityFunctions.formatEllapseTime(item.datetime, "dd MMM yyyy", context));
        holder.tvComment.setText(context.getResources().getString(R.string.comment_placeholder,item.comment));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<ActivityObject> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void add(ArrayList<ActivityObject> data) {
        int startIndex = this.data.size();
        this.data.addAll(data);
        notifyItemRangeInserted(startIndex, data.size());
    }

    class LikeViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        TextView tvName, tvDate, tvTitle;

        public LikeViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            tvName = itemView.findViewById(R.id.name);
            tvDate = itemView.findViewById(R.id.date);
            tvTitle = itemView.findViewById(R.id.title);

        }
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        TextView tvName, tvDate, tvTitle, tvComment;

        public CommentViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            tvName = itemView.findViewById(R.id.name);
            tvDate = itemView.findViewById(R.id.date);
            tvTitle = itemView.findViewById(R.id.title);
            tvComment = itemView.findViewById(R.id.comment);

        }
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        TextView tvDate, tvTitle;
        ImageView ivThumbnail;
        View vContentLayout;

        public GalleryViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            vContentLayout = itemView.findViewById(R.id.content_layout);
            tvDate = itemView.findViewById(R.id.date);
            tvTitle = itemView.findViewById(R.id.title);
            ivThumbnail = itemView.findViewById(R.id.thumbnail);


        }
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        TextView tvDate, tvTitle;
        ImageView ivThumbnail;


        public ArticleViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            tvDate = itemView.findViewById(R.id.date);
            tvTitle = itemView.findViewById(R.id.title);
            ivThumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }
}
