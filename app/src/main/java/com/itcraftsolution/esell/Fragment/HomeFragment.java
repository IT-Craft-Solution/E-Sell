package com.itcraftsolution.esell.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itcraftsolution.esell.Adapter.HomeCatRecyclerAdapter;
import com.itcraftsolution.esell.Adapter.HomeFreshItemRecyclerAdapter;
import com.itcraftsolution.esell.Model.HomeCategory;
import com.itcraftsolution.esell.Model.HomeFreshItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private FragmentHomeBinding binding;
    private ArrayList<HomeCategory> homeCategories;
    private ArrayList<HomeFreshItem> homeFreshItems;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        homeCategories = new ArrayList<>();
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Auto Car"));
        homeCategories.add(new HomeCategory(R.drawable.properties , "Properties"));
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Auto Car"));
        homeCategories.add(new HomeCategory(R.drawable.properties , "Properties"));
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Auto Car"));
        homeCategories.add(new HomeCategory(R.drawable.properties , "Properties"));
        homeCategories.add(new HomeCategory(R.drawable.autocar , "Auto Car"));
        homeCategories.add(new HomeCategory(R.drawable.properties , "Properties"));

        HomeCatRecyclerAdapter adapter = new HomeCatRecyclerAdapter(getContext() , homeCategories);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext() , RecyclerView.HORIZONTAL ,false);
        binding.rvHomeCategory.setLayoutManager(linearLayoutManager);
        binding.rvHomeCategory.setAdapter(adapter);

        homeFreshItems = new ArrayList<>();
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "I Phone 11 Pro navpo aayo ae ho" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeFreshItems.add(new HomeFreshItem(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));

        HomeFreshItemRecyclerAdapter homeFreshItemadapter = new HomeFreshItemRecyclerAdapter(getContext() , homeFreshItems);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 2);
        binding.rvHomeFreshItems.setLayoutManager(gridLayoutManager);
        binding.rvHomeFreshItems.setAdapter(homeFreshItemadapter);
        return binding.getRoot();
    }

}