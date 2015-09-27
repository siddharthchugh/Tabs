package com.example.richie.myfragtofrag;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class NavigateMode extends Fragment implements Recycle_Adapt.ClickListener {

    ActionBarDrawerToggle abt;
    DrawerLayout drawerlayout;
    RecyclerView view_Recycled;
    Recycle_Adapt adapter;
    private boolean UserLearnedDrawer;
    private View container;
    private boolean fromSavedInstanceState;
    private static final String PREFERENCE_NAME_FILE="textpreference";
    private static final String Key_USER_LEARNED_DRAWER = "user_learned_drawer";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserLearnedDrawer =Boolean.valueOf(readPreference(getActivity(),Key_USER_LEARNED_DRAWER,"false"));
        if(savedInstanceState!=null){
            fromSavedInstanceState = true;
        }
/*
        Bundle b = getActivity().getIntent().getExtras();
        String value = b.getString("userID");
        TextView tv = (TextView) getActivity().findViewById(R.id.textView3);
        tv.setText(value);
*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_navigatemode, container, false);




        view_Recycled = (RecyclerView) v.findViewById(R.id.viewRecycle);

        adapter = new Recycle_Adapt(getActivity(),getData());
        adapter.setClickListener(this);
        view_Recycled.setAdapter(adapter);
        view_Recycled.setLayoutManager(new LinearLayoutManager(getActivity()));
        view_Recycled.addOnItemTouchListener(new RecyclerViewTouch(getActivity(),view_Recycled,new ClickListener() {
            @Override
            public void onClick(View v, int position) {

                Toast.makeText(getActivity(),"Clicked once"+ position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLOngClick(View v, int position) {
                Toast.makeText(getActivity(),"Long Clicked once"+ position,Toast.LENGTH_SHORT).show();

            }

        } ));
        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
/*
        Bundle b = getActivity().getIntent().getExtras();
        String value = b.getString("userID");
        TextView tv = (TextView) getActivity().findViewById(R.id.textView3);
        tv.setText(value);
*/




    }

    public static List<SlideLink> getData(){

        List<SlideLink> ls = new ArrayList<>();
        String[] lk = {"About Us","Scheduled Trips","Help","Profile"};
        int[] in = {R.mipmap.listcart,R.mipmap.listcart,R.mipmap.listcart,R.mipmap.listcart };
        for (int i = 0; i < lk.length && i<in.length; ++i) {
            SlideLink info = new SlideLink();
            info.rowData = lk[i];
            info.icon = in[i];
            ls.add(info);
        }
        return ls;
    }

    public void setUp(int fragmentID,DrawerLayout dl, Toolbar tb) {

        container = getActivity().findViewById(fragmentID);
        drawerlayout = dl;

        abt = new ActionBarDrawerToggle(getActivity(), dl, tb, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(!UserLearnedDrawer){
                    UserLearnedDrawer = true;
                    savedPreference(getActivity(), Key_USER_LEARNED_DRAWER, UserLearnedDrawer + "");

                }

                getActivity().invalidateOptionsMenu();

            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

        };

        if(!UserLearnedDrawer && !fromSavedInstanceState){
            drawerlayout.openDrawer(container);
        }

        drawerlayout.setDrawerListener(abt);

        drawerlayout.post(new Runnable() {
            @Override
            public void run() {

                abt.syncState();
            }
        });

    }

    @Override
    public void onListItemClick(View v, int position) {

    }

/*
    @Override
    public void onListItemClick(View v, int position) {
        final Intent intent;
        switch (position){
            case 0:
          //      intent =  new Intent(getActivity(), LoginActvity.class);

                break;

            case 1:
            //    intent =  new Intent(getActivity(), RegistrationActivity.class);
                break;

*/
/*
            case 2:
                intent =  new Intent(getActivity(), ProfileActivity.class);
                break;
*//*


            default:
                intent =  new Intent(getActivity(), ProfileActivity.class);

                break;
        }

        getActivity().startActivity(intent);
        drawerlayout.closeDrawer(container);

    }
*/

    class RecyclerViewTouch implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        RecyclerViewTouch(Context conRecycle,RecyclerView rc, ClickListener cl){

            gestureDetector = new GestureDetector(conRecycle,new GestureDetector.SimpleOnGestureListener(){

                @Override
                public boolean onSingleTapUp(MotionEvent e) {

                    Log.d("Gesture Detector","Single tab event"+e);
                    return super.onSingleTapUp(e);


                }

                @Override
                public void onLongPress(MotionEvent e) {
                    super.onLongPress(e);
                }
            });

            Log.d("Gesture Detector","Constructor"+rc);

        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            Log.d("Gesture Detector","Intercept touch event"+gestureDetector.onTouchEvent(e)+""+e);

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            Log.d("Gesture Detector","Touch event"+e);

        }
    }


    public void savedPreference(Context con,String preferenceNames,String preferenceValues){

        SharedPreferences preferences =   con.getSharedPreferences(PREFERENCE_NAME_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit= preferences.edit();
        edit.putString(preferenceNames,preferenceValues);
        edit.apply();
    }


    public static String readPreference(Context con,String preferenceNames,String preferenceValues){
        SharedPreferences preferences =   con.getSharedPreferences(PREFERENCE_NAME_FILE, Context.MODE_PRIVATE);
        return preferences.getString(preferenceNames,preferenceValues);
    }




    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        abt.onConfigurationChanged(newConfig);
    }

    public static interface ClickListener{
        public void onClick(View v, int position);
        public void onLOngClick(View v, int position);
    }

}