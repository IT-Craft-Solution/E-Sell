package com.itcraftsolution.esell.Fragment;

import static android.content.Context.LOCATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.itcraftsolution.esell.Adapter.HomeCatRecyclerAdapter;
import com.itcraftsolution.esell.Adapter.HomeFreshItemRecyclerAdapter;
import com.itcraftsolution.esell.MainActivity;
import com.itcraftsolution.esell.Model.HomeCategory;
import com.itcraftsolution.esell.Model.HomeFreshItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentHomeBinding;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private SharedPreferences spf;
    private String Lastlocation,Presentlocation;
    private FragmentHomeBinding binding;
    private ArrayList<HomeCategory> homeCategories;
    private ArrayList<HomeFreshItem> homeFreshItems;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        spf = requireContext().getSharedPreferences("UserDetails",Context.MODE_PRIVATE);
        Lastlocation = spf.getString("UserLastLocation",null);
        Presentlocation = spf.getString("UserPresentLocation",null);
        if (Presentlocation.isEmpty()){
            binding.tvCityName.setText(Lastlocation);

        }else {
            binding.tvCityName.setText(Presentlocation);
        }



        homeCategories = new ArrayList<>();
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Auto Car"));
        homeCategories.add(new HomeCategory(R.drawable.properties , "Properties"));
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Auto Car"));
        homeCategories.add(new HomeCategory(R.drawable.properties , "Properties"));
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Auto Car"));
        homeCategories.add(new HomeCategory(R.drawable.properties , "Properties"));
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Auto Car"));
        homeCategories.add(new HomeCategory(R.drawable.properties , "Properties"));

        HomeCatRecyclerAdapter adapter = new HomeCatRecyclerAdapter(getContext() , homeCategories);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext() , RecyclerView.HORIZONTAL ,false);
        binding.rvHomeCategory.setLayoutManager(linearLayoutManager);
        binding.rvHomeCategory.setAdapter(adapter);

        homeFreshItems = new ArrayList<>();
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "I Phone 11 Pro navpo aayo ae ho" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));

        HomeFreshItemRecyclerAdapter homeFreshItemadapter = new HomeFreshItemRecyclerAdapter(getContext() , homeFreshItems);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 2);
        binding.rvHomeFreshItems.setLayoutManager(gridLayoutManager);
        binding.rvHomeFreshItems.setAdapter(homeFreshItemadapter);
        return binding.getRoot();
    }

}