package com.cynasure.cyno2k19;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.cynasure.cyno2k19.RecyclerData.Sponsors;
import com.cynasure.cyno2k19.RecyclerData.SponsorsAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class SponsActivity extends AppCompatActivity {

    private FirebaseStorage mStorage;
    private DatabaseReference mDatabase;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private List<Sponsors> mSpons;
    private SponsorsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spons);

        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Sponsors");

        Toast.makeText(this, "connect to internet to see sponsors", Toast.LENGTH_SHORT).show();

        mSpons = new ArrayList<>();

        Toolbar toolbar = (Toolbar)findViewById(R.id.cyno_team_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Sponsers");
        actionbar.setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.spons_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mSpons.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Sponsors sponsor = snapshot.getValue(Sponsors.class);
                    mSpons.add(sponsor);

                    adapter = new SponsorsAdapter(getApplicationContext(), mSpons);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
