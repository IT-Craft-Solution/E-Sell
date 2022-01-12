package com.itcraftsolution.esell.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.itcraftsolution.esell.R;

public class login extends Fragment {


    public login() {
        // Required empty public constructor
    }

    Button btnContinueWithPhone,btnContinueWithGoogle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_login, container, false);

        btnContinueWithPhone = view.findViewById(R.id.btnContinueWithPhone);
        btnContinueWithGoogle = view.findViewById(R.id.btnContinueWithGoogle);


        btnContinueWithPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frUserDetailsContainer , new phoneLogin());
                fragmentTransaction.commit();
            }
        });


        btnContinueWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        return view;
    }
}