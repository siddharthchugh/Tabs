package com.example.richie.mytaxi;


import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_SessionFragment extends Fragment  implements View.OnClickListener{

    Button btSignin;
    private EditText ed_Name, ed_Password;

    private ProgressDialog dialog_Login_access;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


 btSignin = (Button) getActivity().findViewById(R.id.signin);
  btSignin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        new MyLoginTask().execute();
    }

    public void ShowDataO() {
    }

/*
        if (isConnected()) {

            Bundle bn = getIntent().getExtras();
            String name = bn.getString("userID");
            String pwd = bn.getString("userPWD");

            requestData(url,name,pwd);

        } else {
            Toast.makeText(getApplicationContext(), "Newtwork isn't Available",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isConnected() {
        ConnectivityManager connect_Manger = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connect_Manger.getActiveNetworkInfo();
        if(networkInfo!=null &&  networkInfo.isConnectedOrConnecting())
        {

*/
/*    		if(networkInfo.getType()!= ConnectivityManager.TYPE_WIFI){
    			Toast.makeText(this, "this app doesn't run without wifi", Toast.LENGTH_SHORT).show();
    		return false;
    		}
*//*

            return true;

        }
        else
        {
            return false;
        }

    }
*/

    class MyLoginTask extends AsyncTask<String,String,String>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            try {
                Thread.sleep(1000);
                dialog_Login_access =  new ProgressDialog(getActivity());
                dialog_Login_access.setMessage("Loading");
                dialog_Login_access.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog_Login_access.setCancelable(false);
                dialog_Login_access.setIndeterminate(true);
                dialog_Login_access.setProgressStyle(R.color.textColor);
                dialog_Login_access.show();

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }

        @Override
        protected String doInBackground(String... params) {
            ed_Name = (EditText)getActivity().findViewById(R.id.userName);
            ed_Password = (EditText)getActivity().findViewById(R.id.pwd);

            //	Toast.makeText(this, "hello",Toast.LENGTH_SHORT).show();
            String name = ed_Name.getText().toString();
            String pass = ed_Password.getText().toString();

            Intent in = new Intent(getActivity(),MainActivity.class);
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            in.putExtra("userID","Sidy");
            in.putExtra("userPWD","2121");

            startActivityForResult(in,1);



            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog_Login_access.dismiss();

        }
    }


}
