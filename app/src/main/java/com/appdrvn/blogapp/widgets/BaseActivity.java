package com.appdrvn.blogapp.widgets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {

    final String INTENT_START_NEW_ACTIVITY = "INTENT_START_NEW_ACTIVITY";

    public boolean startNewActivity = true;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        startNewActivity = savedInstanceState.getBoolean(INTENT_START_NEW_ACTIVITY);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        startNewActivity = true;
    }

    public void startActivityExternal(Intent intent) {
        super.startActivity(intent);
        startNewActivity = false;
    }

    @Override
    public void startActivity(Intent intent, Bundle options) {
        super.startActivity(intent, options);
        startNewActivity = true;
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        startNewActivity = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!startNewActivity) {
            appResumed();
        }
        startNewActivity = false;
    }

    public void appResumed() {
    }

    public void continueAction() {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(INTENT_START_NEW_ACTIVITY, startNewActivity);
    }
}
