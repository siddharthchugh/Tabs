package com.example.richie.tripbooking;

import android.app.ActivityOptions;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;


public class Drive_Selection extends AppCompatActivity {
    private   android.support.v7.widget.Toolbar tb;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    RadioGroup orientation;
    Fragment fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive__selection);
        tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBar);
        tb.setTitle("Drive");
        tb.setTitleTextColor(Color.WHITE);
        setSupportActionBar(tb);
     //   orientation = (RadioGroup) findViewById(R.id.driveSelection);
       // orientation.setOnCheckedChangeListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

/*
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.radioButton:
                fr = new Tab1Fragment();
                break;

            case R.id.radioButton2:
                fr = new Tab2Fragment();

                break;

            case R.id.radioButton3:
                fr = new Tab3Fragment();


                break;

        }
        FragmentManager manages = getFragmentManager();
        FragmentTransaction tran = manages.beginTransaction();
        tran.replace(R.id.fragmentplace, fr, "");

        tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        tran.commit();

    }
*/

    public void personal_details(View v){

        Intent i=new Intent(Drive_Selection.this,PersonalDetail.class);
        Bundle bndlanimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.anim, R.anim.animate1).toBundle();
        startActivity(i, bndlanimation);


    }

/*
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener
            = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drive__selection, menu);
        return true;
    }

/*
    public void personal_details(View v){
*/
/*
        Intent i=new Intent(Drive_Selection.this,PersonalDetails.class);
        Bundle bndlanimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.anim, R.anim.animate1).toBundle();
        startActivity(i, bndlanimation);
*//*


        Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show();
    }
*/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:

              onBackPressed();
             overridePendingTransition(R.anim.slide_rightin, R.anim.sliderightout);

                break;


        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_rightin, R.anim.sliderightout);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
/*
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_drive__selection, container, false);
            return rootView;
        }
    }
*/
}
