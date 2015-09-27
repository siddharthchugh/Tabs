package com.example.richie.mymap;


import android.content.Intent;
import  android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextFragment extends Fragment {


    public NextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loginfragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button bt ;

        bt = (Button) getActivity().findViewById(R.id.button);
      bt.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent in = new Intent(getActivity(),MainActivity.class);
              startActivity(in);
          }
      });

    }



}
