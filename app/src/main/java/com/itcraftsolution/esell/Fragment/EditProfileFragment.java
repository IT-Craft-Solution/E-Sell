package com.itcraftsolution.esell.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentEditProfileBinding;



public class EditProfileFragment extends Fragment {

    public EditProfileFragment() {
        // Required empty public constructor
    }

     private SharedPreferences spf;
    private FragmentEditProfileBinding binding;
    private String Name, About, MobileNumber, Email,Profile;
    private int Verify;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEditProfileBinding.inflate(getLayoutInflater());

        spf = requireContext().getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        binding.edProfilePhoneNumber.setText(spf.getString("PhoneNumber", null));
        binding.edCountryCode.setText(spf.getString("CountryCode",null));

        binding.igEditToAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frMainContainer, new AccountFragment()).addToBackStack(null).commit();
            }
        });

        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frMainContainer, new phoneLogin()).addToBackStack(null).commit();

            }
        });

       binding.btnEditImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mGetContent.launch("image/*");
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


                    Verify = binding.igVerify.getVisibility();

                    Name = binding.edProfileName.getText().toString();

                    About = binding.edProfileAbout.getText().toString();

                    MobileNumber = binding.edProfilePhoneNumber.getText().toString();

                    Email = binding.edProfileEmail.getText().toString();



                    StoreUserProfile(Name, About, MobileNumber, Email,Verify,Profile);


                }
            }
        });

        LoadData();
        return binding.getRoot();
    }

    private void StoreUserProfile(String UserName, String UserAboutUs, String UserMobileNumber, String UserEmail,Integer UserVerify,String UserProfileImage) {
        SharedPreferences spf = requireContext().getSharedPreferences("UserProfile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putString("UserName", UserName);
        editor.putString("UserAboutUs", UserAboutUs);
        editor.putString("UserMobileNumber", UserMobileNumber);
        editor.putString("UserEmail", UserEmail);
        editor.putInt("UserVerify",UserVerify);
        editor.putString("UserProfileImage",UserProfileImage);
        editor.apply();
    }

    private void LoadData() {
        String Name, About, MobileNumber, Email,ProfileImage;
        int Verify;
        Uri uri1;

        SharedPreferences spf = requireContext().getSharedPreferences("UserProfile", Context.MODE_PRIVATE);
        Name = spf.getString("UserName", null);
        About = spf.getString("UserAboutUs", null);
        Email = spf.getString("UserEmail", null);
        MobileNumber = spf.getString("UserMobileNumber", null);
        Verify = spf.getInt("UserVerify",0);
        ProfileImage = spf.getString("UserProfileImage",null);



        binding.edProfileName.setText(Name);
        binding.edProfileAbout.setText(About);
        binding.edProfilePhoneNumber.setText(MobileNumber);
        binding.edProfileEmail.setText(Email);
        binding.igVerify.setVisibility(Verify);
        binding.igProfileDp.setImageResource(Integer.parseInt(Profile));
//        uri1 = Uri.parse(ProfileImage);
//        binding.igProfileDp.setImageURI(uri1);




    }

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    // Handle the returned Uri
                     binding.igProfileDp.setImageURI(uri);



                     Profile =uri.toString();
                    binding.igProfileDp.setImageURI(Uri.parse(Profile));
                    Toast.makeText(getContext(), ""+Profile, Toast.LENGTH_LONG).show();

                }
            });

}