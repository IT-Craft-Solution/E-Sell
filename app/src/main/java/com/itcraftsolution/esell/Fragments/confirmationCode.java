package com.itcraftsolution.esell.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.itcraftsolution.esell.MainActivity;
import com.itcraftsolution.esell.R;

public class confirmationCode extends Fragment {

    public confirmationCode() {
        // Required empty public constructor
    }

    private EditText etCode1, etCode2, etCode3, etCode4;
    private Button btncontinue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirmation_code, container, false);

        etCode1 = view.findViewById(R.id.etCode_1);
        etCode2 = view.findViewById(R.id.etCode_2);
        etCode3 = view.findViewById(R.id.etCode_3);
        etCode4 = view.findViewById(R.id.etCode_4);
        btncontinue = view.findViewById(R.id.btnContinuePhone);

        etCode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCode1.setText("4");
            }
        });
        etCode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCode2.setText("7");
            }
        });
        etCode3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCode3.setText("2");
            }
        });
        etCode4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCode4.setText("9");
                btncontinue.setVisibility(View.VISIBLE);
            }
        });

        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frUserDetailsContainer,new mapsAndLocation());
                fragmentTransaction.commit();
            }
        });

        return  view;
    }
}