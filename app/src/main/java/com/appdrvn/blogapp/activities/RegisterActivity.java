package com.appdrvn.blogapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.widgets.DefaultActivity;
import com.appdrvn.blogapp.widgets.WebViewControlActivity;

/**
 * Created by kelvynlaw on 14/02/2018.
 */

public class RegisterActivity extends DefaultActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.register).setOnClickListener(registerClickListener);
        findViewById(R.id.login).setOnClickListener(loginClickListener);
        findViewById(R.id.terms_n_conditions).setOnClickListener(termsNConditionClickListener);

    }

    View.OnClickListener registerClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    };
    View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
    View.OnClickListener termsNConditionClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(WebViewControlActivity.newInstance(RegisterActivity.this,"Display Terms & Condition Here",getResources().getString(R.string.terms_n_conditions),true));
        }
    };
}
