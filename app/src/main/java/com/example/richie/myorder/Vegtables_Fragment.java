package com.example.richie.myorder;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Vegtables_Fragment extends Fragment {


    public Vegtables_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vegtables, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView lstVeg;

        lstVeg = (ListView) getActivity().findViewById(R.id.listVegetables);
        lstVeg.setAdapter(new MyBaseAdapter(getActivity()));

    }
}
