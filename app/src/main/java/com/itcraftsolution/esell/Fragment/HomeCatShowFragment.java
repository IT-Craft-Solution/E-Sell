package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.Adapter.HomeCatRecyclerAdapter;
import com.itcraftsolution.esell.Adapter.HomeCatShowAdapter;
import com.itcraftsolution.esell.Adapter.HomeFreshItemRecyclerAdapter;
import com.itcraftsolution.esell.Model.HomeCatShow;
import com.itcraftsolution.esell.Model.HomeCategory;
import com.itcraftsolution.esell.Model.HomeFreshItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentHomeCatShowBinding;

import java.util.ArrayList;


public class HomeCatShowFragment extends Fragment {


    public HomeCatShowFragment() {
        // Required empty public constructor
    }

    private ArrayList<HomeCatShow> homeCatShows;
    private FragmentHomeCatShowBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeCatShowBinding.inflate(getLayoutInflater());


        homeCatShows = new ArrayList<>();
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro" , "11.00.000" , "Limbdi"));

        HomeCatShowAdapter catShowAdapter = new HomeCatShowAdapter(getContext(),homeCatShows);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 1);
        binding.rvHomeCatShow.setLayoutManager(gridLayoutManager);
        binding.rvHomeCatShow.setAdapter(catShowAdapter);



        return binding.getRoot();
    }
}