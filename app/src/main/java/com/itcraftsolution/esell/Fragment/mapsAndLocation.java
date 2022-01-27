package com.itcraftsolution.esell.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.itcraftsolution.esell.databinding.FragmentMapsAndLocationBinding;
import com.itcraftsolution.esell.spf.SpfLoginUserData;


public class mapsAndLocation extends Fragment {


    public mapsAndLocation() {
        // Required empty public constructor
    }

    private FragmentMapsAndLocationBinding binding;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private String  UserEmail, UserImg, UserName, UserBio, UserLocation, UserArea,UserPhone;
    private int  UserStatus;
    private GoogleSignInAccount account;
    private  SpfLoginUserData spfLoginUserData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        binding = FragmentMapsAndLocationBinding.inflate(getLayoutInflater());

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        binding.btnLocationNavigation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                if(GetUserData())
                {
                    Toast.makeText(requireContext(), "User Created", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getContext(),MainActivity.class);
//                    startActivity(intent);
//                    requireActivity().finishAffinity();
                }
                else {
                    Toast.makeText(requireContext(), "Something went wrong!!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return binding.getRoot();
    }
    //Format Of DataBase Keys: phone,user_email,user_img,user_name,user_bio,user_location,user_area,user_status.
    private boolean GetUserData()
    {
        account = GoogleSignIn.getLastSignedInAccount(requireContext());
        if(account != null)
        {
            SharedPreferences preferences = requireActivity().getSharedPreferences("UserDetails", Context.MODE_PRIVATE);

            UserPhone = preferences.getString("UserPhoneNumber", null);
            UserEmail = account.getEmail();
            UserImg = String.valueOf(account.getPhotoUrl());
            UserName = account.getDisplayName();
            UserBio = account.getGivenName();
            UserLocation = "";
            UserArea = "";
            UserStatus = 0;


            Log.d("myapp", UserPhone + " "+UserEmail + " "+UserImg + " "+UserName + " "+UserBio + " "+UserLocation + " "+UserArea + " "+UserStatus);

            spfLoginUserData = new SpfLoginUserData();
            spfLoginUserData.setSpf(requireContext(),UserPhone,UserEmail, UserImg, UserName, UserBio,UserLocation,UserArea,UserStatus);
        }
        else {
            Toast.makeText(requireContext(), "Something went wrong!!", Toast.LENGTH_SHORT).show();
        }

        return true;
    }


}