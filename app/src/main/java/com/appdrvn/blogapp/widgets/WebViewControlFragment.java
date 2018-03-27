package com.appdrvn.blogapp.widgets;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.delegates.UtilityFunctions;


/**
 * Created by kelvynlaw on 30/03/16.
 */
public class WebViewControlFragment extends DefaultFragment {
    public WebView webView;
    public ProgressBar progressBar;

    private static final String TAG = "WebViewControlFragment";
    public static String INTENT_TITLE = "INTENT_TITLE";
    public static String INTENT_CONTENT = "INTENT_CONTENT";
    public static String INTENT_DISPLAY_HTML = "INTENT_DISPLAY_HTML";


    public String cookies = "";
    public String currentUrl = "";
    private boolean isDisplayHTML = false;
    String targetUrl = "";


    public static WebViewControlFragment newInstance(String content, String title) {
        Bundle args = new Bundle();
        args.putString(INTENT_CONTENT, content);
        args.putString(INTENT_TITLE, title);
        WebViewControlFragment fragment = new WebViewControlFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static WebViewControlFragment newInstance(String content, String title, boolean displayHtml) {
        WebViewControlFragment fragment = newInstance(content, title);
        fragment.getArguments().putBoolean(INTENT_DISPLAY_HTML, displayHtml);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_webview_control, null);

        initUI(rootView);
        initWebView(savedInstanceState);

        return rootView;
    }

    public void initUI(View rootView) {
        if (getActivity() instanceof WebViewControlActivity) {
            initToolBar(getArguments().getString(INTENT_TITLE), rootView, R.drawable.ic_back_white, ((WebViewControlActivity) getActivity()).backOnClickListener);
        }


        webView = rootView.findViewById(R.id.webView);
        progressBar = rootView.findViewById(R.id.progressBar);

    }

    public void initWebView(Bundle savedInstanceState) {
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("http") && isDisplayHTML) {
                    startActivity(Intent.createChooser(UtilityFunctions.openBrowserIntent(url), getResources().getString(R.string.open_webpage)));
                    return true;

                } else if (!url.equals(currentUrl)) {
                    startActivity(Intent.createChooser(UtilityFunctions.openBrowserIntent(url), getResources().getString(R.string.open_webpage)));
                    return true;

                }
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                cookies = CookieManager.getInstance().getCookie(url);
                currentUrl = url;
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);

        targetUrl = getArguments().getString(INTENT_CONTENT);
        isDisplayHTML = getArguments().getBoolean(INTENT_DISPLAY_HTML, false);
        if (isDisplayHTML) {
            webView.loadData(targetUrl, "text/html", "UTF-8");
        } else {
            if (targetUrl != null && !targetUrl.isEmpty()) {
                if (UtilityFunctions.checkInternet(getActivity())) {
                    webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
                    webView.loadUrl(targetUrl);
                    Log.d(TAG, "online:" + targetUrl);
                } else {
                    webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                    webView.loadUrl(targetUrl);
                    Log.d(TAG, "offline");
                }
            } else {
                Log.d(TAG, "no URL");
            }
        }

        if (savedInstanceState != null) {
            try {
                Log.d(TAG, "");
                CookieSyncManager.createInstance(getActivity());
                CookieManager.getInstance().setCookie(savedInstanceState.getString("CurrentURL"), savedInstanceState.getString("Cookies"));
                CookieSyncManager.getInstance().sync();
            } catch (Exception e) {
                e.printStackTrace();
            }
            webView.restoreState(savedInstanceState);
        }

    }

    public void onBackPressed() {
        try {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                getActivity().finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
        outState.putString("Cookies", cookies);
        outState.putString("CurrentURL", currentUrl);

    }


}
