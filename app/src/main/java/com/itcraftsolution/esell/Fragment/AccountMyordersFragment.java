package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayoutMediator;
import com.itcraftsolution.esell.Adapter.AccMyorderViewPagerAdapter;

import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentAccountMyordersBinding;


public class AccountMyordersFragment extends Fragment {


    public AccountMyordersFragment() {
        // Required empty public constructor
    }

    private FragmentAccountMyordersBinding binding;
    AccMyorderViewPagerAdapter accMyorderViewPagerAdapter;
    private String[] titles = new String[]{"Active","Expire"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAccountMyordersBinding.inflate(getLayoutInflater());

        accMyorderViewPagerAdapter = new AccMyorderViewPagerAdapter(requireActivity());

        binding.vpAccount.setAdapter(accMyorderViewPagerAdapter);

        new TabLayoutMediator(binding.tbAccountMyOrders,binding.vpAccount,(((tab, position) -> tab.setText(titles[position])))).attach();


        binding.igMyOrdersToAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(AccountMyordersFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new AccountFragment());
                fragmentTransaction.addToBackStack(null).commit();
            }
        });
        return binding.getRoot();
    }
}