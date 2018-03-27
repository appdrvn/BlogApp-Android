package com.appdrvn.blogapp.delegates;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.appdrvn.blogapp.R;


public class DialogsDelegates {

    public static void showMessage(Context c, String message, String title,
                                   DialogInterface.OnClickListener callback) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(c);
        builder1.setMessage(message);
        builder1.setCancelable(true);
        builder1.setTitle(title);
        builder1.setPositiveButton("OK", callback);
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

}
