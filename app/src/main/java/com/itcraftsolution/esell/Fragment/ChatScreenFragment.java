package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentChatScreenBinding;


public class ChatScreenFragment extends Fragment {


    public ChatScreenFragment() {
        // Required empty public constructor
    }

    private FragmentChatScreenBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatScreenBinding.inflate(getLayoutInflater());


        binding.igChatScreenBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(ChatScreenFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth, R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer, new ChatFragment())
                        .addToBackStack(null).commit();

            }
        });


        return binding.getRoot();
    }
}