package com.appdrvn.blogapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.appdrvn.blogapp.fragments.HomeFragment;
import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.delegates.Constants;
import com.appdrvn.blogapp.fragments.MoreFragment;
import com.appdrvn.blogapp.fragments.ProfileFragment;
import com.appdrvn.blogapp.widgets.DefaultActivity;

/**
 * Created by kelvynlaw on 31/01/2018.
 */

public class MainActivity extends DefaultActivity {

    int currentTab = 0;

    View vHomeTab;
    View vProfileTab;
    View vMoreTab;


    public static Intent newInstance(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        vHomeTab =  findViewById(R.id.tab_home);
        vProfileTab = findViewById(R.id.tab_profile);
        vMoreTab = findViewById(R.id.tab_more);

        vHomeTab.setTag(Constants.TAB_HOME);
        vProfileTab.setTag(Constants.TAB_PROFILE);
        vMoreTab.setTag(Constants.TAB_MORE);

        vHomeTab.setOnClickListener(tabClickListener);
        vProfileTab.setOnClickListener(tabClickListener);
        vMoreTab.setOnClickListener(tabClickListener);

        if(savedInstanceState == null){
            tabClickListener.onClick(vHomeTab);
        }
    }

    View.OnClickListener tabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(currentTab){
                case Constants.TAB_HOME:
                    vHomeTab.setSelected(false);
                    break;
                case Constants.TAB_PROFILE:
                    vProfileTab.setSelected(false);
                    break;
                case Constants.TAB_MORE:
                    vMoreTab.setSelected(false);
                    break;
            }
            currentTab = (int)view.getTag();
            view.setSelected(true);
            changeTab(currentTab);
        }
    };

    public void changeTab(int target){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch(target){
            case Constants.TAB_HOME:
                ft.replace(R.id.content_frame, HomeFragment.newInstance());
                ft.commit();
                break;
            case Constants.TAB_PROFILE:
                ft.replace(R.id.content_frame, ProfileFragment.newInstance());
                ft.commit();
                break;
            case Constants.TAB_MORE:
                ft.replace(R.id.content_frame, MoreFragment.newInstance());
                ft.commit();
                break;
        }
    }
}
