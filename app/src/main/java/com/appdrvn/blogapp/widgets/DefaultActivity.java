package com.appdrvn.blogapp.widgets;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.appdrvn.blogapp.R;


/**
 * Created by Kelvin-PC on 16/09/2015.
 */
public class DefaultActivity extends BaseActivity {

    public View.OnClickListener backOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    };

    public void initToolBar(String title, int leftResources, View.OnClickListener leftOnClickListener, int rightResources, View.OnClickListener rightOnClickListener) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (leftResources > 0) {
            try {
                FrameLayout leftIconLayout = findViewById(R.id.action_bar_left_icon_layout);
                ImageView leftIcon = findViewById(R.id.action_bar_left_icon);
                leftIcon.setImageDrawable(getResources().getDrawable(leftResources));
                leftIconLayout.setOnClickListener(leftOnClickListener);
                leftIconLayout.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (rightResources > 0) {
            try {
                FrameLayout rightIconLayout = findViewById(R.id.action_bar_right_icon_layout);
                ImageView rightIcon = findViewById(R.id.action_bar_right_icon);
                rightIcon.setImageDrawable(getResources().getDrawable(rightResources));
                rightIconLayout.setOnClickListener(rightOnClickListener);
                rightIconLayout.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TextView tvTitle = findViewById(R.id.action_bar_title_text);
        tvTitle.setText(title);
    }

    public void setLeftExtraIcon(int leftResources, View.OnClickListener leftOnClickListener) {
        if (leftResources > 0) {
            try {
                FrameLayout leftIconLayout = findViewById(R.id.action_bar_left_extra_icon_layout);
                ImageView leftIcon = findViewById(R.id.action_bar_left_extra_icon);
                leftIcon.setImageDrawable(getResources().getDrawable(leftResources));
                leftIconLayout.setOnClickListener(leftOnClickListener);
                leftIconLayout.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setRightExtraIcon(int rightResources, View.OnClickListener rightOnClickListener) {
        if (rightResources > 0) {
            try {
                FrameLayout rightIconLayout = findViewById(R.id.action_bar_right_extra_icon_layout);
                ImageView rightIcon = findViewById(R.id.action_bar_right_extra_icon);
                rightIcon.setImageDrawable(getResources().getDrawable(rightResources));
                rightIconLayout.setOnClickListener(rightOnClickListener);
                rightIconLayout.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
