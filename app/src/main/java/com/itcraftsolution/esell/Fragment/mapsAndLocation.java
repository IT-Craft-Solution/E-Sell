package com.itcraftsolution.esell.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.itcraftsolution.esell.MainActivity;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentMapsAndLocationBinding;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class mapsAndLocation extends Fragment {


    public mapsAndLocation() {
        // Required empty public constructor
    }

    private FragmentMapsAndLocationBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        binding = FragmentMapsAndLocationBinding.inflate(getLayoutInflater());




        binding.tvLink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                requireActivity().finishAffinity();
            }
        });

        binding.btnLocationNavigation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
                requireActivity().finishAffinity();
            }
        });
        return binding.getRoot();
    }

}