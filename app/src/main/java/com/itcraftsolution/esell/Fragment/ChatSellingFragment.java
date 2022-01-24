package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itcraftsolution.esell.Adapter.ChatBuyingAdapter;
import com.itcraftsolution.esell.Model.ChatBuying;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.ChatBuyingSampleBinding;
import com.itcraftsolution.esell.databinding.FragmentChatSellingBinding;

import java.util.ArrayList;


public class ChatSellingFragment extends Fragment {

    public ChatSellingFragment() {
        // Required empty public constructor
    }

    private ArrayList<ChatBuying> chatBuyings;
     private FragmentChatSellingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatSellingBinding.inflate(getLayoutInflater());


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
        binding.rvChatSelling.setLayoutManager(gridLayoutManager);
        binding.rvChatSelling.setAdapter(chatBuyingAdapter);


      return binding.getRoot();
    }
}