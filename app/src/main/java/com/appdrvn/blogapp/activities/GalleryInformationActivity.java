package com.appdrvn.blogapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.adapters.CommentsAdapter;
import com.appdrvn.blogapp.delegates.UtilityFunctions;
import com.appdrvn.blogapp.models.CommentObject;
import com.appdrvn.blogapp.models.GalleryObject;
import com.appdrvn.blogapp.widgets.DefaultListActivity;

import org.parceler.Parcels;

/**
 * Created by kelvynlaw on 12/02/2018.
 */

public class GalleryInformationActivity extends DefaultListActivity {

    static final String INTENT_GALLERY_OBJECT = "INTENT_GALLERY_OBJECT";

    CommentsAdapter adapter;

    GalleryObject galleryObject = new GalleryObject();

    public static Intent newInstance(Context context, GalleryObject galleryObject) {

        Intent intent = new Intent(context, GalleryInformationActivity.class);
        intent.putExtra(INTENT_GALLERY_OBJECT, Parcels.wrap(galleryObject));
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_information);
        galleryObject = Parcels.unwrap(getIntent().getParcelableExtra(INTENT_GALLERY_OBJECT));

        initToolBar(getResources().getString(R.string.information), R.drawable.ic_back_white, backOnClickListener, -1, null);

        mRecyclerView = findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        TextView tvTitle = findViewById(R.id.title);
        TextView tvAuthor = findViewById(R.id.author);
        TextView tvDate = findViewById(R.id.date);


        adapter = new CommentsAdapter(GalleryInformationActivity.this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(GalleryInformationActivity.this));
        mRecyclerView.setAdapter(adapter);
        mSwipeRefreshLayout.setOnRefreshListener(refreshListener);

        tvTitle.setText(galleryObject.title);
        tvAuthor.setText(galleryObject.author.name);
        tvDate.setText(UtilityFunctions.formatEllapseTime(galleryObject.datetime, "dd MMM yyyy", GalleryInformationActivity.this));

        setupLoadMore();
    }

    @Override
    public void loadData() {
        finishLoading();
        if (mCurrentPage == 1) {
            adapter.setData(CommentObject.createDummy(10));
        } else if (mCurrentPage == 15) {
            isLastPage = true;
            adapter.add(CommentObject.createDummy(10));
        } else {
            adapter.add(CommentObject.createDummy(10));
        }
    }


}
