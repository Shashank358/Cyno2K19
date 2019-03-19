package com.cynasure.cyno2k19;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.cynasure.cyno2k19.RecyclerData.TeamAdapter;

public class CynoTeamActivity extends AppCompatActivity {

    private CollapsingToolbarLayout toolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyno_team);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("All Members");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        toolbarLayout.setTitle("All Members");
        toolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        toolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.team_list);
        TeamAdapter teamAdapter = new TeamAdapter(getApplicationContext());
        recyclerView.setAdapter(teamAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //------------call click events ----------------------
        teamAdapter.setOnItemClickListener(new TeamAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int pos) {
                if (pos == 0){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+918624839378"));
                    startActivity(intent);
                }
                else if(pos == 1){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+917875005518"));
                    startActivity(intent);
                }
                else if(pos == 2){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+919405912914"));
                    startActivity(intent);
                }
                else if(pos == 3){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+918446359655"));
                    startActivity(intent);
                }
                else if(pos == 4){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+917038450448"));
                    startActivity(intent);
                }
                else if(pos == 5){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+919011155962"));
                    startActivity(intent);
                }
                else if(pos == 6){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+919561978017"));
                    startActivity(intent);
                }
                else if(pos == 7){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+919850753608"));
                    startActivity(intent);
                }
                else if(pos == 8){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+918605595960"));
                    startActivity(intent);
                }
                else if(pos == 9){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+918308586830"));
                    startActivity(intent);
                }
                else if(pos == 10){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+919960787947"));
                    startActivity(intent);
                }
                else if(pos == 11){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+918652602822"));
                    startActivity(intent);
                }
                else if(pos == 12){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+917769900219"));
                    startActivity(intent);
                }
            }
        });

        //---------------email click events---------------

        teamAdapter.setOnEmailClickListener(new TeamAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int pos) {
                if (pos == 0){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="harsh14tech98@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 1){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="pradnyamoon7@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 2){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="akshay7vaidya7@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 3){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="Nishadghode9172@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 4){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="bhushanghuge786@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 5){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="sondkartejas@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 6){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="saurabhgharatsita@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 7){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="gaikwadaniket9860@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 8){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="ravinawankhede7@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 9){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="veer.cyborg358@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 10){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="abhishekrudrawar502@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 11){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="chopdehari1@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
                else if(pos == 12){
                    Intent myMail = new Intent(Intent.ACTION_SEND);

                    myMail.setData(Uri.parse("mail to:"));
                    myMail.setType("message/rfc822");
                    String to="gourkarankita1@gmail.com";
                    String sub="Hey:";
                    myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                    myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
                    myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
                    startActivity(Intent.createChooser(myMail,"send email"));
                }
            }
        });

    }
}
