package com.appdrvn.blogapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.dialogs.ForgotPasswordDialog;
import com.appdrvn.blogapp.widgets.DefaultActivity;

/**
 * Created by kelvynlaw on 14/02/2018.
 */

public class LoginActivity extends DefaultActivity {

    public static Intent newInstance(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.login).setOnClickListener(loginClickListener);
        findViewById(R.id.register).setOnClickListener(registerClickListener);
        findViewById(R.id.forgot_password).setOnClickListener(forgotPasswordClickListener);
    }

    View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = MainActivity.newInstance(LoginActivity.this);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    };
    View.OnClickListener registerClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(RegisterActivity.newInstance(LoginActivity.this));
        }
    };
    View.OnClickListener forgotPasswordClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ForgotPasswordDialog forgotPasswordDialog = ForgotPasswordDialog.newInstance();
            forgotPasswordDialog.show(getSupportFragmentManager().beginTransaction(), "dialog");
        }
    };
}
