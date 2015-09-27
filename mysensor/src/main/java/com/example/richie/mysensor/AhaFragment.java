package com.example.richie.mysensor;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AhaFragment extends Fragment {

    ImageView iv;
    android.support.v7.widget.Toolbar tb;



    public AhaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aha, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

/*
      iv = (ImageView) getActivity().findViewById(R.id.imageView);
       iv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
//               getActivity().getActionBar().getTitle();

               tb = (android.support.v7.widget.Toolbar)getActivity().findViewById(R.id.toolbar);
               tb.setLogo(R.mipmap.listcart);
               tb.setTitle("Order Fresh");


           }
       });
*/



    }
}
