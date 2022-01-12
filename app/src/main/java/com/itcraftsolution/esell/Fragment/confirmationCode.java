package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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


        btncontinue = view.findViewById(R.id.btnContinuePhone);



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