package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.itcraftsolution.esell.Model.ChatModel;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentChatBinding;

import java.util.ArrayList;
import java.util.List;


public class ChatFragment extends Fragment {


    public ChatFragment() {
        // Required empty public constructor
    }


    private FragmentChatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(getLayoutInflater());
        binding.igBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(ChatFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new ChatScreenFragment())
                        .addToBackStack(null).commit();
            }
        });
        return binding.getRoot();
    }

}