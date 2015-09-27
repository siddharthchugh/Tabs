package com.example.richie.mytaxi;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

 android.support.v7.widget.Toolbar tb;
    NavigateMode nf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(tb);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nf = (NavigateMode) getFragmentManager().findFragmentById(R.id.fragment);
        nf.setUp(R.id.fragment,(DrawerLayout) findViewById(R.id.drawerLayout), tb);
        DashBoardFragment session = new DashBoardFragment();
        FragmentManager manage = getSupportFragmentManager();
        FragmentTransaction tran = manage.beginTransaction().add(R.id.contentDashBoard,session,"");
        tran.commit();

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


            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
