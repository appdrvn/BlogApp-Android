package com.appdrvn.blogapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.adapters.AboutReferenceAdapter;
import com.appdrvn.blogapp.delegates.Constants;
import com.appdrvn.blogapp.delegates.UtilityFunctions;
import com.appdrvn.blogapp.models.AboutReference;
import com.appdrvn.blogapp.widgets.DefaultActivity;


/**
 * Created by kelvynlaw on 27/09/2017.
 */

public class AboutActivity extends DefaultActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initToolBar(getResources().getString(R.string.about_us), R.drawable.ic_back_white, backOnClickListener, -1, null);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        AboutReferenceAdapter adapter = new AboutReferenceAdapter(AboutActivity.this, AboutReference.createData());

        recyclerView.setLayoutManager(new LinearLayoutManager(AboutActivity.this));
        recyclerView.setAdapter(adapter);

        findViewById(R.id.find_us_on_facebook).setOnClickListener(findUsOnFBClickListener);
        findViewById(R.id.email_us).setOnClickListener(emailUsClickListener);
        findViewById(R.id.website).setOnClickListener(websiteClickListener);
    }

    View.OnClickListener findUsOnFBClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(Constants.FACEBOOK_URL));
            startActivity(intent);


        }
    };
    View.OnClickListener emailUsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", Constants.EMAIL, null));
            intent.putExtra(Intent.EXTRA_SUBJECT, "BlogApp feedback");
            startActivity(Intent.createChooser(intent, getResources().getString(R.string.email)));


        }
    };
    View.OnClickListener websiteClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(UtilityFunctions.openBrowserIntent(Constants.WEBSITE_URL));


        }
    };


}
