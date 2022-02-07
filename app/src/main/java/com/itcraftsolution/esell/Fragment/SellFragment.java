package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.Adapter.SellCategoryRecyclerAdapter;
import com.itcraftsolution.esell.Model.SellCategory;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentSellBinding;

import java.util.ArrayList;


public class SellFragment extends Fragment {

    public SellFragment() {
        // Required empty public constructor
    }

    private FragmentSellBinding binding;
    private ArrayList<SellCategory> sellCategories;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSellBinding.inflate(getLayoutInflater());
        sellCategories = new ArrayList<>();

        sellCategories.add(new SellCategory(R.drawable.autocar , "Auto Car"));
        sellCategories.add(new SellCategory(R.drawable.properties , "Properties"));
        sellCategories.add(new SellCategory(R.drawable.autocar , "Mobiles"));
        sellCategories.add(new SellCategory(R.drawable.properties , "Bikes"));
        sellCategories.add(new SellCategory(R.drawable.autocar , "Electronics & Appliances"));
        sellCategories.add(new SellCategory(R.drawable.properties , "Furniture"));
        sellCategories.add(new SellCategory(R.drawable.autocar , "Fashion"));

        SellCategoryRecyclerAdapter adapter = new SellCategoryRecyclerAdapter(getContext() , sellCategories);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() ,1);
        binding.rvSellCategory.setLayoutManager(gridLayoutManager);
        binding.rvSellCategory.setAdapter(adapter);

        return binding.getRoot();
    }
}