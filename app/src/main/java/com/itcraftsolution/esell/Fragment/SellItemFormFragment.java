package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

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

        binding.btnSellItemFormNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.edSellItemFormTitle.getText().toString().isEmpty() && binding.edSellItemFormTitle.getText().length() < 7)
                {
                    binding.edSellItemFormTitle.setError("Title Minimum length of 7 Character");
                    binding.edSellItemFormTitle.requestFocus();
                }
                else {
                    Toast.makeText(getContext(), "All Done !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return binding.getRoot();
    }
}