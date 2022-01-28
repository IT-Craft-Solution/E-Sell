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
import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.itcraftsolution.esell.Adapter.HomeCatRecyclerAdapter;
import com.itcraftsolution.esell.Adapter.HomeFreshItemRecyclerAdapter;
import com.itcraftsolution.esell.Model.HomeCategory;
import com.itcraftsolution.esell.Model.HomeFreshItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentHomeBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    private String Sublocality,Locality,City;
    private FragmentHomeBinding binding;
    private ArrayList<HomeCategory> homeCategories;
    private ArrayList<HomeFreshItem> homeFreshItems;
    FusedLocationProviderClient mFusedLocationClient;
    int PERMISSION_ID = 44;
    private SharedPreferences spf;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());



        binding.tvCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to get location
                mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity());
                getLastLocation();

            }
        });

        //get User Current Location & Print it.
        spf = requireContext().getSharedPreferences("UserLocation" , Context.MODE_PRIVATE);
        binding.tvCityName.setText(spf.getString("UserLocation" , null));

        homeCategories = new ArrayList<>();
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Auto Car"));
        homeCategories.add(new HomeCategory(R.drawable.properties , "Properties"));
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Mobiles"));
        homeCategories.add(new HomeCategory(R.drawable.properties , "Bikes"));
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Electronics & Appliances"));
        homeCategories.add(new HomeCategory(R.drawable.properties , "Furniture"));
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Fashion"));


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

        binding.edHomeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), ""+binding.edHomeSearch.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
        binding.igHomeCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(HomeFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new SellFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


        return binding.getRoot();
    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        // check if permissions are given
        if (checkPermissions()) {
            // check if location is enabled
            if (isLocationEnabled()) {

                // getting last
                // location from
                // FusedLocationClient
                // object
                mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();
                        } else {

                            try {
                                Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
                                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                                  // binding.tvCityName.setText(String.valueOf(addresses.get(0).getSubLocality()));

                                   Locality = addresses.get(0).getLocality();
                                   Sublocality = addresses.get(0).getSubLocality();
                                   City = Sublocality +", "+Locality;
                                   binding.tvCityName.setText(City);
                                   StoreUserLocation(City);



                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                        }
                    }
                });
            } else {
                Toast.makeText(getActivity(), "Please turn on" + " your location...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            // if permissions aren't available,
            // request for permissions
            requestPermissions();
        }
    }

    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        // Initializing LocationRequest
        // object with appropriate methods
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        // setting LocationRequest
        // on FusedLocationClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity());
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
    }

    private LocationCallback mLocationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();

            try {
                Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
                List<Address> addresses = geocoder.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);


                Locality = addresses.get(0).getLocality();
                Sublocality = addresses.get(0).getSubLocality();
                City = Sublocality +","+Locality;
                binding.tvCityName.setText(City);


            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    };

    // method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        // If we want background location
        // on Android 10.0 and higher,
        // use:
        // ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    // method to request for permissions
    private void requestPermissions() {
        ActivityCompat.requestPermissions(requireActivity(), new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    // method to check
    // if location is enabled
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) requireActivity().getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }


    // If everything is alright then
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);

        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        if (checkPermissions()) {
//            getLastLocation();
//        }
//    }

    private void StoreUserLocation(String UserLocation)
    {
        SharedPreferences spf = requireContext().getSharedPreferences("UserLocation" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putString("UserLocation" , UserLocation);
        editor.apply();
    }
}