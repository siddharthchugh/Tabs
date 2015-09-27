package com.example.richie.myfragtofrag;


import android.app.DatePickerDialog;
import android.app.Dialog;
import  android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneWay extends Fragment {

    EditText etDate;
    private int mYear, mMonth, mDay, mHour, mMinute;
    static final int DIALOG =0;

    public OneWay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_way, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

/*
        etDate = (EditText) getActivity().findViewById(R.id.editDate);
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cal = Calendar.getInstance();
                mYear = cal.get(Calendar.YEAR);
                mMonth = cal.get(Calendar.MONTH);
                mDay = cal.get(Calendar.DAY_OF_MONTH);
                showDialog(DIALOG);

//                Toast.makeText(getActivity(),"Clicked",Toast.LENGTH_LONG).show();
            }
        });
*/

    }


    protected Dialog showDialog(int id) {
        if(id==DIALOG)
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
