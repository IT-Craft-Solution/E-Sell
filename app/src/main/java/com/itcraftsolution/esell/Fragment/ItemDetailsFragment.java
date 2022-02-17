package com.itcraftsolution.esell.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.models.SlideModel;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.Extra.LoadingDialog;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentItemDetailsBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

import java.util.ArrayList;
import java.util.List;

public class ItemDetailsFragment extends Fragment {


    public ItemDetailsFragment() {
        // Required empty public constructor
    }

    private FragmentItemDetailsBinding binding;
    private SpfUserData spf, spfUserData;
    private String ItemImg, ItemPrice, ItemDesc, ItemTitle, ItemLocation, ReceiverUid, User_Name, User_img, UserPhone, ItemCat, Auth_id;
    private int ItemId, UserId, LoginUserId;
    private LoadingDialog loadingDialog;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentItemDetailsBinding.inflate(getLayoutInflater());

        // Image Slider
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(""));
        slideModels.add(new SlideModel(R.drawable.testing));
        slideModels.add(new SlideModel(R.drawable.testing));
        slideModels.add(new SlideModel(R.drawable.testing));
        slideModels.add(new SlideModel(R.drawable.testing));
        slideModels.add(new SlideModel(R.drawable.testing));
        slideModels.add(new SlideModel(R.drawable.testing));
        slideModels.add(new SlideModel(R.drawable.testing));
        binding.isProductImagesSlider.setImageList(slideModels,true);


        //Call LoadData Method
        LoadData();

        //BackA Arrow
        //Go To HomeFragment
        binding.igItemDetailsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(ItemDetailsFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth, R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer, new HomeFragment())
                        .addToBackStack(null).commit();
            }
        });

        //Button Chat
        // Go To ChatScreenFragment
        binding.btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(ItemDetailsFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth, R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer, new ChatScreenFragment())
                        .addToBackStack(null).commit();
            }
        });

        //Button Share
        //Share Product
        binding.igItemDetailsShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "I've found this on #E-Sell. What do you think?" + ItemTitle + " ," + ItemDesc + " " + ApiUtilities.SellItemImage + ItemImg);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

//        binding.btnDiscuss.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SpfUserData spfUserData = new SpfUserData(requireContext());
//                spfUserData.setItemDetail(ItemImg,ItemPrice,ItemTitle,ItemLocation,ItemDesc,ItemId,UserId,0,0,ItemCat,Auth_id,1);
//                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//                fragmentTransaction.remove(ItemDetailsFragment.this);
//                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
//                fragmentTransaction.replace(R.id.frMainContainer , new DiscussFragment())
//                        .addToBackStack(null).commit();
//            }
//        });

        return binding.getRoot();
    }

    //LoadData Method
    //Load Data From Server
    private void LoadData() {
        spf = new SpfUserData(requireContext());
        UserId = spf.getItemDetails().getInt("UserId", 0);
        ItemImg = spf.getItemDetails().getString("ItemImg", null);
        ItemPrice = spf.getItemDetails().getString("ItemPrice", null);
        ItemTitle = spf.getItemDetails().getString("ItemTitle", null);
        ItemLocation = spf.getItemDetails().getString("ItemLocation", null);
        ItemId = spf.getItemDetails().getInt("ItemId", 0);
        ItemDesc = spf.getItemDetails().getString("ItemDesc", null);
        ItemCat = spf.getItemDetails().getString("Category", null);
        Auth_id = spf.getItemDetails().getString("Auth_Id", null);
        LoginUserId = spf.getSpf().getInt("UserId", 0);
        if (LoginUserId == UserId) {
            binding.btnChat.setVisibility(View.GONE);
        }

        Glide.with(requireContext()).load(ApiUtilities.SellItemImage + ItemImg).into(binding.igItemDetails);
        binding.txItemDetailsLocation.setText(ItemLocation);
        binding.txItemDetailsName.setText(ItemTitle);
        binding.txItemDetailsPrice.setText(ItemPrice);
        binding.txItemDesc.setText(ItemDesc);
    }
}