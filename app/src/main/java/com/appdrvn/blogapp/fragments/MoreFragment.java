package com.appdrvn.blogapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.activities.AboutActivity;
import com.appdrvn.blogapp.activities.EditProfileActivity;
import com.appdrvn.blogapp.activities.LoginActivity;
import com.appdrvn.blogapp.dialogs.ChangePasswordDialog;
import com.appdrvn.blogapp.widgets.DefaultFragment;

/**
 * Created by kelvynlaw on 12/02/2018.
 */

public class MoreFragment extends DefaultFragment {

    public static MoreFragment newInstance() {

        Bundle args = new Bundle();

        MoreFragment fragment = new MoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_more, null);

        rootView.findViewById(R.id.logout).setOnClickListener(logoutClickListener);
        rootView.findViewById(R.id.about_us).setOnClickListener(aboutUsClickListener);
        rootView.findViewById(R.id.change_password).setOnClickListener(changePasswordClickListener);
        rootView.findViewById(R.id.edit_profile).setOnClickListener(editProfileClickListener);

        return rootView;
    }

    View.OnClickListener logoutClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    };
    View.OnClickListener changePasswordClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ChangePasswordDialog changePasswordDialog = ChangePasswordDialog.newInstance();
            changePasswordDialog.show(getChildFragmentManager().beginTransaction(), "dialog");
        }
    };
    View.OnClickListener aboutUsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getActivity(), AboutActivity.class));
        }
    };
    View.OnClickListener editProfileClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getActivity(), EditProfileActivity.class));

        }
    };
}
