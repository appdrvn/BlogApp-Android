package com.appdrvn.blogapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.adapters.CommentsAdapter;
import com.appdrvn.blogapp.models.ArticleObject;
import com.appdrvn.blogapp.models.CommentObject;
import com.appdrvn.blogapp.widgets.DefaultListActivity;

import org.parceler.Parcels;

/**
 * Created by kelvynlaw on 12/02/2018.
 */

public class CommentsActivity extends DefaultListActivity {

    static final String INTENT_ARTICLE_OBJECT = "INTENT_ARTICLE_OBJECT";

    CommentsAdapter adapter;

    public static Intent newInstance(Context context, ArticleObject articleObject) {

        Intent intent = new Intent(context, CommentsActivity.class);
        intent.putExtra(INTENT_ARTICLE_OBJECT, Parcels.wrap(articleObject));
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        initToolBar(getResources().getString(R.string.comments),R.drawable.ic_back_white,backOnClickListener,-1,null);

        mRecyclerView = findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);

        adapter = new CommentsAdapter(CommentsActivity.this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(CommentsActivity.this));
        mRecyclerView.setAdapter(adapter);
        mSwipeRefreshLayout.setOnRefreshListener(refreshListener);

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
