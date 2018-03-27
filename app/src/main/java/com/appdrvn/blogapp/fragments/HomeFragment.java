package com.appdrvn.blogapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.activities.ArticleDetailsActivity;
import com.appdrvn.blogapp.activities.GalleryDetailsActivity;
import com.appdrvn.blogapp.adapters.ContentsAdapter;
import com.appdrvn.blogapp.models.ArticleObject;
import com.appdrvn.blogapp.models.ContentObject;
import com.appdrvn.blogapp.models.GalleryObject;
import com.appdrvn.blogapp.widgets.DefaultListFragment;

/**
 * Created by kelvynlaw on 31/01/2018.
 */

public class HomeFragment extends DefaultListFragment {

    ContentsAdapter adapter;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,null);

        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh_layout);

        adapter = new ContentsAdapter(getActivity());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);
        adapter.setItemClickListener(itemClickListener);
        mSwipeRefreshLayout.setOnRefreshListener(refreshListener);

        loadData();

        return rootView;
    }

    View.OnClickListener itemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getTag() instanceof ArticleObject) {
                ArticleObject articleObject = (ArticleObject)view.getTag();
                startActivity(ArticleDetailsActivity.newInstance(getActivity(),articleObject));
            } else if(view.getTag() instanceof GalleryObject){
                GalleryObject galleryObject = (GalleryObject)view.getTag();
                startActivity(GalleryDetailsActivity.newInstance(getActivity(),galleryObject));
            }
        }
    };

    @Override
    public void loadData() {
        super.loadData();

        finishLoading();
        if(mCurrentPage == 20){
            isLastPage = true;
        }
        adapter.setData(ContentObject.createDummy());
    }
}
