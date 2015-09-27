package com.example.richie.myfragtofrag;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
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


public class MainActivity extends ActionBarActivity {
    android.support.v7.widget.Toolbar tb;
   // NavigateMode nf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  /*      tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*//*
        nf = (NavigateMode) getFragmentManager().findFragmentById(R.id.fragment);
        nf.setUp(R.id.container,(DrawerLayout) findViewById(R.id.drawerLayout), tb);
*/

/*

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .addToBackStack(null)
                    .commit();
        }
*/

        Button bt;
        bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,NextPage.class);
                Bundle bndlanimation =
                        ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.anim, R.anim.animate1).toBundle();
                startActivity(i, bndlanimation);

            }
        });


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

                ScreenUtility su = new ScreenUtility(this);
                String output = "Width"+ su.getDpwidth()+ " "+
                        "Height" + su.getDpheight();
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setMessage(output)
                        .setTitle("Dimension")
                        .create()
                        .show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

        Button bt;
          bt = (Button) getActivity().findViewById(R.id.button);
          bt.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent i=new Intent(getActivity(),NextPage.class);
/*
                  Bundle bndlanimation =
                          ActivityOptions.makeCustomAnimation(getActivity(), R.anim.anim, R.anim.animate1).toBundle();
*/
                  startActivity(i);

              }
          });

        }
    }
}
