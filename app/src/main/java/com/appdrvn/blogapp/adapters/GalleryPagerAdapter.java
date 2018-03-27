package com.appdrvn.blogapp.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.delegates.GlideApp;
import com.appdrvn.blogapp.fragments.GalleryPager;

import java.io.File;
import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


public class GalleryPagerAdapter extends FragmentStatePagerAdapter {


    ArrayList<GalleryPager> fragments = new ArrayList<>();

    public GalleryPagerAdapter(FragmentManager fm, String[] galleries) {
        super(fm);
        for(int i=0;i<galleries.length;i++){
            fragments.add(GalleryPager.newInstance(galleries[i]));
        }
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public GalleryPager getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public float getPageWidth(int position) {
        return 1f;
    }


    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }


}