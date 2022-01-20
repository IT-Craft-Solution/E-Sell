package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentItemDetailsBinding;
import com.itcraftsolution.esell.databinding.FragmentSellItemFormBinding;

import java.util.Objects;


public class SellItemFormFragment extends Fragment {


    public SellItemFormFragment() {
        // Required empty public constructor
    }

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
                fragmentTransaction.replace(R.id.frMainContainer , new SellFragment())
                        .addToBackStack(null).commit();
            }
        });

        binding.llSellItemFormCheckAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frMainContainer , new EditProfileFragment())
                        .addToBackStack(null).commit();
            }
        });

        binding.txFormLocationTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //get User Current Location & Print it.
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
                else {
                Toast.makeText(getContext(), "All done !!!", Toast.LENGTH_SHORT).show();
                }


            }
        });
        return binding.getRoot();
    }
}