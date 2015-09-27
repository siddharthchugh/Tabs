package com.example.richie.tripbooking;

import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class BookingTrip extends AppCompatActivity {

    private Toolbar toolBar;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private int to_year, to_month, to_day;
    final    int DATE_PICKER_TO = 0;
    final int DATE_PICKER_FROM = 1;
    private TextView trip_Date,trip_Month,trip_Year;
    private LinearLayout rt;
    String format = "dd-MM-yyyy";
    private EditText ed_From;
//    DatePickerDialog.OnDateSetListener from_dateListener,to_dateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_trip);
 toolBar = (Toolbar) findViewById(R.id.toolbar);
 toolBar.setTitle("Family Vacation");
        toolBar.setTitleTextColor(Color.WHITE);
        TextView tv = (TextView) findViewById(R.id.date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);
        String formattedNow = simpleDateFormat.format(new Date());
        tv.setText(formattedNow);


//        String ct = DateFormat.getDateInstance().format(new Date());

    }

/*
    public void trip(View v) {

        Button bt, bt2;
//FragementActivity		fr = new FragementActivity();

*/
/*
        Fragment fr;

        if (v == findViewById(R.id.roundTrip)) {

            fr = new OneWay();

        } else {
            fr = new RoundTrip();
      *//*

*/
/*      RelativeLayout ly = (RelativeLayout) findViewById(R.id.depret);
           ly.setVisibility(View.INVISIBLE);*//*
*/
/*

*//*

*/
/*
                bt2 = (Button) findViewById(R.id.selectD);
                bt2.setVisibility(View.INVISIBLE);
*//*
*/
/*

        }

        FragmentManager manages = getSupportFragmentManager();
        FragmentTransaction tran = manages.beginTransaction();
        tran.replace(R.id.fragmentplace, fr, "");
//        tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        //   tran.addToBackStack(null);
        tran.commit();
*//*

    }
*/

    public void drive(View v){

        Intent i=new Intent(this,Drive_Selection.class);
        Bundle bndlanimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.anim, R.anim.animate1).toBundle();
        startActivity(i, bndlanimation);


    }

    public void rtrip(View v){

    RelativeLayout lv = (RelativeLayout) findViewById(R.id.round_Trip);
    lv.setVisibility(View.VISIBLE);


    }
    public void one_Way(View v){

        RelativeLayout lv = (RelativeLayout) findViewById(R.id.round_Trip);
        lv.setVisibility(View.INVISIBLE);

    }


    public void dateDep(View v){

        final Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        showDialog(DATE_PICKER_FROM);


    }
    public void returnDate(View v){

        final Calendar cal = Calendar.getInstance();
        to_year = cal.get(Calendar.YEAR);
        to_month = cal.get(Calendar.MONTH);
        to_day = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        showDialog(DATE_PICKER_TO);


    }


    @Override
    protected Dialog onCreateDialog(int id) {

            switch(id){
                case DATE_PICKER_FROM:
                    return new DatePickerDialog(this, from_dateListener,  mYear, mMonth, mDay);
                case DATE_PICKER_TO:
                    return new DatePickerDialog(this, to_dateListener, to_year, to_month, to_day);
            }
            return null;
        }


/*
    @Override
    protected Dialog onCreateDialog(int dialog) {
        if(dialog==DIALOG) {
            return new DatePickerDialog(this, datepickerlistener, mYear, mMonth, mDay);
        }
        return null;
    }
*/

    private DatePickerDialog.OnDateSetListener from_dateListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                    mYear = year;
                    mMonth= month+1;
                    mDay = day;
                     trip_Date = (TextView) findViewById(R.id.date);

                    trip_Date.setText(mDay + "-" + mMonth + "-" + +mYear);
/*
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);
                    String formattedNow = simpleDateFormat.format(new Date());
                    trip_Date.setText(formattedNow);
*/
                 /*   String ct = DateFormat.getDateInstance().format(new Date());
                      trip_Date.setText(ct);
                 */   //                    Toast.makeText(BookingTrip.this,mYear +"/" +mMonth +"/"+ +mDay,Toast.LENGTH_SHORT).show();

                }
            };

    private DatePickerDialog.OnDateSetListener to_dateListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                    to_year = year;
                    to_month= month+1;
                    to_day = day;
                    trip_Date = (TextView) findViewById(R.id.returnDate);

                    trip_Date.setText(to_day + "-" + to_month+ "-" + +to_year);

                }
            };



/*
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_rightin, R.anim.sliderightout);
    }
*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_booking_trip, menu);
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
