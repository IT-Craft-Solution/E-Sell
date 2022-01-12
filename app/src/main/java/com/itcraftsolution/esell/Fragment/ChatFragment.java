package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.Adapter.ChatHomeViewPagerAdapter;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentChatBinding;


public class ChatFragment extends Fragment {


    public ChatFragment() {
        // Required empty public constructor
    }

    FragmentChatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(getLayoutInflater());

        binding.vpMainChat.setAdapter(new ChatHomeViewPagerAdapter(getParentFragmentManager()));
        binding.tbMainChat.setupWithViewPager(binding.vpMainChat);

        return binding.getRoot();
    }
}