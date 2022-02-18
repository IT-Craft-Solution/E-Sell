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
import com.itcraftsolution.esell.databinding.FragmentEsellPolicyBinding;

import dalvik.system.BaseDexClassLoader;
import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;


public class EsellPolicyFragment extends Fragment {


    public EsellPolicyFragment() {
        // Required empty public constructor
    }

    private BasePDFPagerAdapter adapter;

    private FragmentEsellPolicyBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEsellPolicyBinding.inflate(getLayoutInflater());

        adapter = new PDFPagerAdapter(requireContext(), "esell_Services.pdf");
        binding.pdfViewPager.setAdapter(adapter);
        return binding.getRoot();
    }
}
