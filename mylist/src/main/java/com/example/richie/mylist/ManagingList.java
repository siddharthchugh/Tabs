/*
package com.example.richie.mylist;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.ResourceCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

*/
/**
 * Created by Richie on 27-04-2015.
 *//*


class SingleList{

    int  images;
    String data;

    SingleList(String t,int im){

        this.data = t;
        this.images = im;
    }



}



public class ManagingList extends BaseAdapter {
*/
/*

    String[] title;
    int[] img;
*//*


    Context con;
    ArrayList<SingleList> ls ;


    ManagingList(Context c){

        ls = new ArrayList<SingleList>();

        Resources rs = c.getResources();
        String[] ti= rs.getStringArray(R.array.country);
        int[] img = {R.drawable.abc_ic_clear_mtrl_alpha,R.drawable.abc_ic_clear_mtrl_alpha,
               */
/* R.drawable.abc_ic_clear_mtrl_alpha,R.drawable.abc_ic_clear_mtrl_alpha,
                R.drawable.abc_ic_clear_mtrl_alpha,R.drawable.abc_ic_clear_mtrl_alpha,
                R.drawable.abc_ic_clear_mtrl_alpha,R.drawable.abc_ic_clear_mtrl_alpha,
               *//*
 R.drawable.abc_ic_clear_mtrl_alpha

        };

        for(int i=0;i<3;i++){

         ls.add(new SingleList(ti[i],img[i]));


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
    public View getView(int i, View view, ViewGroup viewGroup) {



        LayoutInflater in = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View v = in.inflate(R.layout.data_layout,viewGroup,false);

        TextView tv = (TextView) v.findViewById(R.id.textView);
      //  ImageView vw = (ImageView) v.findViewById(R.id.imageView);

        SingleList temp = ls.get(i);
        tv.setText(temp.data);
     //   vw.setImageResource(temp.images);
        return v;
    }
}
*/
