package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentSellinEsellBinding;

//SellinEsell Fragment Class
public class SellinEsellFragment extends Fragment {


    public SellinEsellFragment() {
        // Required empty public constructor
    }
    private FragmentSellinEsellBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSellinEsellBinding.inflate(getLayoutInflater());

        //Open Policy PDF
        binding.pdfEsellservicepolicy.fromAsset("Sellingpolicy.pdf").load();
        return binding.getRoot();
    }
}