package com.example.richie.mytasks;

import  android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    TextView tData;
    ProgressBar pb;
    List<Tasks> task;
    List<Student> stu_Info;
    final String url = "http://192.168.56.1/files/PostSent.php";
//final String url = "http://services.hanselandpetal.com/restfuljson.php";
 //final String url = "http://srisofttechnologies.com/dev/schoolapp/dev_client/webservice/getStudentDetails.php?%20step=studdetails&studentid=2420";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tData  = (TextView) findViewById(R.id.data);
        pb= (ProgressBar) findViewById(R.id.progressBar2);

        tData.setMovementMethod(new ScrollingMovementMethod());
        //    new MyTasks().execute();
        pb.setVisibility(View.INVISIBLE);
        task = new ArrayList<>();
        SendData();
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
    private void SendData() {
        if(IsConnection()) {


            Bundle bd = getIntent().getExtras();
            String name = bd.getString("name");
            String pwd = bd.getString("password");

            requestMethod(url,name,pwd);

        }
        else {
            Toast.makeText(this, "Not connected to the newtwork right now. Try again later", Toast.LENGTH_SHORT).show();
        }
    }

    private void requestMethod(String url,String nm,String pd) {

        RequestManager p = new RequestManager();
        p.setMethod("POST");
        p.setUri(url);
        p.setParams("userID",nm);
        p.setParams("userPWD",pd);
        Tasks task = new Tasks();
        task.execute(p);

    }


    public void update(String msg){

        tData.append(msg + "\n");
    }


    protected boolean IsConnection(){

        ConnectivityManager manage = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manage.getActiveNetworkInfo();
        if(info!=null && info.isConnectedOrConnecting()){

            return true;
        }
        else
        {
            return false;
        }

    }
    class Tasks extends AsyncTask<RequestManager,String,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            update("Starting the task");
            if(task.size()==0) {
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
            String content=     HttpManager.getData(strings[0]);

            return content;
        }


        @Override
        protected void onPostExecute(String s) {
            update(s);
            task.remove(this);

            if(task.size()==0) {
                pb.setVisibility(View.INVISIBLE);

            }


        }
    }

}
