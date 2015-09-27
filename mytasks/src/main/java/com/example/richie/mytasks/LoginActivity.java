package com.example.richie.mytasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;



public class LoginActivity extends Activity {

    Toolbar toolBar;
    EditText edit_Name,edit_Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @SuppressWarnings("unchecked")
    public void signin(View v){

        edit_Name = (EditText)findViewById(R.id.editText);
        edit_Password = (EditText)findViewById(R.id.editText2);

        String message = edit_Name.getText().toString();
        String pass = edit_Password.getText().toString();

//        getWindow().setExitTransition(new Explode());

        //int pwd =Integer.parseInt(edit_Password.getText().toString());
        Intent in = new Intent(this,MainActivity.class);
        in.putExtra("name", message);
        in.putExtra("password",pass);
        startActivity(in);


        //			 startActivity(in);

        //   		     progressDialog.setProgress(5000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
