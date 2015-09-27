package com.example.richie.myorder;


import android.app.ActivityOptions;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Adddata_fragment extends Fragment {

    Button btDryFruits, btFruits, btVegetables;

    public Adddata_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adddata_fragment, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btDryFruits = (Button) getActivity().findViewById(R.id.project_Manager);

        btDryFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getActivity(), DFruits.class);
                startActivity(in,
                        ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());

            }
        });


        btFruits = (Button) getActivity().findViewById(R.id.project_Task);

        btFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getActivity(), Fruits.class);
                startActivity(in,
                        ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());

            }
        });


        btVegetables = (Button) getActivity().findViewById(R.id.Employee_Details);

        btVegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getActivity(),Vegetables.class);
                startActivity(in,
                        ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());

            }
        });

    }
}