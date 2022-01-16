package com.itcraftsolution.esell.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.itcraftsolution.esell.R;

public class phoneLogin extends Fragment {


    public phoneLogin() {
        // Required empty public constructor
    }

    private EditText etPhone;
    private Button btnNext;
    private ImageView ivBack;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phone_login, container, false);


        etPhone = view.findViewById(R.id.etEnterPhoneNumber);
        btnNext = view.findViewById(R.id.btnPhoneNumLogin);
        ivBack = view.findViewById(R.id.ivphoneDetailsBackArrow);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPhoneNumber()) {

                    StoreUserDetails("+91" , etPhone.getText().toString());
                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frUserDetailsContainer, new confirmationCode());
                    fragmentTransaction.commit();
                }
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frUserDetailsContainer, new login());
                fragmentTransaction.commit();
            }
        });
        return view;

    }

    private boolean checkPhoneNumber() {
        boolean condition = true;
        if (etPhone.getText().toString().length() != 10) {
            etPhone.setError("Phone number be 10 digits");
            condition = false;
        }
        return condition;
    }
    private SharedPreferences StoreUserDetails(String CountryCode , String PhoneNumber)
    {
        SharedPreferences spf = getContext().getSharedPreferences("UserDetails" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putString("CountryCode" , CountryCode);
        editor.putString("PhoneNumber" , PhoneNumber);
        editor.apply();
        return spf;
    }

}


