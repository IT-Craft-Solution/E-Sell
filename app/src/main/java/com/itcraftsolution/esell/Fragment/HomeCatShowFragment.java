package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import com.itcraftsolution.esell.Adapter.HomeCatShowAdapter;
import com.itcraftsolution.esell.Model.HomeCatShow;
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
        binding.rvHomeCatShow.setLayoutManager(gridLayoutManager);
        binding.rvHomeCatShow.setAdapter(catShowAdapter);

        binding.igHomeCatShowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(HomeCatShowFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new HomeFragment());
                fragmentTransaction.commit();
            }
        });


        return binding.getRoot();
    }
}