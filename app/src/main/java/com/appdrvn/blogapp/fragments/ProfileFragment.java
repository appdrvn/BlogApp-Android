package com.appdrvn.blogapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.adapters.ActivityAdapter;
import com.appdrvn.blogapp.delegates.GlideApp;
import com.appdrvn.blogapp.models.ActivityObject;
import com.appdrvn.blogapp.models.CommentObject;
import com.appdrvn.blogapp.models.UserObject;
import com.appdrvn.blogapp.widgets.DefaultListFragment;

import org.w3c.dom.Comment;

/**
 * Created by kelvynlaw on 12/02/2018.
 */

public class ProfileFragment extends DefaultListFragment {

    ActivityAdapter adapter;

    ImageView ivProfilePicture;
    TextView tvPostCount, tvCommentCount, tvName;

    public static ProfileFragment newInstance() {

        Bundle args = new Bundle();

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, null);

        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh_layout);
        ivProfilePicture = rootView.findViewById(R.id.profile_picture);
        tvName = rootView.findViewById(R.id.name);
        tvPostCount = rootView.findViewById(R.id.post_count);
        tvCommentCount = rootView.findViewById(R.id.comments_count);

        adapter = new ActivityAdapter(getActivity());

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSwipeRefreshLayout.setOnRefreshListener(refreshListener);

        setupLoadMore();

        fillInData();

        return rootView;
    }

    private void fillInData() {
        UserObject userObject = UserObject.createDummy();
        GlideApp.with(getActivity())
                .load(userObject.profileImage)
                .placeholder(R.drawable.img_placeholder_wide)
                .centerCrop()
                .into(ivProfilePicture);
        tvName.setText(userObject.name);
        tvPostCount.setText(userObject.postCount +"");
        tvCommentCount.setText(userObject.commentCount +"");

    }

    @Override
    public void loadData() {
        super.loadData();
        finishLoading();
        if (mCurrentPage == 1) {
            adapter.setData(ActivityObject.createDummy());
        } else {
            if (mCurrentPage == 15) {
                isLastPage = true;
            }
            adapter.add(ActivityObject.createDummy());
        }
    }
}
