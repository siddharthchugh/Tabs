package com.example.richie.mywebviewscreen;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        WebView myWebView = (WebView) findViewById(R.id.webvw);
        myWebView.loadUrl("http://www.ahataxis.com");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
*/

        WebView_Fragment wf = new WebView_Fragment();
        FragmentManager manage = getSupportFragmentManager();
        FragmentTransaction tans = manage.beginTransaction().add(R.id.fragment,wf,"");
        tans.commit();



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


    public boolean isConnected(){

        ConnectivityManager connect_Manger = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connect_Manger.getActiveNetworkInfo();
        if(networkInfo!=null &&  networkInfo.isConnectedOrConnecting())
        {

/*    		if(networkInfo.getType()!= ConnectivityManager.TYPE_WIFI){
    			Toast.makeText(this, "this app doesn't run without wifi", Toast.LENGTH_SHORT).show();
    		return false;
    		}
*/
            return true;

        }
        else
        {
            return false;
        }
    }




    public class MySite extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }



}