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
import com.appdrvn.blogapp.models.ArticleObject;
import com.appdrvn.blogapp.models.ContentObject;

import java.util.ArrayList;

/**
 * Created by kelvynlaw on 31/01/2018.
 */

public class ContentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    static final int ARTICLE_VIEW_TYPE = 1;
    static final int GALLERY_VIEW_TYPE = 2;

    View.OnClickListener itemClickListener;

    ArrayList<ContentObject> data = new ArrayList<>();
    Context context;
    int bannerHeight = 0;

    public ContentsAdapter(Context context) {
        this.context = context;
        bannerHeight = (int)(((double) UtilityFunctions.getScreenSize((Activity) context).x) / 16d * 9d);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder vh;
        if (viewType == ARTICLE_VIEW_TYPE) {
            View v = inflater.inflate(R.layout.item_article, parent, false);
            vh = new ArticleViewHolder(v);
        } else {
            View v = inflater.inflate(R.layout.item_gallery, parent, false);
            vh = new GalleryViewHolder(v,bannerHeight);
        }
        return vh;
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof ArticleObject) {
            return ARTICLE_VIEW_TYPE;
        } else {
            return GALLERY_VIEW_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ArticleViewHolder) {
            bindViewHolder((ArticleViewHolder)holder,position);
        }else if(holder instanceof GalleryViewHolder){
            bindViewHolder((GalleryViewHolder)holder,position);
        }
    }

    public void bindViewHolder(ArticleViewHolder holder,int position){
        ContentObject item = data.get(position);
        GlideApp.with(context)
                .load(item.thumbnail)
                .placeholder(R.drawable.img_placeholder_wide)
                .centerCrop()
                .into(holder.ivThumbnail);

        holder.tvTitle.setText(item.title);
        holder.tvDateTime.setText(UtilityFunctions.formatEllapseTime(item.datetime,"dd MMM yyyy", context));
        holder.tvAuthor.setText(item.author.name);
        holder.rootView.setTag(item);
        holder.rootView.setOnClickListener(itemClickListener);
    }

    public void bindViewHolder(GalleryViewHolder holder, int position){
        ContentObject item = data.get(position);
        GlideApp.with(context)
                .load(item.thumbnail)
                .placeholder(R.drawable.img_placeholder_wide)
                .centerCrop()
                .into(holder.ivThumbnail);

        holder.tvTitle.setText(item.title);
        holder.tvDateTime.setText(UtilityFunctions.formatEllapseTime(item.datetime,"dd MMM yyyy", context));
        holder.tvAuthor.setText(item.author.name);
        holder.rootView.setTag(item);
        holder.rootView.setOnClickListener(itemClickListener);
    }

    public void setItemClickListener(View.OnClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<ContentObject> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        ImageView ivThumbnail;
        TextView tvTitle, tvDateTime, tvAuthor;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            ivThumbnail = itemView.findViewById(R.id.thumbnail);
            tvTitle = itemView.findViewById(R.id.title);
            tvDateTime = itemView.findViewById(R.id.datetime);
            tvAuthor = itemView.findViewById(R.id.author);
        }
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        ImageView ivThumbnail;
        TextView tvTitle, tvDateTime, tvAuthor;

        public GalleryViewHolder(View itemView, int bannerHeight) {
            super(itemView);
            rootView = itemView;
            ivThumbnail = itemView.findViewById(R.id.thumbnail);
            tvTitle = itemView.findViewById(R.id.title);
            tvDateTime = itemView.findViewById(R.id.datetime);
            tvAuthor = itemView.findViewById(R.id.author);
            ivThumbnail.getLayoutParams().height = bannerHeight;
        }
    }
}
