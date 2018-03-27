package com.appdrvn.blogapp.widgets;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.delegates.GlideApp;

import java.io.File;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


public class ViewLargeImageAdapter extends PagerAdapter {

    private static final String TAG = "ViewLargeImageAdapter";
    private String[] productID;
    Context context;

    public ViewLargeImageAdapter(Context context, String[] product) {
        productID = product;
        this.context = context;
    }

    PhotoViewAttacher.OnPhotoTapListener tapListener;

    public void setTapListener(PhotoViewAttacher.OnPhotoTapListener tapListener) {
        this.tapListener = tapListener;
    }

    @Override
    public int getCount() {
        return productID.length;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        PhotoView img = new PhotoView(container.getContext());
        img.setOnPhotoTapListener(tapListener);
        Log.d(TAG,"Image[" + position + "]->" + productID[position]);

        try {
            if (productID[position].startsWith("http://") ||productID[position].startsWith("https://")) {
                GlideApp.with(context)
                        .load(productID[position])
                        .placeholder(R.drawable.img_placeholder_wide)
                        .centerInside()
                        .into(img);
            } else {
                GlideApp.with(context)
                        .load(new File(productID[position]))
                        .placeholder(R.drawable.img_placeholder_wide)
                        .centerInside()
                        .into(img);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        container.addView(img, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        return img;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}