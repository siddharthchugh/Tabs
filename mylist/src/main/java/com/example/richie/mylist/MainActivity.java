package com.example.richie.mylist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Toolbar tb;

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        tb.setTitleTextColor(Color.rgb(255, 152, 0));
        setSupportActionBar(tb);

        lv = (ListView) findViewById(R.id.listView);


        lv.setAdapter(new ManagingList(this));


    }


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

    class SingleList {

        int images;
        String data;
        String dc;

        SingleList(String t, int im,String cap) {

            this.data = t;
            this.images = im;
            this.dc = cap;
        }

    }

        class ManagingList extends BaseAdapter {

            Context con;
            ArrayList<SingleList> ls;


            ManagingList(Context c) {

                ls = new ArrayList<SingleList>();

                Resources rs = c.getResources();
                String[] ti = rs.getStringArray(R.array.country);
                String[] tid= rs.getStringArray(R.array.capital);

                int[] img = {R.drawable.right, R.drawable.right, R.drawable.right, R.drawable.right
                };
                for (int i = 0; i < 4; i++) {

                    ls.add(new SingleList(ti[i],img[i],tid[i]));


                }

            }


            @Override
            public int getCount() {
                return ls.size();
            }

            @Override
            public Object getItem(int i) {
                return ls.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup parent) {


                LayoutInflater in = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = in.inflate(R.layout.data_layout,parent, false);

                TextView tv = (TextView) view.findViewById(R.id.textView);
                TextView tv2 = (TextView) view.findViewById(R.id.textView2);

                ImageView vw = (ImageView) view.findViewById(R.id.imageView);

                SingleList temp = ls.get(i);
                tv.setText(temp.data);
                tv2.setText(temp.dc);

                vw.setImageResource(temp.images);
                return view;
            }


        }


