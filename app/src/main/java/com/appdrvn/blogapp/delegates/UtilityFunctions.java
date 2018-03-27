package com.appdrvn.blogapp.delegates;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.view.ViewCompat;
import android.text.format.DateUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.appdrvn.blogapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kelvin-PC on 10/09/2015.
 */
public class UtilityFunctions {


    public static final String PREFERENCES_CONFIGURATION_KEY = "PREFERENCES_CONFIGURATION_KEY";
    public static final String PREFERENCES_SUPPRESS_LANDING_TUTORIAL_KEY = "PREFERENCES_SUPPRESS_LANDING_TUTORIAL_KEY";
    final static String TAG = "UtilityFunctions";

    final static long HOUR = 60 * 60 * 1000;
    final static long MINUTE = 60 * 1000;

    public static boolean checkInternet(Context ctx) {
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        // Check if wifi or mobile network is available or not. If any of them is
        // available or connected then it will return true, otherwise false;
        return wifi.isConnected() || mobile.isConnected();
    }

    public static int getBannerHeight(int width) {
        return (int) ((double) width / 16d * 9d);
    }

    /**
     * @dateFormat : refer http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html for the keyword
     */
    public static String getDateStrFromTimestamp(long timestamp, String dateFormat) throws IllegalArgumentException {
        Date date = new Date(timestamp);
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

    public static String formatEllapseTime(long timestamp, String dateFormat, Context context) throws IllegalArgumentException {
        if (DateUtils.isToday(timestamp)) {
            String output = "";
            long difference = System.currentTimeMillis() - timestamp;
            if (difference >= (HOUR)) {
                int differenceInHours = (int) (((double) difference / HOUR) + 0.5d);
                if (differenceInHours == 1) {
                    return context.getResources().getString(R.string.hour_ago_placeholder, differenceInHours);
                } else {
                    return context.getResources().getString(R.string.hours_ago_placeholder, differenceInHours);
                }
            } else if (difference >= MINUTE) {
                int differenceInHours = (int) (((double) difference / MINUTE) + 0.5d);
                if (differenceInHours == 1) {
                    return context.getResources().getString(R.string.minute_ago_placeholder, differenceInHours);
                } else {
                    return context.getResources().getString(R.string.minutes_ago_placeholder, differenceInHours);
                }
            } else {
                return context.getResources().getString(R.string.just_now);
            }
        } else {
            Calendar c1 = Calendar.getInstance(); // today
            c1.add(Calendar.DAY_OF_YEAR, -1); // yesterday

            Calendar c2 = Calendar.getInstance();
            c2.setTime(new Date(timestamp)); // your date

            if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                    && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR)) {
                return context.getResources().getString(R.string.yesterday_placeholder, getDateStrFromTimestamp(timestamp, "h:MM a"));
            } else {

                return getDateStrFromTimestamp(timestamp, dateFormat);
            }
        }
    }

    public static Point getScreenSize(Activity context) {
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    public static Intent openBrowserIntent(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        if(!url.startsWith("http")){
            url = "http://" + url;
        }
        i.setData(Uri.parse(url));
        return i;
    }

    public static int getColorWithAlpha(float alpha, int baseColor) {
        int a = Math.min(255, Math.max(0, (int) (alpha * 255))) << 24;
        int rgb = 0x00ffffff & baseColor;
        return a + rgb;
    }


}
