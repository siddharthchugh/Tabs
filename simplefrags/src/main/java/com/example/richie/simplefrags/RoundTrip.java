package com.example.richie.simplefrags;


import android.content.Intent;
import   android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoundTrip extends Fragment {

private  Button rt;
    public RoundTrip() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_round_trip, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

/*
        rt = (Button) getActivity().findViewById(R.id.selectDrive);
        rt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(getActivity(),"Clikced",Toast.LENGTH_SHORT).show();

                Intent in = new Intent(getActivity(), Drive_Selection.class);
                startActivity(in);

            }
        });
*/

    }
}
