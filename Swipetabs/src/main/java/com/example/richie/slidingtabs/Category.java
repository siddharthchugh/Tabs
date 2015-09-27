/*
package com.example.richie.slidingtabs;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;


*/
/**
 * A simple {@link android.app.Fragment} subclass.
 *//*

public class Category extends ActionBarActivity {
    android.support.v7.widget.Toolbar tb;
    DrawerLayout dl;
    ListView ls;

    Fragment frag1, frag2, frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBar);
        //   tb.setLogo(R.mipmap.listcart);
        tb.setTitle("Order Fresh");
        setSupportActionBar(tb);
        SlideFragment sg = (SlideFragment) getFragmentManager().findFragmentById(R.id.fragment);

        sg.setUp((DrawerLayout) findViewById(R.id.drawerLayout), tb);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Fragment fragment1 = new Category_fragment();
        FragmentManager manage = getFragmentManager();
        FragmentTransaction tran = manage.beginTransaction();
        tran.add(R.id.fragment5, fragment1, "");
        tran.commit();


    }
}*/
