package com.example.richie.slidingtabs;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class Adddata_fragment extends ListFragment  {

    ListView lv;

    public Adddata_fragment() {
        // Required empty public constructor
    }


/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adddata_fragment, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        ListView lv;
        lv = getListView();

        // ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.data,android.R.layout.simple_list_item_1);
        setListAdapter(new ProductAdapter(getActivity()));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                */
/*if (position == 1) {
                    Intent intent = new Intent(getActivity(), Category.class);
                    startActivity(intent);}
*//*

				Toast.makeText(getActivity(), "Clicked Me", Toast.LENGTH_SHORT).show();

            }
        });
    }
*/
}
