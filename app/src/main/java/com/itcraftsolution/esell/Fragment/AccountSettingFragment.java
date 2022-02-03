package com.itcraftsolution.esell.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.google.firebase.auth.FirebaseAuth;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.UserLogin;
import com.itcraftsolution.esell.databinding.FragmentAccountSettingFargmentBinding;
import com.itcraftsolution.esell.spf.SpfUserData;


public class AccountSettingFragment extends Fragment {

    public AccountSettingFragment() {
        // Required empty public constructor
    }

   private FragmentAccountSettingFargmentBinding binding;
    private FirebaseAuth auth;
    private SharedPreferences spf;
    private boolean isDelete = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      binding = FragmentAccountSettingFargmentBinding .inflate(getLayoutInflater());

        auth = FirebaseAuth.getInstance();

        spf = requireContext().getSharedPreferences("ThemeMode" , Context.MODE_PRIVATE);
        binding.btnSwitch.setChecked(spf.getBoolean("ThemeMode",false));

        if (binding.btnSwitch.isChecked()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            binding.txLightMode.setText("Dark Mode");
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        binding.btnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    ThemeMode(true);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    ThemeMode(false);
                }
            }
        });

      binding.txLogout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              new AlertDialog.Builder(getContext())
                      .setTitle("Logout Account")
                      .setMessage("Are Sure To Logout This Account ?")
                      .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              SpfUserData spfUserData = new SpfUserData();
                               isDelete = spfUserData.RemoveAllSpf(requireContext());
                               if(isDelete)
                               {
                                   auth.signOut();
                                   Intent intent = new Intent(getContext() , UserLogin.class);
                                   intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                   startActivity(intent);
                                   requireActivity().finish();
                               }
                          }
                      })
                      .setNegativeButton("No", null)
                      .setIcon(R.drawable .ic_baseline_outlet_24)
                      .show();
          }
      });

      return binding.getRoot();
    }

    private  void ThemeMode(boolean Mode){
        SharedPreferences spf = requireContext().getSharedPreferences("ThemeMode", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putBoolean("ThemeMode",Mode);
        editor.apply();

    }
}