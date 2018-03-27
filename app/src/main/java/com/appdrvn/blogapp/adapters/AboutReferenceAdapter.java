package com.appdrvn.blogapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.delegates.UtilityFunctions;
import com.appdrvn.blogapp.models.AboutReference;

import java.util.ArrayList;

/**
 * Created by kelvynlaw on 30/09/2017.
 */

public class AboutReferenceAdapter extends RecyclerView.Adapter<AboutReferenceAdapter.ItemViewHolder> {

    ArrayList<AboutReference> mData = new ArrayList<>();
    Context context;

    public AboutReferenceAdapter(Context context, ArrayList<AboutReference> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public AboutReferenceAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AboutReferenceAdapter.ItemViewHolder vh;
        View v = inflater.inflate(R.layout.item_about_references, parent, false);
        vh = new AboutReferenceAdapter.ItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AboutReferenceAdapter.ItemViewHolder holder, int position) {
        AboutReference item = mData.get(position);
        holder.tvTitle.setText(item.title);
        holder.tvSubtitle.setText(item.subtitle);
        holder.rootView.setOnClickListener(itemClickListener);
        holder.rootView.setTag(item.url);
    }

    @Override
    public int getItemCount() {
        return mData.size();

    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    View.OnClickListener itemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url = view.getTag().toString();
            context.startActivity(UtilityFunctions.openBrowserIntent(url));
        }
    };


    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSubtitle;
        View rootView;

        public ItemViewHolder(View convertView) {
            super(convertView);
            rootView = convertView;
            tvTitle = convertView.findViewById(R.id.title);
            tvSubtitle = convertView.findViewById(R.id.subtitle);
        }
    }
}