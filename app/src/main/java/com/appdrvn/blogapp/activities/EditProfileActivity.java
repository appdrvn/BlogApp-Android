package com.appdrvn.blogapp.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.delegates.DialogsDelegates;
import com.appdrvn.blogapp.widgets.DefaultActivity;

/**
 * Created by kelvynlaw on 14/02/2018.
 */

public class EditProfileActivity extends DefaultActivity {

    public static Intent newInstance(Context context){
        Intent intent = new Intent(context, EditProfileActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        initToolBar(getResources().getString(R.string.edit_profile), R.drawable.ic_back_white, backOnClickListener, -1, null);

        findViewById(R.id.submit).setOnClickListener(submitClickListener);

        loadData();

    }

    private void loadData(){

    }

    View.OnClickListener submitClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DialogsDelegates.showMessage(EditProfileActivity.this, getResources().getString(R.string.profile_updated), "", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
        }
    };
}
