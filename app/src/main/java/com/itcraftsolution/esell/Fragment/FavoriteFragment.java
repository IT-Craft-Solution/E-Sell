package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.Adapter.HomeCatShowAdapter;
import com.itcraftsolution.esell.Model.HomeCatShow;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentFavoriteBinding;

import java.util.ArrayList;


public class FavoriteFragment extends Fragment {



    public FavoriteFragment() {
        // Required empty public constructor
    }

    private FragmentFavoriteBinding binding;
    private ArrayList<HomeCatShow> homeCatShows;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding = FragmentFavoriteBinding.inflate(getLayoutInflater());


        homeCatShows = new ArrayList<>();
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro  " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro  " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro  " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro  " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro  " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro  " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro  " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro  " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro  " , "Rp. 11.00.000" , "Limbdi"));


        HomeCatShowAdapter catShowAdapter = new HomeCatShowAdapter(getContext(),homeCatShows);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 1);
        binding.rvFavoriteItem.setLayoutManager(gridLayoutManager);
        binding.rvFavoriteItem.setAdapter(catShowAdapter);


       return binding.getRoot();
    }
}