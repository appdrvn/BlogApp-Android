package com.appdrvn.blogapp.adapters;

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
import com.appdrvn.blogapp.models.CommentObject;

import java.util.ArrayList;

/**
 * Created by kelvynlaw on 31/01/2018.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ItemViewHolder> {

    ArrayList<CommentObject> data = new ArrayList<>();

    Context context;

    int maximum = -1;

    public CommentsAdapter(Context context) {
        this(context, -1);
    }

    public CommentsAdapter(Context context, int maximum) {
        this.context = context;
        this.maximum = maximum;
    }

    @Override
    public CommentsAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_comment, parent, false);
        ItemViewHolder vh = new ItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.ItemViewHolder holder, int position) {
        CommentObject item = data.get(position);
        GlideApp.with(context)
                .load(item.commentor.profileImage)
                .placeholder(R.drawable.img_placeholder_wide)
                .circleCrop()
                .into(holder.ivProfilePicture);

        holder.tvName.setText(item.commentor.name);
        holder.tvComment.setText(context.getResources().getString(R.string.comment_placeholder, item.comment));
        holder.tvDatetime.setText(UtilityFunctions.formatEllapseTime(item.datetime, "dd MMM yyyy", context));
        if (position == getItemCount() - 1) {
            holder.vDiv.setVisibility(View.INVISIBLE);
        } else {
            holder.vDiv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        if (this.maximum == -1) {
            return data.size();
        } else {
            return data.size() > this.maximum ? this.maximum : data.size();
        }
    }

    public void setData(ArrayList<CommentObject> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void add(ArrayList<CommentObject> data) {
        int startIndex = this.data.size();
        this.data.addAll(data);
        notifyItemRangeInserted(startIndex, data.size());
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        ImageView ivProfilePicture;
        TextView tvName;
        TextView tvComment;
        TextView tvDatetime;
        View vDiv;

        public ItemViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            ivProfilePicture = itemView.findViewById(R.id.profile_picture);
            tvName = itemView.findViewById(R.id.name);
            tvComment = itemView.findViewById(R.id.comment);
            tvDatetime = itemView.findViewById(R.id.datetime);
            vDiv = itemView.findViewById(R.id.div);
        }
    }
}
