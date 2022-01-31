package com.itcraftsolution.esell.Fragment;

import android.app.AlertDialog;
import android.app.AppComponentFactory;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.google.firebase.auth.FirebaseAuth;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.UserLogin;
import com.itcraftsolution.esell.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment {

    public AccountFragment() {
        // Required empty public constructor
    }

       private SharedPreferences spf;
       private FragmentAccountBinding  binding;
       private FirebaseAuth auth;
       private Uri uri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(getLayoutInflater());

        auth = FirebaseAuth.getInstance();

        spf = requireContext().getSharedPreferences("UserProfile" , Context.MODE_PRIVATE);
        binding.txUserName.setText(spf.getString("UserName" , null));
        binding.txUserAbout.setText(spf.getString("UserAboutUs" , null));
       // uri = Uri.parse(spf.getString("UserProfileImage",null));


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

//                new AlertDialog.Builder(getContext())
//                        .setTitle("Logout Account")
//                        .setMessage("Are Sure To Logout This Account ?")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                auth.signOut();
//                                Intent intent = new Intent(getContext() , UserLogin.class);
//                                startActivity(intent);
//                                requireActivity().finishAffinity();
//                            }
//                        })
//                        .setNegativeButton("No", null)
//                        .setIcon(R.drawable .ic_baseline_outlet_24)
//                        .show();

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
}