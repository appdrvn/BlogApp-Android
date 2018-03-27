package com.appdrvn.blogapp.widgets;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.delegates.DialogsDelegates;
import com.appdrvn.blogapp.delegates.GlideApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import uk.co.senab.photoview.PhotoViewAttacher;


public class ViewLargeImageActivity extends DefaultActivity {
    final private String TAG = "ViewLargeImageActivity";

    final static public String INTENT_IMAGES = "INTENT_ADVERTISEMENT";
    final static public String INTENT_IMAGE_POSITION = "INTENT_IMAGE_POSITION";

    ViewPager pager;
    View mVToolbar;
    String[] images = new String[0];


    public static Intent newInstance(Context context, String[] images) {
        Intent intent = new Intent(context, ViewLargeImageActivity.class);
        intent.putExtra(INTENT_IMAGES, images);
        return intent;
    }

    public static Intent newInstance(Context context, String[] images, int position) {
        Intent intent = newInstance(context, images);
        intent.putExtra(INTENT_IMAGE_POSITION, position);
        return intent;
    }


    @Override
    @SuppressLint("NewApi")
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_large);
        mVToolbar = findViewById(R.id.toolbar_layout);

        initToolBar("", R.drawable.ic_back_white, backOnClickListener, -1, null);

        pager = findViewById(R.id.basic_pager);

        images = getIntent().getStringArrayExtra(INTENT_IMAGES);
        ViewLargeImageAdapter adapter = new ViewLargeImageAdapter(this, images);
        adapter.setTapListener(tapListener);
        pager.setAdapter(adapter);
        pager.setCurrentItem(getIntent().getIntExtra(INTENT_IMAGE_POSITION, 0));

    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    PhotoViewAttacher.OnPhotoTapListener tapListener = new PhotoViewAttacher.OnPhotoTapListener() {
        @Override
        public void onPhotoTap(View view, float x, float y) {
            if (mVToolbar.getVisibility() == View.VISIBLE) {
                mVToolbar.setVisibility(View.GONE);
            } else {
                mVToolbar.setVisibility(View.VISIBLE);
            }
        }
    };


}
