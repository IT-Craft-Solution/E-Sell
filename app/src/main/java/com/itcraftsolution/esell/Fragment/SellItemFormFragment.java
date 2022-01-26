package com.itcraftsolution.esell.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentItemDetailsBinding;
import com.itcraftsolution.esell.databinding.FragmentSellItemFormBinding;

import java.util.Objects;


public class SellItemFormFragment extends Fragment {


    public SellItemFormFragment() {
        // Required empty public constructor
    }

    private SharedPreferences spf;
    private FragmentSellItemFormBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentSellItemFormBinding.inflate(getLayoutInflater());


        binding.igSellItemBackCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(SellItemFormFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new SellFragment())
                        .addToBackStack(null).commit();
            }
        });

        binding.llSellItemFormCheckAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spf = requireContext().getSharedPreferences("UserProfile" , Context.MODE_PRIVATE);
                binding.igVerify.setVisibility(spf.getInt("UserVerify",0));


                if(binding.igVerify.isShown()){
                    Toast.makeText(getContext(), "Your Account Is Verified", Toast.LENGTH_SHORT).show();
                }
                else {
                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.remove(SellItemFormFragment.this);
                    fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                    fragmentTransaction.replace(R.id.frMainContainer , new EditProfileFragment())
                            .addToBackStack(null).commit();
                }

            }
        });

        binding.txFormLocationTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //get User Current Location & Print it.
                spf = requireContext().getSharedPreferences("UserLocation" , Context.MODE_PRIVATE);
                 binding.txSellItemFormLocation.setText(spf.getString("UserLocation" , null));
            }
        });

        binding.txSelectImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        });

        binding.btnSellItemFormNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Objects.requireNonNull(binding.edSellItemFormTitle.getText()).toString().length() <= 7)
                {
                    binding.txFormTitleError.setText("* Title must be Minimum 7 characters");
                    binding.txFormTitleError.setTextColor(getResources().getColor(R.color.red));
                    binding.edSellItemFormTitle.requestFocus();
                }
                else if(Objects.requireNonNull(binding.edSellItemFormDesc.getText()).toString().length() <= 9)
                {
                    binding.txFormDescError.setText("* Description must be Minimum 10 characters");
                    binding.txFormDescError.setTextColor(getResources().getColor(R.color.red));
                    binding.edSellItemFormDesc.requestFocus();

                }
                else if(Objects.requireNonNull(binding.edSellItemFormPrice.getText()).toString().isEmpty())
                {
                        binding.txFormPriceError.setText("* Price Must be in Indian Currency");
                        binding.txFormPriceError.setTextColor(getResources().getColor(R.color.red));
                    binding.edSellItemFormPrice.requestFocus();
                }
                else if(Integer.parseInt(binding.edSellItemFormPrice.getText().toString()) <= 150)
                {
                    binding.txFormPriceError.setText("* Price must be Minimum 150 Rupees");
                    binding.txFormPriceError.setTextColor(getResources().getColor(R.color.red));
                    binding.edSellItemFormPrice.requestFocus();
                }
                else if (!(binding.igVerify.isShown())){
                    Toast.makeText(getContext(), "Please Verify Your Account ", Toast.LENGTH_SHORT).show();
                }
                else if (Objects.requireNonNull(binding.txSellItemFormLocation.getText()).toString().matches("City Name")){

                    Toast.makeText(getContext(), "Please Get Your Current Location", Toast.LENGTH_SHORT).show();
                }
                else {
                Toast.makeText(getContext(), "All done !!!", Toast.LENGTH_SHORT).show();

                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.remove(SellItemFormFragment.this);
                    fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                    fragmentTransaction.replace(R.id.frMainContainer , new CongressScreenFragment())
                            .addToBackStack(null).commit();

                }


            }
        });
        return binding.getRoot();
    }

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    // Handle the returned Uri


                }
            });
}