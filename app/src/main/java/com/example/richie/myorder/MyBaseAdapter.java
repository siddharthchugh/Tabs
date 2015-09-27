package com.example.richie.myorder;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Richie on 26-02-2015.
 */
public class MyBaseAdapter extends BaseAdapter {


    class SingleItem {
        int img;
        String text;
        boolean checking;

        public SingleItem(int im, String data) {

            this.img = im;
            this.text = data;

        }
    }


    Context c;
    ArrayList<SingleItem> ls;

    public MyBaseAdapter(Context con) {

        Resources rs = con.getResources();
        this.c = con;
        ls = new ArrayList<SingleItem>();
        String[] lk = rs.getStringArray(R.array.capital);
        int[] in = {R.drawable.abc_switch_thumb_material, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                R.mipmap.ic_launcher};
        for (int i = 0; i < 7; i++) {
            ls.add(new SingleItem(in[i], lk[i]));
        }

    }


    class GridHolder {
        TextView cp, cty;
        ImageView i, i1;

        public GridHolder(View v) {

            i = (ImageView) v.findViewById(R.id.imageView);
            cp = (TextView) v.findViewById(R.id.textView);
            //     i1 = (ImageView) v.findViewById(R.id.imageView2);

            //  cty = (TextView) v.findViewById(R.id.textView2);

        }


    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return ls.size();
    }

    @Override
    public Object getItem(int i) {
        // TODO Auto-generated method stub
        return ls.get(i);
    }

    @Override
    public long getItemId(int i) {
        // TODO Auto-generated method stub
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup parent) {


        View grid = v;
        GridHolder gh = null;
        if (grid == null) {
            LayoutInflater infl = (LayoutInflater) c
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = infl.inflate(R.layout.listdata, parent, false);
            gh = new GridHolder(grid);
            grid.setTag(gh);
        } else {
            gh = (GridHolder) grid.getTag();
        }


        SingleItem temp = ls.get(i);
        gh.cp.setText(temp.text);
        gh.i.setImageResource(temp.img);
/*
        gh.i1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(c, "Clicked", Toast.LENGTH_SHORT).show();

            }
        });
*/
        return grid;
    }
}
