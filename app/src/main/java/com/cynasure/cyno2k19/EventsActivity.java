package com.cynasure.cyno2k19;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.cynasure.cyno2k19.AllBranches.CentralEvents;
import com.cynasure.cyno2k19.AllBranches.ChemicalEvents;
import com.cynasure.cyno2k19.AllBranches.CivilEvents;
import com.cynasure.cyno2k19.AllBranches.ComputerEvents;
import com.cynasure.cyno2k19.AllBranches.ElectricalEvents;
import com.cynasure.cyno2k19.AllBranches.ItEvents;
import com.cynasure.cyno2k19.AllBranches.MechEvents;
import com.cynasure.cyno2k19.AllBranches.PetroEvents;
import com.cynasure.cyno2k19.AllBranches.TronicsEvents;

public class EventsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager,manager;
    private static ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);

        Toolbar toolbar = findViewById(R.id.event_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("All Events");
        actionbar.setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.all_branches_list);
        ListAdapter listAdapter = new ListAdapter(getApplicationContext());
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        listAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int pos) {
                if (pos == 0){
                    Intent compIntent = new Intent(EventsActivity.this, ComputerEvents.class);
                    startActivity(compIntent);
                }
                else if (pos == 1){
                    Intent chemIntent = new Intent(EventsActivity.this, ChemicalEvents.class);
                    startActivity(chemIntent);
                }
                else if (pos == 2){
                    Intent civilIntent = new Intent(EventsActivity.this, CivilEvents.class);
                    startActivity(civilIntent);
                }
                else if (pos == 3){
                    Intent itIntent = new Intent(EventsActivity.this, ItEvents.class);
                    startActivity(itIntent);
                }
                else if (pos == 4){
                    Intent mechIntent = new Intent(EventsActivity.this, MechEvents.class);
                    startActivity(mechIntent);
                }
                else if (pos == 5){
                    Intent petroEvents = new Intent(EventsActivity.this, PetroEvents.class);
                    startActivity(petroEvents);
                }
                else if (pos == 6){
                    Intent electricalIntent = new Intent(EventsActivity.this, ElectricalEvents.class);
                    startActivity(electricalIntent);
                }
                else if (pos == 7){
                    Intent tronicsIntent = new Intent(EventsActivity.this, TronicsEvents.class);
                    startActivity(tronicsIntent);
                }
                else if (pos == 8){
                    Intent centralIntent = new Intent(EventsActivity.this, CentralEvents.class);
                    startActivity(centralIntent);
                }

            }
        });

    }
}
