package com.cynasure.cyno2k19;

import android.animation.Animator;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cleveroad.fanlayoutmanager.FanLayoutManager;
import com.cleveroad.fanlayoutmanager.FanLayoutManagerSettings;
import com.cleveroad.fanlayoutmanager.callbacks.FanChildDrawingOrderCallback;
import com.cynasure.cyno2k19.AllBranches.CentralEvents;
import com.cynasure.cyno2k19.AllBranches.ChemicalEvents;
import com.cynasure.cyno2k19.AllBranches.CivilEvents;
import com.cynasure.cyno2k19.AllBranches.ComputerEvents;
import com.cynasure.cyno2k19.AllBranches.ElectricalEvents;
import com.cynasure.cyno2k19.AllBranches.ItEvents;
import com.cynasure.cyno2k19.AllBranches.MechEvents;
import com.cynasure.cyno2k19.AllBranches.PetroEvents;
import com.cynasure.cyno2k19.AllBranches.TronicsEvents;
import com.cynasure.cyno2k19.AllEvents.LogiqueEvent;
import com.cynasure.cyno2k19.AllEvents.StructuraEvent;
import com.cynasure.cyno2k19.RecyclerData.SportCardsUtils;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private FanLayoutManager mFanLayoutManager;

    private SportCardsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        Toast.makeText(this, "double click on any below card to see events", Toast.LENGTH_SHORT).show();

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Cynosure");
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        ImageView logo = (ImageView) findViewById(R.id.cyno_logo);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.open_fab_anim);
        logo.startAnimation(animation);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        // close drawer when item is tapped

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        int id = menuItem.getItemId();


                        if (id == R.id.nav_events) {
                            startActivity(new Intent(getApplicationContext(), EventsActivity.class));
                        }
                        else if (id == R.id.nav_workshops) {
                            startActivity(new Intent(getApplicationContext(), WorkshopActivity.class));
                        }
                        else if (id == R.id.nav_sponser) {
                            startActivity(new Intent(getApplicationContext(), SponsActivity.class));
                        }
                        else if (id == R.id.nav_team){
                            startActivity(new Intent(getApplicationContext(), CynoTeamActivity.class));
                        }
                        else if (id == R.id.nav_develpers){
                            startActivity(new Intent(getApplicationContext(), DevelopersActivity.class));
                        }
                        else if (id == R.id.nav_University){
                            startActivity(new Intent(getApplicationContext(), UniversityActivity.class));
                        }
                        else if (id == R.id.nav_website){
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.addCategory(Intent.CATEGORY_BROWSABLE);
                            intent.setData(Uri.parse("http://www.dbatucynosure.org"));
                            startActivity(intent);
                        }

                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvCards);

        FanLayoutManagerSettings fanLayoutManagerSettings = FanLayoutManagerSettings
                .newBuilder(getApplicationContext())
                .withFanRadius(true)
                .withAngleItemBounce(5)
                .withViewHeightDp(160)
                .withViewWidthDp(120)
                .build();

        mFanLayoutManager = new FanLayoutManager(getApplicationContext(), fanLayoutManagerSettings);

        recyclerView.setLayoutManager(mFanLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new SportCardsAdapter(getApplicationContext());
        mAdapter.addAll(SportCardsUtils.generateSportCards());

        mAdapter.setOnItemClickListener(new SportCardsAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(final int itemPosition, final View view) {
                if (mFanLayoutManager.getSelectedItemPosition() != itemPosition) {
                    mFanLayoutManager.switchItem(recyclerView, itemPosition);
                } else {
                    mFanLayoutManager.straightenSelectedItem(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            if (itemPosition == 0){
                                Intent compIntent = new Intent(MainActivity.this, ComputerEvents.class);
                                startActivity(compIntent);
                            }
                            else if (itemPosition == 1){
                                Intent chemIntent = new Intent(MainActivity.this, ChemicalEvents.class);
                                startActivity(chemIntent);
                            }
                            else if (itemPosition == 2){
                                Intent civilIntent = new Intent(MainActivity.this, CivilEvents.class);
                                startActivity(civilIntent);
                            }
                            else if (itemPosition == 3){
                                Intent itIntent = new Intent(MainActivity.this, ItEvents.class);
                                startActivity(itIntent);
                            }
                            else if (itemPosition == 4){
                                Intent mechIntent = new Intent(MainActivity.this, MechEvents.class);
                                startActivity(mechIntent);
                            }
                            else if (itemPosition == 5){
                                Intent petroEvents = new Intent(MainActivity.this, PetroEvents.class);
                                startActivity(petroEvents);
                            }
                            else if (itemPosition == 6){
                                Intent electricalIntent = new Intent(MainActivity.this, ElectricalEvents.class);
                                startActivity(electricalIntent);
                            }
                            else if (itemPosition == 7){
                                Intent tronicsIntent = new Intent(MainActivity.this, TronicsEvents.class);
                                startActivity(tronicsIntent);
                            }
                            else if (itemPosition == 8){
                                Intent centralIntent = new Intent(MainActivity.this, CentralEvents.class);
                                startActivity(centralIntent);
                            }

                            else if (itemPosition == 9){
                                Intent workIntent = new Intent(MainActivity.this, WorkshopActivity.class);
                                startActivity(workIntent);
                            }

                            //------------------1st---------------
                            else if (itemPosition == 10){
                                Intent compIntent = new Intent(MainActivity.this, ComputerEvents.class);
                                startActivity(compIntent);
                            }
                            else if (itemPosition == 11){
                                Intent chemIntent = new Intent(MainActivity.this, ChemicalEvents.class);
                                startActivity(chemIntent);
                            }
                            else if (itemPosition == 12){
                                Intent civilIntent = new Intent(MainActivity.this, CivilEvents.class);
                                startActivity(civilIntent);
                            }
                            else if (itemPosition == 13){
                                Intent itIntent = new Intent(MainActivity.this, ItEvents.class);
                                startActivity(itIntent);
                            }
                            else if (itemPosition == 14){
                                Intent mechIntent = new Intent(MainActivity.this, MechEvents.class);
                                startActivity(mechIntent);
                            }
                            else if (itemPosition == 15){
                                Intent petroEvents = new Intent(MainActivity.this, PetroEvents.class);
                                startActivity(petroEvents);
                            }
                            else if (itemPosition == 16){
                                Intent electricalIntent = new Intent(MainActivity.this, ElectricalEvents.class);
                                startActivity(electricalIntent);
                            }
                            else if (itemPosition == 17){
                                Intent tronicsIntent = new Intent(MainActivity.this, TronicsEvents.class);
                                startActivity(tronicsIntent);
                            }
                            else if (itemPosition == 18){
                                Intent centralIntent = new Intent(MainActivity.this, CentralEvents.class);
                                startActivity(centralIntent);
                            }

                            else if (itemPosition == 19){
                                Intent workIntent = new Intent(MainActivity.this, WorkshopActivity.class);
                                startActivity(workIntent);
                            }

                            //-------------------2nd--------------------
                            else if (itemPosition == 20){
                                Intent compIntent = new Intent(MainActivity.this, ComputerEvents.class);
                                startActivity(compIntent);
                            }
                            else if (itemPosition == 21){
                                Intent chemIntent = new Intent(MainActivity.this, ChemicalEvents.class);
                                startActivity(chemIntent);
                            }
                            else if (itemPosition == 22){
                                Intent civilIntent = new Intent(MainActivity.this, CivilEvents.class);
                                startActivity(civilIntent);
                            }
                            else if (itemPosition == 23){
                                Intent itIntent = new Intent(MainActivity.this, ItEvents.class);
                                startActivity(itIntent);
                            }
                            else if (itemPosition == 24){
                                Intent mechIntent = new Intent(MainActivity.this, MechEvents.class);
                                startActivity(mechIntent);
                            }
                            else if (itemPosition == 25){
                                Intent petroEvents = new Intent(MainActivity.this, PetroEvents.class);
                                startActivity(petroEvents);
                            }
                            else if (itemPosition == 26){
                                Intent electricalIntent = new Intent(MainActivity.this, ElectricalEvents.class);
                                startActivity(electricalIntent);
                            }
                            else if (itemPosition == 27){
                                Intent tronicsIntent = new Intent(MainActivity.this, TronicsEvents.class);
                                startActivity(tronicsIntent);
                            }
                            else if (itemPosition == 28){
                                Intent centralIntent = new Intent(MainActivity.this, CentralEvents.class);
                                startActivity(centralIntent);
                            }

                            else if (itemPosition == 29){
                                Intent workIntent = new Intent(MainActivity.this, WorkshopActivity.class);
                                startActivity(workIntent);
                            }

                            //--------------------3rd------------------
                            else if (itemPosition == 30){
                                Intent compIntent = new Intent(MainActivity.this, ComputerEvents.class);
                                startActivity(compIntent);
                            }
                            else if (itemPosition == 31){
                                Intent chemIntent = new Intent(MainActivity.this, ChemicalEvents.class);
                                startActivity(chemIntent);
                            }
                            else if (itemPosition == 32){
                                Intent civilIntent = new Intent(MainActivity.this, CivilEvents.class);
                                startActivity(civilIntent);
                            }
                            else if (itemPosition == 33){
                                Intent itIntent = new Intent(MainActivity.this, ItEvents.class);
                                startActivity(itIntent);
                            }
                            else if (itemPosition == 34){
                                Intent mechIntent = new Intent(MainActivity.this, MechEvents.class);
                                startActivity(mechIntent);
                            }
                            else if (itemPosition == 35){
                                Intent petroEvents = new Intent(MainActivity.this, PetroEvents.class);
                                startActivity(petroEvents);
                            }
                            else if (itemPosition == 36){
                                Intent electricalIntent = new Intent(MainActivity.this, ElectricalEvents.class);
                                startActivity(electricalIntent);
                            }
                            else if (itemPosition == 37){
                                Intent tronicsIntent = new Intent(MainActivity.this, TronicsEvents.class);
                                startActivity(tronicsIntent);
                            }
                            else if (itemPosition == 38){
                                Intent centralIntent = new Intent(MainActivity.this, CentralEvents.class);
                                startActivity(centralIntent);
                            }

                            else if (itemPosition == 39){
                                Intent workIntent = new Intent(MainActivity.this, WorkshopActivity.class);
                                startActivity(workIntent);
                            }

                            //-----------------4th---------------------
                            else if (itemPosition == 40){
                                Intent compIntent = new Intent(MainActivity.this, ComputerEvents.class);
                                startActivity(compIntent);
                            }
                            else if (itemPosition == 41){
                                Intent chemIntent = new Intent(MainActivity.this, ChemicalEvents.class);
                                startActivity(chemIntent);
                            }
                            else if (itemPosition == 42){
                                Intent civilIntent = new Intent(MainActivity.this, CivilEvents.class);
                                startActivity(civilIntent);
                            }
                            else if (itemPosition == 43){
                                Intent itIntent = new Intent(MainActivity.this, ItEvents.class);
                                startActivity(itIntent);
                            }
                            else if (itemPosition == 44){
                                Intent mechIntent = new Intent(MainActivity.this, MechEvents.class);
                                startActivity(mechIntent);
                            }
                            else if (itemPosition == 45){
                                Intent petroEvents = new Intent(MainActivity.this, PetroEvents.class);
                                startActivity(petroEvents);
                            }
                            else if (itemPosition == 46){
                                Intent electricalIntent = new Intent(MainActivity.this, ElectricalEvents.class);
                                startActivity(electricalIntent);
                            }
                            else if (itemPosition == 47){
                                Intent tronicsIntent = new Intent(MainActivity.this, TronicsEvents.class);
                                startActivity(tronicsIntent);
                            }
                            else if (itemPosition == 48){
                                Intent centralIntent = new Intent(MainActivity.this, CentralEvents.class);
                                startActivity(centralIntent);
                            }

                            else if (itemPosition == 49){
                                Intent workIntent = new Intent(MainActivity.this, WorkshopActivity.class);
                                startActivity(workIntent);
                            }

                            //--------------------5th------------------
                            else if (itemPosition == 50){
                                Intent compIntent = new Intent(MainActivity.this, ComputerEvents.class);
                                startActivity(compIntent);
                            }
                            else if (itemPosition == 51){
                                Intent chemIntent = new Intent(MainActivity.this, ChemicalEvents.class);
                                startActivity(chemIntent);
                            }
                            else if (itemPosition == 52){
                                Intent civilIntent = new Intent(MainActivity.this, CivilEvents.class);
                                startActivity(civilIntent);
                            }
                            else if (itemPosition == 53){
                                Intent itIntent = new Intent(MainActivity.this, ItEvents.class);
                                startActivity(itIntent);
                            }
                            else if (itemPosition == 54){
                                Intent mechIntent = new Intent(MainActivity.this, MechEvents.class);
                                startActivity(mechIntent);
                            }
                            else if (itemPosition == 55){
                                Intent petroEvents = new Intent(MainActivity.this, PetroEvents.class);
                                startActivity(petroEvents);
                            }
                            else if (itemPosition == 56){
                                Intent electricalIntent = new Intent(MainActivity.this, ElectricalEvents.class);
                                startActivity(electricalIntent);
                            }
                            else if (itemPosition == 57){
                                Intent tronicsIntent = new Intent(MainActivity.this, TronicsEvents.class);
                                startActivity(tronicsIntent);
                            }
                            else if (itemPosition == 58){
                                Intent centralIntent = new Intent(MainActivity.this, CentralEvents.class);
                                startActivity(centralIntent);
                            }

                            else if (itemPosition == 59){
                                Intent workIntent = new Intent(MainActivity.this, WorkshopActivity.class);
                                startActivity(workIntent);
                            }
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });
                }
            }
        });

        recyclerView.setAdapter(mAdapter);
        recyclerView.setChildDrawingOrderCallback(new FanChildDrawingOrderCallback(mFanLayoutManager));

        (findViewById(R.id.cyno_logo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFanLayoutManager.collapseViews();
                Toast.makeText(MainActivity.this, "collapsing the cards. click that logo again to separate them", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.action_facebook){
            String url1 = "https://www.facebook.com/dbatu.cynosure/?ref=br_rs";
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
            startActivity(intent1);
        }else if (id == R.id.action_insta){
            String url1 = "https://www.instagram.com/cyno2k19/";
            Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
            startActivity(intent2);
        }else if (id == R.id.action_youtube){
            String url1 = "https://www.youtube.com/channel/UCN119s5TseSHKmFsU6vxelA";
            Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
            startActivity(intent3);
        }else if (id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return true;
    }


}
