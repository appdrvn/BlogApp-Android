package com.appdrvn.blogapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.activities.GalleryDetailsActivity;
import com.appdrvn.blogapp.delegates.GlideApp;

import java.io.File;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by kelvynlaw on 11/02/2018.
 */

public class GalleryPager extends Fragment {

    static final String ARGS_IMAGE_URL = "ARGS_IMAGE_URL";

    public static GalleryPager newInstance(String imageUrl) {

        Bundle args = new Bundle();
        args.putString(ARGS_IMAGE_URL, imageUrl);
        GalleryPager fragment = new GalleryPager();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pager_gallery, null);

        PhotoView photoView = rootView.findViewById(R.id.photo_view);

        if(getActivity() instanceof GalleryDetailsActivity){
            photoView.setOnPhotoTapListener((GalleryDetailsActivity)getActivity());
        }

        try {
            String imageUrl = getArguments().getString(ARGS_IMAGE_URL);
                GlideApp.with(getActivity())
                        .load(imageUrl)
                        .placeholder(R.drawable.img_placeholder_wide)
                        .centerInside()
                        .into(photoView);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rootView;
    }
}
