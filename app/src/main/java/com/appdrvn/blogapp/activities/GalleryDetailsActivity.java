package com.appdrvn.blogapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.adapters.GalleryPagerAdapter;
import com.appdrvn.blogapp.adapters.GalleryThumbnailAdapter;
import com.appdrvn.blogapp.models.GalleryObject;
import com.appdrvn.blogapp.widgets.DefaultActivity;

import org.parceler.Parcels;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by kelvynlaw on 11/02/2018.
 */

public class GalleryDetailsActivity extends DefaultActivity implements PhotoViewAttacher.OnPhotoTapListener {

    static final String INTENT_GALLERY_OBJECT = "INTENT_GALLERY_OBJECT";

    ViewPager viewPager;
    View vCommentLikeShare;
    View vToolbar;
    RecyclerView recyclerView;

    GalleryThumbnailAdapter thumbnailAdapter;

    GalleryObject galleryObject = new GalleryObject();

    public static Intent newInstance(Context context, GalleryObject galleryObject) {

        Intent intent = new Intent(context, GalleryDetailsActivity.class);

        intent.putExtra(INTENT_GALLERY_OBJECT, Parcels.wrap(galleryObject));

        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_details);

        galleryObject = Parcels.unwrap(getIntent().getParcelableExtra(INTENT_GALLERY_OBJECT));

        initToolBar(galleryObject.title, R.drawable.ic_back_white, backOnClickListener, -1, null);

        viewPager = findViewById(R.id.view_pager);
        vCommentLikeShare = findViewById(R.id.layout_comment_like_share);
        vToolbar = findViewById(R.id.toolbar);
        thumbnailAdapter = new GalleryThumbnailAdapter(GalleryDetailsActivity.this);
        recyclerView = findViewById(R.id.thumbnails);

        findViewById(R.id.comment).setOnClickListener(informationClickListener);
        findViewById(R.id.like).setOnClickListener(likeClickListener);
        findViewById(R.id.share).setOnClickListener(shareClickListener);

        viewPager.addOnPageChangeListener(contentPageChangeListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(GalleryDetailsActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(thumbnailAdapter);

        thumbnailAdapter.setItemClickListener(thumbnailItemClickListener);

        loadData();
    }

    ViewPager.OnPageChangeListener contentPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            thumbnailAdapter.setSelected(position);
            recyclerView.scrollToPosition(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    View.OnClickListener shareClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };

    View.OnClickListener commentClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };

    View.OnClickListener likeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };

    View.OnClickListener informationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(GalleryInformationActivity.newInstance(GalleryDetailsActivity.this,galleryObject));
        }
    };
    View.OnClickListener thumbnailItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                int index = (int)view.getTag();
                viewPager.setCurrentItem(index,true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };



    private void loadData() {

        GalleryPagerAdapter adapter = new GalleryPagerAdapter(getSupportFragmentManager(), galleryObject.galleries);
        viewPager.setAdapter(adapter);

        thumbnailAdapter.setData(galleryObject.galleries);
    }

    @Override
    public void onPhotoTap(View view, float x, float y) {
        if (vCommentLikeShare.getVisibility() == View.VISIBLE) {
            hideControlUI();
        } else {
            showControlUI();
        }
    }

    private void hideControlUI(){
        vCommentLikeShare.setVisibility(View.GONE);
        vToolbar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
    }
    private void showControlUI(){
        vCommentLikeShare.setVisibility(View.VISIBLE);
        vToolbar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

}
