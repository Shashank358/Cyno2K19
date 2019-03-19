package com.cynasure.cyno2k19.AllBranches;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cynasure.cyno2k19.AllEvents.CynoSparkEvent;
import com.cynasure.cyno2k19.AllEvents.ElectroPlazaEvent;
import com.cynasure.cyno2k19.AllEvents.LanGamingEvent;
import com.cynasure.cyno2k19.AllEvents.LogiqueEvent;
import com.cynasure.cyno2k19.R;

public class CentralEvents extends AppCompatActivity {

    private CardView first, second, third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_events);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        first = (CardView) findViewById(R.id.first_card);
        second = (CardView) findViewById(R.id.second_card);
        third = (CardView) findViewById(R.id.third_card);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Central Committee");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent firstIntent = new Intent(CentralEvents.this, LanGamingEvent.class);
                startActivity(firstIntent);
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(CentralEvents.this, LogiqueEvent.class);
                startActivity(secondIntent);
            }
        });

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdIntent = new Intent(CentralEvents.this, CynoSparkEvent.class);
                startActivity(thirdIntent);
            }
        });
    }
}
