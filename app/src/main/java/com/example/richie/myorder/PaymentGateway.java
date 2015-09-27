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


public class PaymentGateway extends ActionBarActivity {
    android.support.v7.widget.Toolbar tb;
    DrawerLayout dl;
    ListView ls;

    Fragment frag1,frag2,frag3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_gateway);
        tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBar);
        tb.setLogo(R.mipmap.shopcart);
        tb.setTitle("Payment");
        setSupportActionBar(tb);
       /* SlideFragment sg = (SlideFragment) getFragmentManager().findFragmentById(R.id.fragment);

        sg.setUp((DrawerLayout)findViewById(R.id.drawerLayout),tb);
       */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Fragment fragment1 = new PayFragment();
        FragmentManager manage = getFragmentManager();
        FragmentTransaction tran = manage.beginTransaction();
        tran.add(R.id.fragment_pay, fragment1, "");
        tran.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_payment_gateway, menu);
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
