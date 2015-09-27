package com.example.richie.tripbooking;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Login_User extends AppCompatActivity {

    List<Tasks> task;
    ProgressBar pb;
    TextView tData;
    private Toolbar toolBar;



   static final String url = "http://192.168.56.1/PostSent.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getAttributes().windowAnimations = R.style.Fade;
        setContentView(R.layout.activity_login__user);
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("Family Vacation");
        toolBar.setTitleTextColor(Color.WHITE);
        tData = (TextView) findViewById(R.id.textView);
        pb= (ProgressBar) findViewById(R.id.progressBar);
task = new ArrayList<>();

        SData();
    }
    public void Next(View v){
        startActivity(new Intent(this, BookingTrip.class));
        overridePendingTransition(R.anim.animlogin, R.anim.fadeout);

//        overridePendingTransition(R.anim.animlogin, R.anim.fadeout);
  /*      Display display = ((WindowManager)
                getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        if ((display.getRotation() == Surface.ROTATION_0) ||
                (display.getRotation() == Surface.ROTATION_180)) {
            overridePendingTransition(R.anim.animlogin, R.anim.fadeout);
        } else if ((display.getRotation() == Surface.ROTATION_90) ||
                (display.getRotation() == Surface.ROTATION_270)) {
            overridePendingTransition(R.anim.anim, R.anim.animate1);
        }
*/
  /*      Intent inNext = new Intent(this,BookingTrip.class);
        startActivity(inNext);
        overridePendingTransition(R.anim.animlogin, R.anim.fadeout);*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login__user, menu);
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            tData.setText("onConfigChanged - Landscape");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            tData.setText("onConfigChanged - Portrait");
        }
    }
    private void SData() {
        if (IsConnection()) {


/*
            Bundle bd = getIntent().getExtras();
            String name = bd.getString("name");
            String pwd = bd.getString("password");

*/
            requestMethod(url);

        } else {
            Toast.makeText(this, "Not connected to the newtwork right now. Try again later", Toast.LENGTH_SHORT).show();
        }
    }

    private void requestMethod(String url/*,String nm,String pd*/) {

        RequestManager p = new RequestManager();
        p.setMethod("POST");
        p.setUri(url);
        p.setParams("userID", "Richiy");
        p.setParams("userPWD", "Chugh");
        Tasks task = new Tasks();
        task.execute(p);

    }

    private boolean IsConnection() {

        ConnectivityManager manage = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manage.getActiveNetworkInfo();
        if (info != null && info.isConnectedOrConnecting()) {

            return true;
        } else {
            return false;
        }


    }

    public void update(String msg) {

        tData.append(msg + "\n");
    }

    class Tasks extends AsyncTask<RequestManager, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            update("Starting the task");
            if (task.size() == 0) {
                pb.setVisibility(View.VISIBLE);

            }
            task.add(this);
        }

        @Override
        protected void onProgressUpdate(String... values) {

            update(values[0]);
        }

        @Override
        protected String doInBackground(RequestManager... strings) {

/*
            for(int i=0;i<strings.length;i++){
                publishProgress("Working with params" + strings[i]);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

*/
            String content = HttpManager.getData(strings[0]);

            return content;
        }


        @Override
        protected void onPostExecute(String s) {
            update(s);
            task.remove(this);

            if (task.size() == 0) {
                pb.setVisibility(View.INVISIBLE);

            }


        }


    }
}