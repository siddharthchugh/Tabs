package com.example.richie.mywebviewscreen;

import android.app.ActivityOptions;
import  android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;


public class SplashScreen extends ActionBarActivity  {

ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_frag);

        Spash_Fragment frag = new Spash_Fragment();
        FragmentManager manae = getSupportFragmentManager();
        FragmentTransaction tran = manae.beginTransaction().add(R.id.fragment2, frag, "");
        tran.setCustomAnimations(R.anim.anim,0,0, R.anim.animation1);

        tran.commit();
        if (savedInstanceState == null) {
//            pb.setVisibility(View.VISIBLE);
        //    pb = (ProgressBar) findViewById(R.id.progressBar);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    if(isConnected()){

        DisplayView();

    }
        else
    {
//         pb.setVisibility(View.VISIBLE);


        Toast.makeText(SplashScreen.this,"Network not connected, Try again or call later.",Toast.LENGTH_LONG).show();
    }


    }

    public void Cal(View v){

        Toast.makeText(SplashScreen.this,"Call",Toast.LENGTH_SHORT).show();

    }

    public void DisplayView(){
        Thread background = new Thread() {
            public void run() {

                try {

                    // Thread will sleep for 5 seconds
                    sleep(5*1000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    Bundle bndlanimation =
                            ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.anim, R.anim.animation1).toBundle();
                    startActivity(i, bndlanimation);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();


    }

    public boolean isConnected(){

        ConnectivityManager connect_Manger = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connect_Manger.getActiveNetworkInfo();
        if(networkInfo!=null &&  networkInfo.isConnectedOrConnecting())
        {

    	/*	if(networkInfo.getType()!= ConnectivityManager.TYPE_WIFI){
    			Toast.makeText(this, "this app doesn't run without wifi", Toast.LENGTH_SHORT).show();
    		return false;
    		}
        */    return true;

        }
        else
        {
            return false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_act, container, false);
            return rootView;
        }


    }
}
