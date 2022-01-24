package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.Adapter.ChatBuyingAdapter;
import com.itcraftsolution.esell.Model.ChatBuying;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentChatBuyingBinding;

import java.util.ArrayList;


public class ChatBuyingFragment extends Fragment {



    public ChatBuyingFragment() {
        // Required empty public constructor
    }

     private ArrayList<ChatBuying> chatBuyings;
     private FragmentChatBuyingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatBuyingBinding.inflate(getLayoutInflater());

        chatBuyings = new ArrayList<>();
        chatBuyings.add(new ChatBuying(R.drawable.edit_profile_icon,"Karan desai","hii","Yesterday"));
        chatBuyings.add(new ChatBuying(R.drawable.edit_profile_icon,"Karan desai","hii","Yesterday"));
        chatBuyings.add(new ChatBuying(R.drawable.edit_profile_icon,"Karan desai","hii","Yesterday"));
        chatBuyings.add(new ChatBuying(R.drawable.edit_profile_icon,"Karan desai","hii","Yesterday"));
        chatBuyings.add(new ChatBuying(R.drawable.edit_profile_icon,"Karan desai","hii","Yesterday"));
        chatBuyings.add(new ChatBuying(R.drawable.edit_profile_icon,"Karan desai","hii","Yesterday"));
        chatBuyings.add(new ChatBuying(R.drawable.edit_profile_icon,"Karan desai","hii","Yesterday"));
        chatBuyings.add(new ChatBuying(R.drawable.edit_profile_icon,"Karan desai","hii","Yesterday"));
        chatBuyings.add(new ChatBuying(R.drawable.edit_profile_icon,"Karan desai","hii","Yesterday"));
        chatBuyings.add(new ChatBuying(R.drawable.edit_profile_icon,"Karan desai","hii","Yesterday"));
        chatBuyings.add(new ChatBuying(R.drawable.edit_profile_icon,"Karan desai","hii","Yesterday"));

        ChatBuyingAdapter chatBuyingAdapter = new ChatBuyingAdapter(chatBuyings, getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        binding.rvChatBuying.setLayoutManager(gridLayoutManager);
        binding.rvChatBuying.setAdapter(chatBuyingAdapter);

        return binding.getRoot();
    }
}