package com.example.richie.simplefrags;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Richie on 12-03-2015.
 */
public class Recycle_Adapt extends RecyclerView.Adapter<Recycle_Adapt.MyHolder>{

   private LayoutInflater inflater;
    private ClickListener clicklisten;
    List<SlideLink> ls = Collections.emptyList();
   Context context;
    public Recycle_Adapt(Context con, List<SlideLink> data){
   this.context= con;
    inflater = LayoutInflater.from(con);
    this.ls = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int i) {

   View vw = inflater.inflate(R.layout.slide_link,parent,false);
    MyHolder holder = new MyHolder(vw);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder myHolder, int position) {

        SlideLink current = ls.get(position);
        myHolder.tv.setText(current.rowData);
     //   myHolder.iv.setImageResource(current.icon);

    }



  public void setClickListener(ClickListener click){
        this.clicklisten = click;
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tv;
        ImageView iv;

        public MyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            iv = (ImageView) itemView.findViewById(R.id.slideicon);
            tv = (TextView) itemView.findViewById(R.id.slidetext);
        }

        @Override
        public void onClick(View v) {
/*
            final Intent intent;
            switch (getPosition()){
                case 0:
                    intent =  new Intent(context, LoginActvity.class);

                    break;

                case 1:
                    intent =  new Intent(context, SecondActivty.class);
                    break;

                default:
                          intent =  new Intent(context, LoginActvity.class);

                    break;
            }
*/
//            context.startActivity(intent);
           // context.startActivity(new Intent(context,SecondActivty.class));
            if(clicklisten!=null){
                clicklisten.onListItemClick(v,getPosition());
            }
        }
    }
    public interface ClickListener{

        public void onListItemClick(View v, int position);

    }
}
