package com.example.richie.mywebviewscreen;


import android.content.Intent;
import  android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Spash_Fragment extends Fragment {


    public Spash_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DisplayView();

        return inflater.inflate(R.layout.fragment_spash_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public void DisplayView(){
        Thread background = new Thread() {
            public void run() {

                try {

                    // Thread will sleep for 5 seconds
                    sleep(2*1000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getActivity(),MainActivity.class);
                    startActivity(i);

                  getActivity().finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();


    }

}

