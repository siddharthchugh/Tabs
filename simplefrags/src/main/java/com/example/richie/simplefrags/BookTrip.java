    package com.example.richie.simplefrags;

    import android.app.ActivityOptions;
    import android.app.AlertDialog;
    import android.content.Intent;
    import android.graphics.Color;
    import android.os.Bundle;
    import android.support.annotation.Nullable;
    import android.support.v4.app.Fragment;
    import android.support.v4.app.FragmentManager;
    import android.support.v4.app.FragmentTransaction;
    import android.support.v4.widget.DrawerLayout;
    import android.support.v7.app.ActionBarActivity;
    import android.view.LayoutInflater;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.Toast;


    public class BookTrip extends ActionBarActivity {
        android.support.v7.widget.Toolbar tb;
        Fragment fr;
        Button bt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_book_trip);
            tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBar);
            tb.setTitleTextColor(Color.rgb(255, 152, 0));
            setSupportActionBar(tb);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
      /*      OneWay book_Tip = new OneWay();
            FragmentManager manageTrip = getSupportFragmentManager();
            FragmentTransaction tran = manageTrip.beginTransaction().add(R.id.fragmentplace, book_Tip, "");
            tran.commit();
      */  }


        public void trip(View v) {

            Button bt, bt2;
//FragementActivity		fr = new FragementActivity();

            Fragment fr;

            if (v == findViewById(R.id.roundTrip)) {

                fr = new OneWay();

            } else {
                fr = new RoundTrip();
/*
                bt2 = (Button) findViewById(R.id.selectD);
                bt2.setVisibility(View.INVISIBLE);
*/
            }

            FragmentManager manages = getSupportFragmentManager();
            FragmentTransaction tran = manages.beginTransaction();
            tran.replace(R.id.fragmentplace, fr, "");
//        tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            //   tran.addToBackStack(null);
            tran.commit();
        }

public void drive(View v){

    Intent i=new Intent(this,Drive_Selection.class);
    Bundle bndlanimation =
            ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.anim, R.anim.animate1).toBundle();
    startActivity(i, bndlanimation);


}
        @Override
        public void finish() {
            super.finish();
            overridePendingTransition(R.anim.slide_rightin, R.anim.sliderightout);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_book_trip, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            switch (id) {

                case android.R.id.home:
                    //                NavUtils.getParentActivityIntent(this);
                    onBackPressed();
                    overridePendingTransition(R.anim.slide_rightin, R.anim.sliderightout);

                    break;

                case R.id.action_settings:

                    ScreenUtility su = new ScreenUtility(this);
                    String output = "Width" + su.getDpwidth() + " " +
                            "Height" + su.getDpheight();
                    AlertDialog.Builder ad = new AlertDialog.Builder(this);
                    ad.setMessage(output)
                            .setTitle("Dimension")
                            .create()
                            .show();
                    break;

            }


                return super.onOptionsItemSelected(item);
            }

        }
