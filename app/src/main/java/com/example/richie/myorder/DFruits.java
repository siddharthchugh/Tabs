package com.example.richie.myorder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class DFruits extends ActionBarActivity {

    android.support.v7.widget.Toolbar tb;
    DrawerLayout dl;
    ListView ls;

    Fragment frag1,frag2,frag3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dfruits);
        tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBar);
        tb.setLogo(R.mipmap.listcart);
        setSupportActionBar(tb);
       /* SlideFragment sg = (SlideFragment) getFragmentManager().findFragmentById(R.id.fragment);

        sg.setUp((DrawerLayout)findViewById(R.id.drawerLayout),tb);
       */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Fragment fragment1 = new DFruits_Fragment();
        FragmentManager manage = getFragmentManager();
        FragmentTransaction tran = manage.beginTransaction();
        tran.add(R.id.fragment_dfruits, fragment1, "");
        tran.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dfruits, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case android.R.id.home:
                super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
