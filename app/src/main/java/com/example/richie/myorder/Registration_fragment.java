package com.example.richie.myorder;


import  android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registration_fragment extends Fragment {

    private Button completeActiom;

    public Registration_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_thanks, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        completeActiom = (Button) getActivity().findViewById(R.id.click);
        completeActiom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
/*

                String url = "http://www.google.com";
                Intent inUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
               // inUrl.setAction(Intent.ACTION_SEND);
                startActivity(inUrl);
*/
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.activity_custom_dialog);
                dialog.setTitle("Title...");







                dialog.show();

                        }
        });


    }
}