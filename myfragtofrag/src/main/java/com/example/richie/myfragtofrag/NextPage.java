package com.example.richie.myfragtofrag;

import android.app.AlertDialog;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;

import java.util.List;


public class NextPage extends ActionBarActivity {

    //MyPageAdapter myAdapt;
    Button btow,btrt;
    Fragment fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_next_page);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        btow = (Button) findViewById(R.id.button2);
        btow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fr = new OneWay();

                FragmentManager manages = getSupportFragmentManager();
                FragmentTransaction tran = manages.beginTransaction();
                tran.replace(R.id.fragmentplace,fr,"");
                tran.commit();
             /*   if(btrt.isFocused()){
                    btow.setBackgroundColor(Color.BLUE);
                }
                else {
                    btow.setBackgroundColor(Color.CYAN);

                }
*/
            }
        });

        btrt = (Button) findViewById(R.id.button3);
        btrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fr = new RoundTrip();

                FragmentManager manages = getSupportFragmentManager();
                FragmentTransaction tran = manages.beginTransaction();
                tran.replace(R.id.fragmentplace,fr,"");
                tran.commit();
  /*              if(btrt.isFocused()){
                    btow.setBackgroundColor(Color.BLUE);
                }
                else {
                    btow.setBackgroundColor(Color.GREEN);

                }
*/

            }
        });

    }

/*
    public void select(View v){

        Button bt,bt2;
//FragementActivity		fr = new FragementActivity();

        Fragment fr;

        if(v==findViewById(R.id.button2)){

            fr = new OneWay();

        }
        else
        {
            fr = new RoundTrip();
//            bt2 = (Button) findViewById(R.id.button5);
  //          bt2.setVisibility(View.INVISIBLE);
        }

        FragmentManager manages = getSupportFragmentManager();
        FragmentTransaction tran = manages.beginTransaction();
        tran.replace(R.id.fragmentplace,fr,"");
        tran.commit();
        }
*/





    @Override
    public void finish() {
        super.finish();
      overridePendingTransition(R.anim.slide_rightin, R.anim.sliderightout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_next_page, menu);
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
//                NavUtils.getParentActivityIntent(this);
  onBackPressed();
                overridePendingTransition(R.anim.slide_rightin, R.anim.sliderightout);

                break;

            case R.id.action_settings:

                ScreenUtility su = new ScreenUtility(this);
                String output = "Width"+ su.getDpwidth()+ " "+
                        "Height" + su.getDpheight();
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setMessage(output)
                   .setTitle("Dimension")
                   .create()
                .show();
                break;

            case R.id.action_oneway:
                    fr = new OneWay();

                break;

            case R.id.action_rondtrip:
        fr = new RoundTrip();

        break;

        }

        FragmentManager manages = getSupportFragmentManager();
        FragmentTransaction tran = manages.beginTransaction();
        tran.replace(R.id.fragmentplace,fr,"");
//        tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        //   tran.addToBackStack(null);
        tran.commit();


        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }
*/

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
   /* public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_next_page, container, false);
            return rootView;
        }
    }*/
}
