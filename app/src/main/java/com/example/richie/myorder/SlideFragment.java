package com.example.richie.myorder;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SlideFragment extends Fragment {
//ListView v;

    ActionBarDrawerToggle abt;
    DrawerLayout drawerlayout;
    ListView drawayerList;
 //   Fragment fragment1 = new SinginActivity();
    // Fragment fragment2 = new Other_LoginFragment();

    String[] title= {"About Us", "SignIn"};
    String[] subtitle;

    String mTitle="";
    public SlideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_slide,container,false);
        return v;
    }

    public void setUp(DrawerLayout dl,Toolbar tb) {
        drawayerList = (ListView) getActivity().findViewById(R.id.listView2);
        drawayerList.setAdapter(new MyBaseAdapter(getActivity()));
//        mTitle = mDrawerTitle = getTitle();


        drawerlayout = dl;
        abt = new ActionBarDrawerToggle(getActivity(), dl, tb, R.string.open, R.string.close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //     Toast.makeText(getActivity(),"Slider Closed",Toast.LENGTH_SHORT).show();
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //   Toast.makeText(getActivity(),"Slider Opened",Toast.LENGTH_SHORT).show();
                getActivity().invalidateOptionsMenu();

            }
        };
        drawerlayout.setDrawerListener(abt);

        drawerlayout.post(new Runnable() {
            @Override
            public void run() {

                abt.syncState();
            }
        });


        // Setting item click listener for the listview mDrawerList

        drawayerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {

                Toast.makeText(getActivity(), "Clikced" + position, Toast.LENGTH_SHORT).show();

  //              selectItem(position);


                // Closing the drawer
                //drawerlayout.closeDrawer(drawayerList);

            }

            private void selectItem(int position) {

          /*      FragmentManager manage = getFragmentManager();
                FragmentTransaction tran = manage.beginTransaction();

               // tran.add(R.id.replaceLayout,fragment1,"");
                tran.commit();

                drawayerList.setItemChecked(position, true);
                drawerlayout.closeDrawer(drawayerList);
*/

            }
        });


    }

    public void setTitle(String title){

        getActivity().getActionBar().setTitle(title);
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle
        // If it returns true, then it has handled
        // the nav drawer indicator touch event
        if (abt.onOptionsItemSelected(item)) {
            return true;
        }

        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        abt.onConfigurationChanged(newConfig);
    }
}
