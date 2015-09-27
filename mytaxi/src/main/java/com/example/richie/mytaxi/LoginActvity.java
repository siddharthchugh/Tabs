package com.example.richie.mytaxi;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class LoginActvity extends ActionBarActivity {
    android.support.v7.widget.Toolbar tb;
    DrawerLayout dl;
    Fragment lf;
    NavigateMode nf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nf = (NavigateMode) getFragmentManager().findFragmentById(R.id.fragment);
        nf.setUp(R.id.fragment,(DrawerLayout) findViewById(R.id.drawerLayout), tb);
        Login_SessionFragment session = new Login_SessionFragment();
        FragmentManager manage = getSupportFragmentManager();
        FragmentTransaction tran = manage.beginTransaction().add(R.id.loginContent,session,"");
        tran.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_login_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
   /*  switch (id){
         case android.R.id.home:
             Intent upIntent = NavUtils.getParentActivityIntent(this);
             if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                 // This activity is NOT part of this app's task, so create a new task
                 // when navigating up, with a synthesized back stack.
                 TaskStackBuilder.create(this)
                         // Add all of this activity's parents to the back stack
                         .addNextIntentWithParentStack(upIntent)
                                 // Navigate up to the closest parent
                         .startActivities();
             } else {
                 // This activity is part of this app's task, so simply
                 // navigate up to the logical parent activity.
                 NavUtils.navigateUpTo(this, upIntent);
             }
return true;
    }
*/
        return super.onOptionsItemSelected(item);

    }





  @Override
    public void onBackPressed() {
        super.onBackPressed();
      finish();
    }

}
