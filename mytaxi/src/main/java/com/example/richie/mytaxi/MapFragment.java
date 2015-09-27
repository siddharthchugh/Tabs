package com.example.richie.mytaxi;


import  android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {

   private GoogleMap gMap;
    private final int GPS_RECOVERABLE_CODE = 9001;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }



    public boolean map_flower_service() {

        int isAvail = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(getActivity());

        boolean recoverMap_state = GooglePlayServicesUtil
                .isUserRecoverableError(isAvail);

        if (isAvail == ConnectionResult.SUCCESS) {
            return true;
        } else if (recoverMap_state) {
            Dialog dl = GooglePlayServicesUtil.getErrorDialog(isAvail, getActivity(), GPS_RECOVERABLE_CODE);
            dl.show();
        } else {
            Toast.makeText(getActivity(),
                    "Cannot connect to the GPS try again later ",
                    Toast.LENGTH_SHORT).show();
        }
        return false;

    }

}
