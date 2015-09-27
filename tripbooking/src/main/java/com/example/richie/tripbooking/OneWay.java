package com.example.richie.tripbooking;


import android.content.Intent;
import  android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneWay extends Fragment {


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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView tdate = (TextView) getActivity().findViewById(R.id.values);
       tdate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent inDate = new Intent(getActivity(),DateOnway.class);
               startActivity(inDate);
           }
       });
    }
/*
    final Calendar cal = Calendar.getInstance();
    mYear = cal.get(Calendar.YEAR);
    mMonth = cal.get(Calendar.MONTH);
    mDay = cal.get(Calendar.DAY_OF_MONTH);
*/

//    showDialog(DIALOG);

}
