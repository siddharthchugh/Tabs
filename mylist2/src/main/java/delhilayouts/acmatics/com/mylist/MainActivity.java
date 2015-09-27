package delhilayouts.acmatics.com.mylist;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
     ActionBarDrawerToggle mDrawerToggle;
  Toolbar bar ;
    Fragment fragment1 = new Fragment1();
    Fragment fragment3 = new Fragment3();
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    String[] title;
    String[] subtitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mTitle = mDrawerTitle = getTitle();
        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);


        mDrawerList = (ListView) findViewById(R.id.listing);
        mDrawerList.setAdapter(new MyBaseAdapt(this));

        title = getResources().getStringArray(R.array.Categories);
       mDrawerList.setOnItemClickListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_menu, R.string.open,
                R.string.close)

        {

            public void onDrawerClosed(View view) {
                // TODO Auto-generated method stub
                super.onDrawerClosed(view);
                Toast.makeText(MainActivity.this,"Open",Toast.LENGTH_SHORT).show();

            }

            public void onDrawerOpened(View drawerView) {
                // TODO Auto-generated method stub
                // Set the title on the action when drawer open
                //           getSupportActionBar().setTitle(mDrawerTitle);
                super.onDrawerOpened(drawerView);
                Toast.makeText(MainActivity.this,"Closed",Toast.LENGTH_SHORT).show();

            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {

                mDrawerToggle.syncState();
            }
        });

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

/*
    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        mDrawerToggle.syncState();
    }
*/

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,title[position],Toast.LENGTH_SHORT).show();
        selectItem(position);
    }

    private void selectItem(int position)
    {
        mDrawerList.setItemChecked(position,true);
        setTitle(title[position]);
    }

    public void selected(String title)
    {
  getSupportActionBar().setTitle(title);

    }








     /*   mDrawerLayout.setDrawerListener(mDrawerToggle);


        mDrawerLayout.setDrawerShadow(R.drawable.abc_cab_background_top_material,
                GravityCompat.START);


        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_menu, R.string.open,
                R.string.close) {

            public void onDrawerClosed(View view) {
                   // TODO Auto-generated method stub
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                // TODO Auto-generated method stub
                // Set the title on the action when drawer open
     //           getSupportActionBar().setTitle(mDrawerTitle);
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

*/



/*
    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            selectItem(position);
        }

*/


/*
    private void selectItem(int position) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Locate Position
        switch (position) {
            case 0:
                ft.replace(R.id.content_frame, fragment1);
                break;
            case 1:
                ft.replace(R.id.content_frame, fragment3);
                break;
        }
        ft.commit();
        mDrawerList.setItemChecked(position, true);

        // Get the title followed by the position
        setTitle(title[position]);
        // Close drawer
        mDrawerLayout.closeDrawer(mDrawerList);
    }
*/

/*
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (item.getItemId() == android.R.id.home) {

            if (mDrawerLayout.isDrawerOpen(mDrawerList))
            {
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        }

        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }
*/

}
