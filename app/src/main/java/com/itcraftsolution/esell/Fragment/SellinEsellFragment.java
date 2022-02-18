package com.itcraftsolution.esell.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentSellinEsellBinding;

import es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;


public class SellinEsellFragment extends Fragment {


    public SellinEsellFragment() {
        // Required empty public constructor
    }
    private FragmentSellinEsellBinding binding;
    private BasePDFPagerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSellinEsellBinding.inflate(getLayoutInflater());

        adapter = new PDFPagerAdapter(requireContext(), "selling_on_esell.pdf");
        binding.pdfViewPager.setAdapter(adapter);
        return binding.getRoot();
    }

}