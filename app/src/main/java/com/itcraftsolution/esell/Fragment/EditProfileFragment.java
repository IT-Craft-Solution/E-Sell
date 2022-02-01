package com.itcraftsolution.esell.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.Model.UserModel;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentEditProfileBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EditProfileFragment extends Fragment {

    public EditProfileFragment() {
        // Required empty public constructor
    }

     private SharedPreferences spf;
    private FragmentEditProfileBinding binding;
    private String Phone, Email;
    private int Status;
    private Uri PhotoUri;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEditProfileBinding.inflate(getLayoutInflater());


        LoadData();
        binding.igEditToAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(EditProfileFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer, new AccountFragment()).addToBackStack(null).commit();
            }
        });



       binding.btnEditImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                mGetContent.launch(intent);
            }
        });



        binding.txSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.edProfileName.getText().toString().length() < 4) {
                    Toast.makeText(getContext(), "Name must be Minimum 3 characters", Toast.LENGTH_SHORT).show();
                }
//                else if (!(binding.igProfileDp.getBackground().isVisible())){
//                    Toast.makeText(getContext(), "Please Set Your Profile Picture ", Toast.LENGTH_SHORT).show();
//                }
                else if (binding.edProfileAbout.getText().toString().length() < 10) {
                    Toast.makeText(getContext(), "About Us must be Minimum 10 characters", Toast.LENGTH_SHORT).show();
                }
//                else if (binding.edProfilePhoneNumber.getText().toString().length() < 10) {
//                    Toast.makeText(getContext(), "Please Verify Your Mobile Number ", Toast.LENGTH_SHORT).show();
//                }
                else if (binding.edProfileEmail.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please Enter Email In Valid Format ", Toast.LENGTH_SHORT).show();
                } else if (!(binding.edProfileEmail.getText().toString().contains("@"))) {
                    Toast.makeText(getContext(), "Please Enter Email In Valid Format ", Toast.LENGTH_SHORT).show();
                } else if (!(binding.edProfileEmail.getText().toString().endsWith(".com"))) {
                    Toast.makeText(getContext(), "Please Enter Email In Valid Format ", Toast.LENGTH_SHORT).show();
                } else {

                    binding.igVerify.setVisibility(View.VISIBLE);

                    Toast.makeText(getContext(), "Profile Saved...", Toast.LENGTH_SHORT).show();


//                    Name = binding.edProfileName.getText().toString();
//
//                    About = binding.edProfileAbout.getText().toString();
//
//                    MobileNumber = binding.edProfilePhoneNumber.getText().toString();
//
//                    Email = binding.edProfileEmail.getText().toString();


                }

//                Verify = binding.igVerify.getVisibility();
//                StoreUserProfile(Name ,About , MobileNumber, Email,Verify,PhotoUri);

            }
        });

        return binding.getRoot();
    }

    private void LoadData() {
        SpfUserData data = new SpfUserData();
        spf =  data.getSpf(requireContext());
        Phone = spf.getString("UserPhone", null);
        Email = spf.getString("UserEmail", null);
        Status = spf.getInt("UserStatus", 0);

        ApiUtilities.apiInterface().ReadUser(Phone,Email).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                UserModel model = response.body();
                if(model != null)
                {
                    if(model.getMessage() == null)
                    {
                        binding.edProfileName.setText(model.getUser_name());
                        binding.edProfileEmail.setText(model.getEmail());
                        binding.edProfileAbout.setText(model.getUser_bio());
                        binding.edProfilePhoneNumber.setText(model.getPhone());
                        Glide.with(requireContext()).load("http://192.168.0.102:80/all/user/images/"+model.getUser_img())
                                .into(binding.igProfileDp);
                        data.setSpf(requireContext(), model.getId(), model.getPhone(), model.getEmail(), model.getUser_img(),
                                model.getUser_name(), model.getUser_bio(), model.getLocation(), model.getCity_area(), model.getStatus());
                    }
                    else {
                        Toast.makeText(requireContext(), "Data Not Found", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(requireContext(), "Model empty!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(requireContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()== Activity.RESULT_OK)
                    {
                        List<Bitmap>  bitmaps = new ArrayList<>();
                        Intent Data = result.getData();
                        if (Data != null){
//                            binding.igProfileDp.setImageURI(Data.getData());
//                            PhotoUri = Data.getData();


                        }
                    }

                }
            });


}