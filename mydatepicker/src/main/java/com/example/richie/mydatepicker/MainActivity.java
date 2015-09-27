package com.example.richie.mydatepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    TextView tv;
    private int mYear, mMonth, mDay, mHour, mMinute;
static final int DIALOG =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.data);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cal = Calendar.getInstance();
                mYear = cal.get(Calendar.YEAR);
                mMonth = cal.get(Calendar.MONTH);
                mDay = cal.get(Calendar.DAY_OF_MONTH);
            showDialog(DIALOG);

            }
            });
        }


    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==DIALOG)
        return new DatePickerDialog(this,datepickerlistener,mYear,mMonth,mDay);
        return null;
    }

    private DatePickerDialog.OnDateSetListener datepickerlistener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                    mYear = year;
                    mMonth= month+1;
                    mDay = day;
                    Toast.makeText(MainActivity.this,mYear +"/" +mMonth +"/"+ +mDay,Toast.LENGTH_SHORT).show();

                }
            };
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
