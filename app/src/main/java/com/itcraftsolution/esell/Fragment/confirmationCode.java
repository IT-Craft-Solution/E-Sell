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
import android.widget.Toast;

import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentConfirmationCodeBinding;

public class confirmationCode extends Fragment {

    private SharedPreferences spf;
    private FragmentConfirmationCodeBinding binding;
    private String CountryCode , PhoneNumber;

    public confirmationCode() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentConfirmationCodeBinding.inflate(getLayoutInflater());

        spf = getContext().getSharedPreferences("UserDetails" , Context.MODE_PRIVATE);
        CountryCode = spf.getString("CountryCode" , null);
        PhoneNumber = spf.getString("PhoneNumber" , null);

        binding.tvDisplayCountryCode.setText(CountryCode);
        binding.tvDisplayPhoneNumber.setText(PhoneNumber);

        binding.btnContinuePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckOtp())
                {
                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frUserDetailsContainer,new mapsAndLocation());
                    fragmentTransaction.commit();
                }

            }
        });

        return  binding.getRoot();
    }

    private boolean CheckOtp() {
        boolean condition = true;
        if (binding.otpView.getOTP().length() != 6) {
            Toast.makeText(getContext(), "Fill The OTP", Toast.LENGTH_SHORT).show();
            condition = false;
        }
        return condition;
    }

}