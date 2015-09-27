package com.example.richie.simplefrags;


import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import  android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneWay extends Fragment {
    private Button oneWay;
   private EditText ed_Date;
    private int mYear, mMonth, mDay, mHour, mMinute;
    static final int DIALOG =0;

    public OneWay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

View v = inflater.inflate(R.layout.fragment_one_way, container, false);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       ed_Date = (EditText) getActivity().findViewById(R.id.Date);
        ed_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final Calendar cal = Calendar.getInstance();
                mYear = cal.get(Calendar.YEAR);
                mMonth = cal.get(Calendar.MONTH);
                mDay = cal.get(Calendar.DAY_OF_MONTH);
                showDialog(DIALOG);


                Toast.makeText(getActivity(),"Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Dialog showDialog(int dialog) {
        if(dialog==DIALOG)
            return new DatePickerDialog(getActivity(),datepickerlistener,mYear,mMonth,mDay);
        return null;
    }


    private DatePickerDialog.OnDateSetListener datepickerlistener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                    mYear = year;
                    mMonth= month+1;
                    mDay = day;
                    Toast.makeText(getActivity(),mYear +"/" +mMonth +"/"+ +mDay,Toast.LENGTH_SHORT).show();

                }
            };

}

