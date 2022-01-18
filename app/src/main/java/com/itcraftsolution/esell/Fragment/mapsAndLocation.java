package com.itcraftsolution.esell.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.itcraftsolution.esell.MainActivity;
import com.itcraftsolution.esell.databinding.FragmentMapsAndLocationBinding;


public class mapsAndLocation extends Fragment {


    public mapsAndLocation() {
        // Required empty public constructor
    }

    private FragmentMapsAndLocationBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        binding = FragmentMapsAndLocationBinding.inflate(getLayoutInflater());


        binding.tvLink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                requireActivity().finishAffinity();
            }
        });

        binding.btnLocationNavigation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            }
        });
        return binding.getRoot();
    }



}