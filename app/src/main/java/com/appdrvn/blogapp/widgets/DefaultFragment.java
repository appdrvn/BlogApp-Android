package com.appdrvn.blogapp.widgets;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.appdrvn.blogapp.R;


/**
 * Created by Kelvin-PC on 12/09/2015.
 */
public class DefaultFragment extends Fragment {

    public void initToolBar(View rootView) {
        Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    public void initToolBar(String title, View rootView) {
        initToolBar(rootView);
        TextView tvTitle = rootView.findViewById(R.id.action_bar_title_text);
        tvTitle.setText(title);
    }

    public void initToolBar(String title, View rootView, int ic_back, View.OnClickListener backOnClickListener) {
        initToolBar(title, rootView);
        if (ic_back > -1) {
            FrameLayout leftIconLayout = rootView.findViewById(R.id.action_bar_left_icon_layout);
            ImageView leftIcon = rootView.findViewById(R.id.action_bar_left_icon);
            leftIcon.setImageDrawable(getResources().getDrawable(ic_back));
            leftIconLayout.setVisibility(View.VISIBLE);
            leftIconLayout.setOnClickListener(backOnClickListener);
        }
    }

    public void setRightIcon(int resId, View.OnClickListener listener, View rootView) {
        FrameLayout leftIconLayout = rootView.findViewById(R.id.action_bar_right_icon_layout);
        ImageView leftIcon = rootView.findViewById(R.id.action_bar_right_icon);
        leftIcon.setImageDrawable(getResources().getDrawable(resId));
        leftIconLayout.setVisibility(View.VISIBLE);
        leftIconLayout.setOnClickListener(listener);
    }


}
