package com.appdrvn.blogapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.delegates.GlideApp;

/**
 * Created by kelvynlaw on 12/02/2018.
 */

public class GalleryThumbnailAdapter extends RecyclerView.Adapter<GalleryThumbnailAdapter.ItemViewHolder> {

    String[] data = new String[0];

    Context context;

    int paddingSize = 0;
    int selectedIndex = 0;

    View.OnClickListener itemClickListener;

    public GalleryThumbnailAdapter(Context context) {
        this.context = context;
        paddingSize = context.getResources().getDimensionPixelSize(R.dimen.half_activity_margin);
    }

    @Override
    public GalleryThumbnailAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_gallery_thumbnail, parent, false);
        GalleryThumbnailAdapter.ItemViewHolder vh = new GalleryThumbnailAdapter.ItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(GalleryThumbnailAdapter.ItemViewHolder holder, int position) {
        GlideApp.with(context)
                .load(data[position])
                .placeholder(R.drawable.img_placeholder_wide)
                .centerCrop()
                .into(holder.ivThumbnail);

        holder.rootView.setSelected(position == selectedIndex);

        holder.rootView.setTag(position);
        holder.rootView.setOnClickListener(itemClickListener);
    }

    public void setSelected(int target) {
        if (selectedIndex >= 0) {
            notifyItemChanged(selectedIndex);
        }
        selectedIndex = target;
        notifyItemChanged(selectedIndex);
    }

    public void setItemClickListener(View.OnClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public void setData(String[] data) {
        this.data = data;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        ImageView ivThumbnail;

        public ItemViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            ivThumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
