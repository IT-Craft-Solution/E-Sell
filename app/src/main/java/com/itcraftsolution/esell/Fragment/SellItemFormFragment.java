package com.itcraftsolution.esell.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Looper;
import android.provider.Settings;
import android.util.Base64;
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
import com.itcraftsolution.esell.Api.ApiPostData;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentSellItemFormBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


public class SellItemFormFragment extends Fragment {


    public SellItemFormFragment() {
        // Required empty public constructor
    }

    private FragmentSellItemFormBinding binding;
    private  String Title, Desc,Price,Sublocality,Locality,City, Category,encodeImageString;
    FusedLocationProviderClient mFusedLocationClient;
    private ArrayList<Uri> ImageUris;
    private Bitmap bitmap;
    private boolean CheckImage = false;
    int PERMISSION_ID = 44;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSellItemFormBinding.inflate(getLayoutInflater());

        ImageUris = new ArrayList<>();


        binding.igSellItemBackCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new SellFragment())
                        .addToBackStack(null).commit();
            }
        });



        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to get location
                mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity());
                getLastLocation();
            }
        });

        binding.btnSelectImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mGetContent.launch("image/*");

                Intent intent = new Intent();
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                mGetContent.launch(Intent.createChooser(intent,"Select Image(s)"));

            }
        });



        binding.btnSellItemFormNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Objects.requireNonNull(binding.edSellItemFormTitle.getText()).toString().length() <= 4)
                {
                    binding.txFormTitleError.setText("* Title must be Minimum 5 characters");
                    binding.txFormTitleError.setTextColor(getResources().getColor(R.color.red));
                    binding.edSellItemFormTitle.requestFocus();
                }
                else if(Objects.requireNonNull(binding.edSellItemFormDesc.getText()).toString().length() <= 7)
                {
                    binding.txFormDescError.setText("* Description must be Minimum 8 characters");
                    binding.txFormDescError.setTextColor(getResources().getColor(R.color.red));
                    binding.txFormLocationError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormPriceError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormTitleError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.edSellItemFormDesc.requestFocus();

                }
                else if(Objects.requireNonNull(binding.edSellItemFormPrice.getText()).toString().isEmpty())
                {
                    binding.txFormPriceError.setText("* Price Must be in Indian Currency");
                    binding.txFormPriceError.setTextColor(getResources().getColor(R.color.red));
                    binding.txFormTitleError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormDescError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormLocationError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.edSellItemFormPrice.requestFocus();
                }
                else if(Integer.parseInt(binding.edSellItemFormPrice.getText().toString()) <= 150)
                {
                    binding.txFormPriceError.setText("* Price must be Minimum 150 Rupees");
                    binding.txFormPriceError.setTextColor(getResources().getColor(R.color.red));
                    binding.txFormTitleError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormDescError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormLocationError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.edSellItemFormPrice.requestFocus();
                }
                else if(binding.txLocation.getText().toString().equals("CityName")){
                    binding.txFormLocationError.setText("Please Confirm Your Location");
                    binding.txFormLocationError.setTextColor(getResources().getColor(R.color.red));
                    binding.txFormPriceError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormTitleError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormDescError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormLocation.requestFocus();
                }
                else if (!CheckImage){
                    binding.txSelectImagesError.setText("Please Select Item Images");
                    binding.txSelectImagesError.setTextColor(getResources().getColor(R.color.red));
                    binding.txFormPriceError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormTitleError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormDescError.setTextColor(getResources().getColor(R.color.blue_grey));
                    binding.txFormLocationError.setTextColor(getResources().getColor(R.color.blue_grey));
                }
                else {
                    //cat_name,title,description,price,location,city_area,item_img,status
                    SpfUserData spfUserData = new SpfUserData();
                    Category = spfUserData.getSpfHome(requireContext()).getString("Category", null);
                    Title = binding.edSellItemFormTitle.getText().toString();
                    Desc = binding.edSellItemFormDesc.getText().toString();
                    Price = binding.edSellItemFormPrice.getText().toString();

                    ApiPostData apiPostData = new ApiPostData();
                    apiPostData.SellItem(requireContext(), Category, Title, Desc,Integer.parseInt(Price),Locality, Sublocality,encodeImageString,1);
//                    binding.textView6.setText();
//                    Log.d("checkappnow", "Name = "+Name + " AboutUs = "+AboutUs+" Price = "+Price+" Location = "+Location+" images "+ImageUris.toString());
//                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//                    fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
//                    fragmentTransaction.replace(R.id.frMainContainer , new CongressScreenFragment())
//                            .addToBackStack(null).commit();

                }


            }
        });
        return binding.getRoot();
    }

    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()== Activity.RESULT_OK)
                    {
                        Intent data = result.getData();

                        if(data != null){

                            if (data.getClipData() !=null) {

                                int Count = data.getClipData().getItemCount();
                                for (int i = 0; i < Count; i++) {

                                    Uri imageUri = data.getClipData().getItemAt(i).getUri();
                                    ImageUris.add(imageUri);

                                }

                                binding.imageView9.setImageURI(ImageUris.get(0));
                                binding.imageView11.setImageURI(ImageUris.get(1));

                            } else {
                                Uri imageUri = data.getData();
//                                ImageUris.add(imageUri);

//                                binding.imageView9.setImageURI(ImageUris.get(0));

                                try {
                                    InputStream inputStream = requireContext().getContentResolver().openInputStream(imageUri);
                                    bitmap = BitmapFactory.decodeStream(inputStream);
                                    encodeBitmapImage(bitmap);
                                    CheckImage = true;
                                }catch (Exception e)
                                {
                                    Toast.makeText(requireContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }


                        }

                    }

                }
            });


    private void encodeBitmapImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,70, byteArrayOutputStream);
        binding.imageView9.setImageBitmap(bitmap);
        byte[] bytesofimage = byteArrayOutputStream.toByteArray();
        encodeImageString = android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
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
                mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<android.location.Location>() {
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
                                binding.txLocation.setVisibility(View.VISIBLE);
                                binding.btnVerify.setVisibility(View.INVISIBLE);
                                binding.txLocation.setText(City);


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
                binding.txLocation.setText(City);


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



//    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
//            new ActivityResultCallback<Uri>() {
//                @Override
//                public void onActivityResult(Uri uri) {
//                    // Handle the returned Uri
//
//
//                }
//            });
}