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
import com.itcraftsolution.esell.databinding.FragmentActiveOrdersBinding;

import java.util.ArrayList;


public class ActiveOrdersFragment extends Fragment {


    public ActiveOrdersFragment() {
        // Required empty public constructor
    }

    private FragmentActiveOrdersBinding binding;
    private ArrayList<HomeCatShow> homeCatShows;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentActiveOrdersBinding.inflate(getLayoutInflater());

        homeCatShows = new ArrayList<>();
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro ka bhai navo lidho ae ho " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro ka bhai navo lidho ae ho " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro ka bhai navo lidho ae ho " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro ka bhai navo lidho ae ho " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro ka bhai navo lidho ae ho " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro ka bhai navo lidho ae ho " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro ka bhai navo lidho ae ho " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro ka bhai navo lidho ae ho " , "Rp. 11.00.000" , "Limbdi"));
        homeCatShows.add(new HomeCatShow(R.drawable.testing , "Iphone 11 Pro ka bhai navo lidho ae ho " , "Rp. 11.00.000" , "Limbdi"));


        HomeCatShowAdapter catShowAdapter = new HomeCatShowAdapter(getContext(),homeCatShows);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 1);
        binding.rvActiveOrdersItem.setLayoutManager(gridLayoutManager);
        binding.rvActiveOrdersItem.setAdapter(catShowAdapter);


        return binding.getRoot();
    }
}