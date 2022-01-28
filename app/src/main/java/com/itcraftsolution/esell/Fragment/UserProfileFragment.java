package com.itcraftsolution.esell.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.itcraftsolution.esell.Api.ApiPostData;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentUserProfileBinding;
import com.itcraftsolution.esell.spf.SpfLoginUserData;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserProfileFragment extends Fragment {

    public UserProfileFragment() {
        // Required empty public constructor
    }

    private FragmentUserProfileBinding binding;
    private String Sublocality,Locality,City, Name, Email, Phone, About, Location, ImagePath;
    FusedLocationProviderClient mFusedLocationClient;
    private static final int PERMISSION_ID = 44;
    private Bitmap bitmap;
    Uri uri;
    boolean CheckImage = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserProfileBinding.inflate(getLayoutInflater());

        LoadData();
        binding.igProfileDp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(checkStoragePermission())
            {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                SendActivityintent.launch(intent);

            }else {
                requestStoragePermission();
            }


            }
        });

        binding.btnNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Objects.requireNonNull(binding.edUserName.getText()).toString().length() < 4) {
                    binding.txProfileNameError.setText("Name must be Minimum 4 characters");
                    binding.txProfileNameError.setTextColor(getResources().getColor(R.color.red));
                    binding.edUserName.requestFocus();
                }
                else if (!CheckImage){
                    Toast.makeText(getContext(), "Please Set Your Profile Picture ", Toast.LENGTH_SHORT).show();
                }
                else if (Objects.requireNonNull(binding.edUserAboutUs.getText()).toString().length() < 8) {
                    binding.txProfileAboutError.setText("About Us must be Minimum 8 characters");
                    binding.txProfileAboutError.setTextColor(getResources().getColor(R.color.red));
                    binding.edUserAboutUs.requestFocus();
                }
                else if (Objects.requireNonNull(binding.edUserPhoneNumber.getText()).toString().length() != 10) {
                    binding.txProfilePhoneError.setText("PhoneNumber must be Minimum 10 Digits");
                    binding.txProfilePhoneError.setTextColor(getResources().getColor(R.color.red));
                    binding.edUserPhoneNumber.requestFocus();
                }
                else if (!ValidEmail(Objects.requireNonNull(binding.edUserEmail.getText()).toString())) {
                    binding.txProfileEmailError.setText("Please Enter Email In Valid Format");
                    binding.txProfileNameError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txProfileAboutError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txProfilePhoneError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txProfileEmailError.setTextColor(getResources().getColor(R.color.red));
                    binding.edUserEmail.requestFocus();

                }
                else if(binding.txLocationn.getText().toString().equals("CityName"))
                {
                    binding.txProfileLocationError.setText("Please Confirm Your Location");
                    binding.txProfileEmailError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txProfileNameError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txProfileAboutError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txProfilePhoneError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txProfileLocationError.setTextColor(getResources().getColor(R.color.red));
                    binding.txUserLocation.requestFocus();
                }
                else
                {
                    binding.txProfileNameError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txProfileAboutError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txProfilePhoneError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txProfileEmailError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txProfileLocationError.setTextColor(getResources().getColor(R.color.blue_grey));

                    binding.igVerify.setVisibility(View.VISIBLE);

                    Toast.makeText(getContext(), "Profile Saved...", Toast.LENGTH_SHORT).show();

                    Name = binding.edUserName.getText().toString();

                    About = binding.edUserAboutUs.getText().toString();

                    Phone = "+91"+binding.edUserPhoneNumber.getText().toString();

                    Email = binding.edUserEmail.getText().toString();
                    Location = binding.txLocationn.getText().toString();
                    SpfLoginUserData spfLoginUserData = new SpfLoginUserData();
                    spfLoginUserData.setSpf(requireContext(), Phone, Email, ImagePath, Name,About, Locality, Sublocality, 1);
                    binding.textView11.setText("Name: "+Name+"About: "+About+"img: "+ImagePath+"Phone: "+Phone+"Email: "+Email+"Location: "+Location);
                    ApiPostData apiPostData = new ApiPostData();
                    apiPostData.insertUser(requireContext(),Phone, Email, ImagePath, Name,About, Locality, Sublocality, 1);
                    Log.d("navuapp", "Name: "+Name+"About: "+About+"Phone: "+Phone+"Email: "+Email+"Location: "+Location);

                }

//                Intent intent = new Intent(getContext(), MainActivity.class);
//                startActivity(intent);
//                requireActivity().finishAffinity();
            }
        });


        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity());
        binding.txUserLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to get location
                getLastLocation();
            }
        });

        return binding.getRoot();
    }

    private boolean ValidEmail(String email)
    {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    private void requestStoragePermission() {

        ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_ID);
        }

        private boolean checkStoragePermission()
        {
            return ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        }
    private void LoadData()
    {
        SpfLoginUserData spfLoginUserData = new SpfLoginUserData();
        if(spfLoginUserData.getSpf(requireContext()).getInt("UserStatus", 0) == 0)
        {
            Toast.makeText(requireContext(), "is not login", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(requireContext(), "user login previous", Toast.LENGTH_SHORT).show();
            binding.igProfileDp.setImageBitmap(BitmapFactory.decodeFile(spfLoginUserData.getSpf(requireContext()).getString("UserImage", null)));
            binding.edUserName.setText(spfLoginUserData.getSpf(requireContext()).getString("UserName", null));
            binding.edUserAboutUs.setText(spfLoginUserData.getSpf(requireContext()).getString("UserBio", null));
            binding.edUserPhoneNumber.setText(spfLoginUserData.getSpf(requireContext()).getString("UserPhone", null));
            binding.edUserEmail.setText(spfLoginUserData.getSpf(requireContext()).getString("UserEmail", null));
            binding.txLocationn.setText(spfLoginUserData.getSpf(requireContext()).getString("UserCity", null));
        }
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
                                binding.txLocationn.setVisibility(View.VISIBLE);
                                binding.txUserLocation.setVisibility(View.INVISIBLE);
                                binding.txLocationn.setText(City);

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
                binding.txLocationn.setText(City);


            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    };

    // method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        // If we want background location
        // on Android 10.0 and higher,
        // use:
//         ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
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
                Toast.makeText(requireContext(), "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            }
             else {
                Toast.makeText(requireContext(), "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }





    }

    ActivityResultLauncher<Intent> SendActivityintent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK)
                    {
                        if(result.getData() != null)
                        {
                            uri = result.getData().getData();
                          ImagePath = getPath(uri);
                                try {
                                    bitmap = MediaStore.Images.Media.getBitmap(requireContext().getContentResolver(),uri);
                                    binding.igProfileDp.setImageBitmap(bitmap);
                                    CheckImage = true;
                                }catch (Exception e)
                                {
                                    Toast.makeText(requireContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                                }

                            Toast.makeText(requireContext(), ""+bitmap, Toast.LENGTH_SHORT).show();


                        }
                    }

                }
            });

    private String getPath(Uri uri) {

        Cursor cursor = requireContext().getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor = requireContext().getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, MediaStore.Images.Media._ID + "=?", new String[]{document_id}, null
        );
        cursor.moveToFirst();
            String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
        cursor.close();
        return path;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }
    }
}