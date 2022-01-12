package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.Adapter.ChatHomeViewPagerAdapter;
import com.itcraftsolution.esell.Adapter.MyAddViewPagerAdapter;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentAdsBinding;
import com.itcraftsolution.esell.databinding.FragmentMyAddBinding;

import java.util.ArrayList;


public class MyAddFragment extends Fragment {


    public MyAddFragment() {
        // Required empty public constructor
    }

    private FragmentMyAddBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMyAddBinding.inflate(getLayoutInflater());
        binding.vpMyAdd.setAdapter(new MyAddViewPagerAdapter(getParentFragmentManager()));
        binding.tbMyAdd.setupWithViewPager(binding.vpMyAdd);

        return binding.getRoot();
    }
}