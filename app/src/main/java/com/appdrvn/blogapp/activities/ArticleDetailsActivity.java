package com.appdrvn.blogapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.adapters.CommentsAdapter;
import com.appdrvn.blogapp.delegates.Constants;
import com.appdrvn.blogapp.delegates.GlideApp;
import com.appdrvn.blogapp.delegates.UtilityFunctions;
import com.appdrvn.blogapp.models.ArticleObject;
import com.appdrvn.blogapp.widgets.DefaultActivity;
import com.appdrvn.blogapp.widgets.ViewLargeImageActivity;

import org.parceler.Parcels;

/**
 * Created by kelvynlaw on 31/01/2018.
 */

public class ArticleDetailsActivity extends DefaultActivity {

    static final String INTENT_ARTICLE_OBJECT = "INTENT_ARTICLE_OBJECT";

    ArticleObject articleObject = new ArticleObject();

    TextView tvTitle, tvEmphasiveDescription, tvDescription, tvMoreComments, tvDate, tvToolbarTitle, tvAuthorName;
    ImageView ivThumbnail;
    RecyclerView recyclerView;
    NestedScrollView scrollView;
    View vToolbar;

    CommentsAdapter adapter;

    public static Intent newInstance(Context context, ArticleObject article) {

        Intent intent = new Intent(context, ArticleDetailsActivity.class);
        intent.putExtra(INTENT_ARTICLE_OBJECT, Parcels.wrap(article));
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        articleObject = Parcels.unwrap(getIntent().getParcelableExtra(INTENT_ARTICLE_OBJECT));

        initToolBar(articleObject.title, R.drawable.ic_back_white, backOnClickListener, R.drawable.ic_share_white, shareClickListener);
        setRightExtraIcon(R.drawable.ic_like_white,likeClickListener);
        adapter = new CommentsAdapter(ArticleDetailsActivity.this, Constants.DETAILS_PAGE_COMMENTS_LIMIT);


        tvToolbarTitle = findViewById(R.id.action_bar_title_text);
        tvTitle = findViewById(R.id.title);
        tvAuthorName = findViewById(R.id.author);
        tvDate = findViewById(R.id.date);
        tvEmphasiveDescription = findViewById(R.id.description_emphasize);
        tvDescription = findViewById(R.id.description);
        tvMoreComments = findViewById(R.id.more_comments);
        ivThumbnail = findViewById(R.id.thumbnail);
        recyclerView = findViewById(R.id.recycler_view);
        tvMoreComments = findViewById(R.id.more_comments);
        scrollView = findViewById(R.id.scroll_view);
        vToolbar = findViewById(R.id.toolbar);
        vToolbar = findViewById(R.id.toolbar);

        tvMoreComments.setOnClickListener(moreCommentsClickListener);
        ivThumbnail.setOnClickListener(thumbnailClickListener);

        recyclerView.setLayoutManager(new LinearLayoutManager(ArticleDetailsActivity.this));
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        scrollView.setOnScrollChangeListener(onScrollChangeListener);
        loadData();
    }

    View.OnClickListener thumbnailClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(ViewLargeImageActivity.newInstance(ArticleDetailsActivity.this,new String[]{articleObject.thumbnail}));

        }
    };
    View.OnClickListener moreCommentsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(CommentsActivity.newInstance(ArticleDetailsActivity.this,articleObject));
        }
    };

    NestedScrollView.OnScrollChangeListener onScrollChangeListener = new NestedScrollView.OnScrollChangeListener() {
        @Override
        public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            vToolbar.setBackgroundColor(UtilityFunctions.getColorWithAlpha(((float) scrollY) / ((float) ivThumbnail.getHeight()), ContextCompat.getColor(ArticleDetailsActivity.this, R.color.colorPrimary)));
            tvToolbarTitle.setTextColor(UtilityFunctions.getColorWithAlpha(((float) scrollY) / ((float) ivThumbnail.getHeight()), ContextCompat.getColor(ArticleDetailsActivity.this, R.color.white)));
        }
    };

    private void loadData() {
        fillInData();
    }

    public void fillInData() {
        tvTitle.setText(articleObject.title);
        tvDate.setText(UtilityFunctions.formatEllapseTime(articleObject.datetime,"dd MMM yyyy",ArticleDetailsActivity.this));
        tvAuthorName.setText(articleObject.author.name);
        String[] textParts = articleObject.textBody.split("\n");
        String remainingText = "";
        for (int i = 1; i < textParts.length; i++) {
            if (!remainingText.isEmpty()) {
                remainingText += "\n" + textParts[i];
            } else {
                remainingText += textParts[i];
            }
        }

        GlideApp.with(ArticleDetailsActivity.this)
                .load(articleObject.thumbnail)
                .centerCrop()
                .into(ivThumbnail);

        if (textParts.length > 0) {
            tvEmphasiveDescription.setText(textParts[0]);
        }
        if (remainingText.isEmpty()) {
            tvDescription.setVisibility(View.GONE);
        } else {
            tvDescription.setVisibility(View.VISIBLE);
            tvDescription.setText(remainingText);
        }

        if (articleObject.commentObjects.size() - Constants.DETAILS_PAGE_COMMENTS_LIMIT > 1) {
            tvMoreComments.setText(getResources().getString(R.string.more_comments_count_placeholder, articleObject.commentObjects.size() - Constants.DETAILS_PAGE_COMMENTS_LIMIT));
            tvMoreComments.setVisibility(View.VISIBLE);
        } else if(articleObject.commentObjects.size() - Constants.DETAILS_PAGE_COMMENTS_LIMIT > 0) {
            tvMoreComments.setText(getResources().getString(R.string.one_more_comment));
            tvMoreComments.setVisibility(View.VISIBLE);
        }else{
            tvMoreComments.setVisibility(View.GONE);
        }

        adapter.setData(articleObject.commentObjects);
    }

    View.OnClickListener likeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener shareClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };


}
