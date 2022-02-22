package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.models.SlideModel;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentProductImageBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ProductImageFragment extends Fragment {


    public ProductImageFragment() {
        // Required empty public constructor
    }

    private FragmentProductImageBinding binding;
    private SpfUserData spf;
    private String ItemImg;
    private List<SlideModel> slideModels;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductImageBinding.inflate(getLayoutInflater());


        // Call Load Method
        LoadData();

        // Back Arrow
        //Go To Product Detail Fragment
        binding.igItemDetailsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(ProductImageFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth, R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer, new ItemDetailsFragment())
                        .addToBackStack(null).commit();
            }
        });



        return binding.getRoot();
    }

    // LoadData Method
    private void LoadData() {
        spf = new SpfUserData(requireContext());
//        UserId = spf.getItemDetails().getInt("UserId", 0);
        ItemImg = spf.getItemDetails().getString("ItemImg", null);
//        ItemPrice = spf.getItemDetails().getString("ItemPrice", null);
//        ItemTitle = spf.getItemDetails().getString("ItemTitle", null);
//        ItemLocation = spf.getItemDetails().getString("ItemLocation", null);
//        ItemId = spf.getItemDetails().getInt("ItemId", 0);
//        ItemDesc = spf.getItemDetails().getString("ItemDesc", null);
//        ItemCat = spf.getItemDetails().getString("Category", null);
//        ReceiverUid = spf.getItemDetails().getString("Auth_Id", null);
//        LoginUserId = spf.getSpf().getInt("UserId", 0);
//        if (LoginUserId == UserId) {
//            binding.btnChat.setVisibility(View.GONE);
//        }

        List<String> list = new ArrayList<String>(Arrays.asList(ItemImg.split(",")));
        slideModels = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            slideModels.add(new SlideModel(ApiUtilities.SellItemImage + list.get(i)));
        }
        binding.isProductImagesSlider.setImageList(slideModels, true);
    }

}