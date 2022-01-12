package com.itcraftsolution.esell.Fragments;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itcraftsolution.esell.MainActivity;
import com.itcraftsolution.esell.R;


public class mapsAndLocation extends Fragment {


    public mapsAndLocation() {
        // Required empty public constructor
    }

    private RelativeLayout rl;
    private static final int REQ_CODE = 1;
    private TextView tvLink;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maps_and_location, container, false);

        rl = view.findViewById(R.id.RelativeLayout);
        tvLink = view.findViewById(R.id.tvLink);
        tvLink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                requireActivity().finishAffinity();
            }
        });



        rl.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {


            }
        });
        return view;
    }
}