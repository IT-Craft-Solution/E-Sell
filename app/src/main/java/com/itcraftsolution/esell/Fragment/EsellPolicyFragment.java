package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentEsellPolicyBinding;


public class EsellPolicyFragment extends Fragment {


    public EsellPolicyFragment() {
        // Required empty public constructor
    }
    private FragmentEsellPolicyBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEsellPolicyBinding.inflate(getLayoutInflater());

//        binding.pdfEsellPolicy.fromAsset("service_Content_Policy.pdf").load();
        return binding.getRoot();
    }
}