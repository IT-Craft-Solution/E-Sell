package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.Adapter.AccMyorderViewPagerAdapter;

import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentAccountMyordersBinding;


public class AccountMyordersFragment extends Fragment {


    public AccountMyordersFragment() {
        // Required empty public constructor
    }

    private FragmentAccountMyordersBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAccountMyordersBinding.inflate(getLayoutInflater());

        binding.vpAccount.setAdapter(new AccMyorderViewPagerAdapter(getParentFragmentManager()));
        binding.tbAccountMyOrders.setupWithViewPager(binding.vpAccount);

        binding.igMyOrdersToAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(AccountMyordersFragment.this);
                fragmentTransaction.replace(R.id.frMainContainer , new AccountFragment());
                fragmentTransaction.commit();
            }
        });
        return binding.getRoot();
    }
}