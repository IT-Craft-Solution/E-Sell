package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment {

    public AccountFragment() {
        // Required empty public constructor
    }

       private FragmentAccountBinding  binding;
       private FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(getLayoutInflater());

        auth = FirebaseAuth.getInstance();

    binding.TvSettings.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            auth.signOut();
        }
    });



      return binding.getRoot();
    }
}