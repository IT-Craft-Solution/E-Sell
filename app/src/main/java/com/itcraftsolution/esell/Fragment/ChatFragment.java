package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.itcraftsolution.esell.Adapter.ChatHomeViewPagerAdapter;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentChatBinding;


public class ChatFragment extends Fragment {


    public ChatFragment() {
        // Required empty public constructor
    }

    ChatHomeViewPagerAdapter chatHomeViewPagerAdapter;
    FragmentChatBinding binding;
    private String[] titles = new String[]{"Buying","Selling"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(getLayoutInflater());

        chatHomeViewPagerAdapter = new ChatHomeViewPagerAdapter(requireActivity());

           binding.vpMainChat.setAdapter(chatHomeViewPagerAdapter);

           new TabLayoutMediator(binding.tbMainChat,binding.vpMainChat,((tab, position) ->tab.setText(titles[position]))).attach();

        return binding.getRoot();
    }
}