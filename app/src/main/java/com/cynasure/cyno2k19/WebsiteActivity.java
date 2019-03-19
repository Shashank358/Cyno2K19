package com.cynasure.cyno2k19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WebsiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);

    }
}
