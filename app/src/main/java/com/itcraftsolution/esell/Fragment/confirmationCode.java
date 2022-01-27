package com.itcraftsolution.esell.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentConfirmationCodeBinding;

import java.util.concurrent.TimeUnit;

public class confirmationCode extends Fragment {

    private SharedPreferences spf;
    private FragmentConfirmationCodeBinding binding;
    private String CountryCode , PhoneNumber, UserNumber, VerifyId;
    private FirebaseAuth auth;
    private ProgressDialog dialog, CheckOtpDialog;

    public confirmationCode() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentConfirmationCodeBinding.inflate(getLayoutInflater());

        dialog = new ProgressDialog(getContext());
        CheckOtpDialog = new ProgressDialog(getContext());
        dialog.setTitle("OTP Verification");
        dialog.setMessage("Sending OTP ...");
        CheckOtpDialog.setTitle("OTP Verification");
        CheckOtpDialog.setMessage("Verify PhoneNumber & OTP ...");

        auth = FirebaseAuth.getInstance();
        spf = requireContext().getSharedPreferences("UserDetails" , Context.MODE_PRIVATE);
        CountryCode = spf.getString("CountryCode" , null);
        PhoneNumber = spf.getString("PhoneNumber" , null);

        binding.tvDisplayCountryCode.setText(CountryCode);
        binding.tvDisplayPhoneNumber.setText(PhoneNumber);

        UserNumber = "+91"+PhoneNumber;
        sendVerificationCode(UserNumber);
        dialog.show();
        binding.btnContinuePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckOtp())
                {
                    verifyCode(binding.otpView.getOTP());
                    CheckOtpDialog.show();
                }

            }
        });

        return  binding.getRoot();
    }

    private void sendVerificationCode(String phoneNumber) {

        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                .setActivity(requireActivity())
                .setPhoneNumber(phoneNumber)
                .setCallbacks(callbacks)
                .setTimeout(30L, TimeUnit.SECONDS)
                .build();

        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            final String Code = phoneAuthCredential.getSmsCode();
            if(Code != null)
            {

            binding.otpView.setOTP(Code);
            verifyCode(Code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

            Toast.makeText(getContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            dialog.dismiss();
            VerifyId = s;
        }
    };

    private void verifyCode(String code) {

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(VerifyId , code);
        SignInWithCredential(credential);
    }

    private void SignInWithCredential(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    CheckOtpDialog.dismiss();

                    SharedPreferences sharedPreferences = requireContext().getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.putString("UserPhoneNumber", UserNumber);
                    editor.apply();

                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.remove(confirmationCode.this);
                    fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                    fragmentTransaction.replace(R.id.frUserDetailsContainer,new UserProfileFragment());
                    fragmentTransaction.addToBackStack(null).commit();
                }
                else {
                    Toast.makeText(getContext(), ""+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    Toast.makeText(getContext(), "Please Try Again", Toast.LENGTH_LONG).show();
                }
            }
        });
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