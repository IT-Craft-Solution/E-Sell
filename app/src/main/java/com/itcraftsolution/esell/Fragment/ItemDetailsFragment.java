package com.itcraftsolution.esell.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentItemDetailsBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

public class ItemDetailsFragment extends Fragment {



    public ItemDetailsFragment() {
        // Required empty public constructor
    }

   private  FragmentItemDetailsBinding binding;
    private SpfUserData spf;
    private String ItemImg,ItemPrice,ItemDesc,ItemTitle,ItemLocation;
    private int ItemId;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentItemDetailsBinding.inflate(getLayoutInflater());

        LoadData();
        binding.igItemDetailsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(ItemDetailsFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new HomeFragment())
                        .addToBackStack(null).commit();
            }
        });

        binding.igItemDetailsShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "I've found this on #E-Sell. What do you think?" +ItemTitle +" ,"+ItemDesc+" "+ApiUtilities.SellItemImage+ItemImg);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        return binding.getRoot();
    }
    private void LoadData()
    {
        spf = new SpfUserData();
        ItemImg = spf.getItemDetails(requireContext()).getString("ItemImg",null);
        ItemPrice = spf.getItemDetails(requireContext()).getString("ItemPrice",null);
        ItemTitle = spf.getItemDetails(requireContext()).getString("ItemTitle",null);
        ItemDesc = spf.getItemDetails(requireContext()).getString("ItemDesc",null);
        ItemLocation = spf.getItemDetails(requireContext()).getString("ItemLocation",null);
        ItemId = spf.getItemDetails(requireContext()).getInt("ItemId", 0);
        Glide.with(requireContext()).load(ApiUtilities.SellItemImage+ItemImg).into(binding.igItemDetails);
        binding.txItemDetailsLocation.setText(ItemLocation);
        binding.txItemDetailsName.setText(ItemTitle);
        binding.txItemDetailsPrice.setText(ItemPrice);
        binding.txItemDesc.setText(ItemDesc);
    }
}