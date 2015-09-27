package delhilayouts.acmatics.com.mylist;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/*creating composite class with attributes in it.*/

class SingleItems{
	
	String name;
	String capital ; 
	
		public SingleItems(String name,String cp) {

		this.name = name;
	this.capital = cp;
		
	}
	
}

public class MyBaseAdapt extends BaseAdapter {

ArrayList<SingleItems>  li;
Context con;


    MyBaseAdapt(Context c){
    	
    	con  = c;
    	li = new ArrayList<SingleItems>();
        
    	Resources res =  c.getResources();
    	String[] name = res.getStringArray(R.array.Categories);
    	String[] cap = res.getStringArray(R.array.Categories);
       
    	for(int i=0;i<3;i++){
    	li.add(new SingleItems(name[i],cap[i]));
    	}
    	
    
    }
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return li.size();
	}

	@Override
	public Object getItem(int i) {
		// TODO Auto-generated method stub
		return li.get(i);
	}

	@Override
	public long getItemId(int i) {
		// TODO Auto-generated method stub
		return i;
	}

	@Override
	public View getView(int i, View arg1, ViewGroup parent) {

		LayoutInflater infl = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View vRow= infl.inflate(R.layout.data_item, parent,false);
		
		TextView T_name = (TextView) vRow.findViewById(R.id.textView1);
		TextView T_capital = (TextView) vRow.findViewById(R.id.textView2);
		
	 SingleItems temp = li.get(i);
		T_name.setText(temp.name);
		T_name.setText(temp.capital);
		
		return vRow;
	}

}
