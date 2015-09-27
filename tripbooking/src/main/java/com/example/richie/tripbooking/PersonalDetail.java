package com.example.richie.tripbooking;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class PersonalDetail extends AppCompatActivity {

    private android.support.v7.widget.Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_detail);
        tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBar);
        tb.setTitle("Drive");
        tb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

       /* tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        tb.setTitle("Personal Detail");
        tb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(tb);
       */ }

    public void summaryDetail(View v){

        Intent i=new Intent(PersonalDetail.this,Booking_Details.class);
        Bundle bndlanimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.anim, R.anim.animate1).toBundle();
        startActivity(i, bndlanimation);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_personal_detail, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:

                onBackPressed();
                overridePendingTransition(R.anim.slide_rightin, R.anim.sliderightout);

                break;


        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_rightin, R.anim.sliderightout);
    }
}
