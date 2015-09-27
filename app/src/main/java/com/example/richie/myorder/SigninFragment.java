package com.example.richie.myorder;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SigninFragment extends Fragment {

   Button btSignin , btSignup;

    public SigninFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btSignin = (Button) getActivity().findViewById(R.id.signin);
        btSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),AddItems.class);
                startActivity(in,
                        ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());

            }
        });


        btSignup = (Button) getActivity().findViewById(R.id.signout);
        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getActivity(),SignUpActivity.class);
                startActivity(next,
                        ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());

            }
        });

    }
}
