package com.cynasure.cyno2k19;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DevelopersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Developers");
        actionbar.setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void emailHead1(View v){
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

    public void emailHead2(View v){
        Intent myMail = new Intent(Intent.ACTION_SEND);

        myMail.setData(Uri.parse("mail to:"));
        myMail.setType("message/rfc822");
        String to="srshahare22@gmail.com";
        String sub="Hey:";
        myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
        myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
        myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
        startActivity(Intent.createChooser(myMail,"send email"));
    }

    public void emailHead3(View v){
        Intent myMail = new Intent(Intent.ACTION_SEND);

        myMail.setData(Uri.parse("mail to:"));
        myMail.setType("message/rfc822");
        String to="taroneshivam@gmail.com";
        String sub="Hey:";
        myMail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
        myMail.putExtra(Intent.EXTRA_SUBJECT,sub);
        myMail.putExtra(Intent.EXTRA_TEXT,"Hello");
        startActivity(Intent.createChooser(myMail,"send email"));
    }

    public void callHead1(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+919960787947"));
        startActivity(intent);
    }
    public void callHead2(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+919604872761"));
        startActivity(intent);
    }
    public void callHead3(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+919145486889"));
        startActivity(intent);
    }
}
