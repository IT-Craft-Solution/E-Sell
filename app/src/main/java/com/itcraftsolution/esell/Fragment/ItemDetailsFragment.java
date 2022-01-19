package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.itcraftsolution.esell.databinding.FragmentItemDetailsBinding;

public class ItemDetailsFragment extends Fragment {



    public ItemDetailsFragment() {
        // Required empty public constructor
    }

   private  FragmentItemDetailsBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentItemDetailsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}