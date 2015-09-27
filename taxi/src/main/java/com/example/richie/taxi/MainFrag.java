package com.example.richie.taxi;


import android.content.Intent;
import  android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFrag extends Fragment {


    public MainFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView tv;
        tv = (TextView) getActivity().findViewById(R.id.data);
      tv.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Intent in = new Intent(getActivity(),NextActivity.class);
              startActivityForResult(in,1);
          }
      });
    }
}
