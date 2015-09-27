package com.example.richie.mytaxi;

import android.app.Dialog;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;


public class MyLocation extends ActionBarActivity {

    Toolbar tb;
    GoogleMap gp;
    View v;
    static final int MAP_ERROR_CODE=9001;

    private static final double paschm_vihar_west = 28.6815639;
    private static final double paschm_vihar_east = 77.1225048;
    private static final int DEAFULT_ZOOM = 15;
    NavigateMode nf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
 //        MapFragment mf = new MapFragment();
   /*     FragmentManager manage = getSupportFragmentManager();
        FragmentTransaction tran = manage.beginTransaction();
        tran.add(R.id.contentDashBoard, mf, "");
        tran.commit();
   */ }
/*
        if(isConnected()) {
            Toast.makeText(this,"Ready for the map",Toast.LENGTH_SHORT ).show();
            setContentView(R.layout.activity_location);
            if (initializeMap()) {
                //     Toast.makeText(this, "Map available", Toast.LENGTH_SHORT).show();
                gotoLocation(paschm_vihar_west,paschm_vihar_east,DEAFULT_ZOOM);
            } else {
                Toast.makeText(this, "Map not available", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public boolean isConnected(){

        int isConnectAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        if(isConnectAvailable == ConnectionResult.SUCCESS){
            return  true;
        }
        else if(GooglePlayServicesUtil.isUserRecoverableError(isConnectAvailable)){
            Dialog dlFrame = GooglePlayServicesUtil.getErrorDialog(isConnectAvailable,this,MAP_ERROR_CODE);
            dlFrame.show();

        }
        else
        {
            Toast.makeText(this,"Cannot connect to the Googleplar Services,Try Again!",Toast.LENGTH_SHORT ).show();
        }



        return false;
    }
*/


/*
    public boolean initializeMap(){


        if (gp == null) {


            SupportMapFragment mFrag = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);

            gp = mFrag.getMap();
        }

        return (gp!=null);
    }
*/


    public void gotoLocation(double lat,double lng, int zoom ){

        LatLng ll = new LatLng(lat,lng);
        CameraUpdate updateCamera = CameraUpdateFactory.newLatLngZoom(ll,zoom);
        gp.animateCamera(updateCamera);

        gp.setMapType(GoogleMap.MAP_TYPE_HYBRID);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
