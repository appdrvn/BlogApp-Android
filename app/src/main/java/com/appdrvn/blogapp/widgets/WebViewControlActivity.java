package com.appdrvn.blogapp.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.appdrvn.blogapp.R;


public class WebViewControlActivity extends DefaultActivity {
    public static String INTENT_TITLE = "INTENT_TITLE";
    public static String INTENT_CONTENT = "INTENT_CONTENT";
    public static String INTENT_DISPLAY_HTML = "INTENT_DISPLAY_HTML";

    private static final String TAG = "WebViewControlActivity";

    WebViewControlFragment mFragment;

    public static Intent newInstance(Context context, String content, String title) {
        Intent intent = new Intent(context, WebViewControlActivity.class);
        intent.putExtra(INTENT_CONTENT, content);
        intent.putExtra(INTENT_TITLE, title);
        return intent;
    }

    public static Intent newInstance(Context context, String content, String title, boolean displayHTML) {
        Intent intent = newInstance(context, content, title);
        intent.putExtra(INTENT_DISPLAY_HTML, displayHTML);
        return intent;
    }


    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


        if (savedInstanceState == null) {

            mFragment = WebViewControlFragment.newInstance(getIntent().getStringExtra(INTENT_CONTENT), getIntent().getStringExtra(INTENT_TITLE),  getIntent().getBooleanExtra(INTENT_DISPLAY_HTML, false));
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mFragment, "webview").commit();
        }
    }

    @Override
    public void onBackPressed() {
        mFragment.onBackPressed();
    }
}
