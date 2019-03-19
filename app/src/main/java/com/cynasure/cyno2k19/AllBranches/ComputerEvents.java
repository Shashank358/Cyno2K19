package com.cynasure.cyno2k19.AllBranches;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cynasure.cyno2k19.AllEvents.ElectroPlazaEvent;
import com.cynasure.cyno2k19.AllEvents.WebHuntEvent;
import com.cynasure.cyno2k19.R;

public class ComputerEvents extends AppCompatActivity {

    private CardView first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_events);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        first = (CardView) findViewById(R.id.first_card);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Computer Engineering");
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
                Intent firstIntent = new Intent(ComputerEvents.this, WebHuntEvent.class);
                startActivity(firstIntent);
            }
        });
    }
}
