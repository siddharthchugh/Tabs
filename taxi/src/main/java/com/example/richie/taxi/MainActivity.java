package com.example.richie.taxi;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView tc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 MainFrag frag = new MainFrag();
        FragmentManager manage = getSupportFragmentManager();
        FragmentTransaction tram =  manage.beginTransaction().add(R.id.fragment,frag,"");
       tram.addToBackStack(null);
        tram.commit();

 /*   tc  = (TextView) findViewById(R.id.data);
    tc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent in = new Intent(MainActivity.this
      ,NextActivity.class);
            startActivity(in, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        }
    });

 */   }


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
