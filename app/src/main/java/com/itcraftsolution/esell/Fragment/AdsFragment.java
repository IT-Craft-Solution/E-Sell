package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.Adapter.MyAdsItemAdapter;
import com.itcraftsolution.esell.Model.MyAdsItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentAdsBinding;

import java.util.ArrayList;

public class AdsFragment extends Fragment {




    public AdsFragment() {
        // Required empty public constructor
    }

    private FragmentAdsBinding binding;
    private ArrayList<MyAdsItem> myAdsItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdsBinding.inflate(getLayoutInflater());

        myAdsItems = new ArrayList<>();
        myAdsItems.add(new MyAdsItem(R.drawable.testing,"Iphone 12","RP.10000","25 Jan 2022","Rajkot","25","10"));
        myAdsItems.add(new MyAdsItem(R.drawable.testing,"Iphone 12","RP.10000","25 Jan 2022","Rajkot","25","10"));
        myAdsItems.add(new MyAdsItem(R.drawable.testing,"Iphone 12","RP.10000","25 Jan 2022","Rajkot","25","10"));
        myAdsItems.add(new MyAdsItem(R.drawable.testing,"Iphone 12","RP.10000","25 Jan 2022","Rajkot","25","10"));
        myAdsItems.add(new MyAdsItem(R.drawable.testing,"Iphone 12","RP.10000","25 Jan 2022","Rajkot","25","10"));
        myAdsItems.add(new MyAdsItem(R.drawable.testing,"Iphone 12","RP.10000","25 Jan 2022","Rajkot","25","10"));
        myAdsItems.add(new MyAdsItem(R.drawable.testing,"Iphone 12","RP.10000","25 Jan 2022","Rajkot","25","10"));



        MyAdsItemAdapter myAdsItemAdapter = new MyAdsItemAdapter(getContext(),myAdsItems);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 1);
        binding.rvMyAdsItem.setLayoutManager(gridLayoutManager);
        binding.rvMyAdsItem.setAdapter(myAdsItemAdapter);

        return binding.getRoot();
    }
}