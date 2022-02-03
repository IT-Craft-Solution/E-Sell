package com.itcraftsolution.esell.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.UserLogin;
import com.itcraftsolution.esell.databinding.FragmentAccountBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

public class AccountFragment extends Fragment {

    public AccountFragment() {
        // Required empty public constructor
    }

       private SpfUserData spf;
       private FragmentAccountBinding  binding;
       private String Image,Name, About;
       private FirebaseAuth auth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(getLayoutInflater());

        auth = FirebaseAuth.getInstance();


        LoadData();
        binding.llAccountMyOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(AccountFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new AccountMyordersFragment());
                fragmentTransaction.addToBackStack(null).commit();
            }
        });
        binding.llAccountHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(AccountFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new AccountHelpFragment());
                fragmentTransaction.addToBackStack(null).commit();
            }
        });
        binding.llAccountLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(AccountFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new AccountSettingFragment());
                fragmentTransaction.addToBackStack(null).commit();

            }
        });
        binding.btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(AccountFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new EditProfileFragment());
                fragmentTransaction.addToBackStack(null).commit();
            }
        });

      return binding.getRoot();
    }
    private void LoadData()
    {
        spf = new SpfUserData();
       Image = spf.getSpf(requireContext()).getString("UserImage",null);
       Name = spf.getSpf(requireContext()).getString("UserName",null);
       About = spf.getSpf(requireContext()).getString("UserBio",null);

       binding.txUserName.setText(Name);
       binding.txUserAbout.setText(About);
        Glide.with(requireContext()).load(ApiUtilities.UserImage +Image)
                .into(binding.igProfileImage);
    }


}