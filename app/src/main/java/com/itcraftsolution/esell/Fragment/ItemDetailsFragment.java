package com.itcraftsolution.esell.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.api.Api;
import com.google.firebase.auth.FirebaseAuth;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.Extra.LoadingDialog;
import com.itcraftsolution.esell.MainActivity;
import com.itcraftsolution.esell.Model.ResponceModel;
import com.itcraftsolution.esell.Model.UserModel;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentItemDetailsBinding;
import com.itcraftsolution.esell.spf.SpfUserData;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDetailsFragment extends Fragment {



    public ItemDetailsFragment() {
        // Required empty public constructor
    }

   private  FragmentItemDetailsBinding binding;
    private SpfUserData spf,spfUserData;
    private String ItemImg,ItemPrice,ItemDesc,ItemTitle,ItemLocation,ReceiverUid,User_Name,User_img,UserPhone;
    private int ItemId,UserId;
    private LoadingDialog loadingDialog;

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

//        binding.btnChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadingDialog = new LoadingDialog(requireActivity());
//                loadingDialog.StartLoadingDialog();
//                UserId = spf.getItemDetails().getInt("UserId", 0);
//                ReceiverUid = spf.getItemDetails().getString("Auth_Id", null);
//
//                ApiUtilities.apiInterface().ReadUserId(UserId)
//                        .enqueue(new Callback<UserModel>() {
//                            @Override
//                            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
//                                UserModel model = response.body();
//                                if (model != null) {
//                                    if (model.getMessage() == null) {
//                                        loadingDialog.StopLoadingDialog();
//                                        User_Name = model.getUser_name();
//                                        User_img = model.getUser_img();
//
//                                        ApiUtilities.apiInterface().CreateChat(User_Name,User_img,ItemLocation,ItemTitle,ReceiverUid,1)
//                                                .enqueue(new Callback<ResponceModel>() {
//                                                    @Override
//                                                    public void onResponse(Call<ResponceModel> call, Response<ResponceModel> response) {
//                                                        ResponceModel responceModel = response.body();
//                                                        if(responceModel != null)
//                                                        {
//                                                            if(responceModel.getMessage().equals("fail"))
//                                                            {
//                                                                loadingDialog.StopLoadingDialog();
//                                                                Toast.makeText(requireActivity(), "Something went wrong!!", Toast.LENGTH_SHORT).show();
//                                                            }
//                                                            else {
//                                                                loadingDialog.StopLoadingDialog();
//                                                                spfUserData = new SpfUserData(requireContext());
//                                                                spfUserData.setCreateChat(User_Name,User_img,ItemTitle,ItemLocation,ReceiverUid,1);
//                                                                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//                                                                fragmentTransaction.remove(ItemDetailsFragment.this);
//                                                                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
//                                                                fragmentTransaction.replace(R.id.frMainContainer , new ChatFragment())
//                                                                        .addToBackStack(null).commit();
//                                                                Toast.makeText(requireContext(), ""+responceModel.getMessage(), Toast.LENGTH_SHORT).show();
//                                                            }
//                                                        }
//                                                    }
//
//                                                    @Override
//                                                    public void onFailure(Call<ResponceModel> call, Throwable t) {
//                                                        loadingDialog.StopLoadingDialog();
//                                                        Toast.makeText(requireContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
//                                                    }
//                                                });
//                                    } else {
//                                        loadingDialog.StopLoadingDialog();
//                                        Toast.makeText(requireContext(), "Data Not Found", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(Call<UserModel> call, Throwable t) {
//                                loadingDialog.StopLoadingDialog();
//                                Toast.makeText(requireContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//
//
//            }
//        });

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

        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingDialog loadingDialog = new LoadingDialog(requireActivity());
                loadingDialog.StartLoadingDialog();
                ApiUtilities.apiInterface().ReadUserId(UserId)
                        .enqueue(new Callback<UserModel>() {
                            @Override
                            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                                UserModel model = response.body();
                                if (model != null) {
                                    if (model.getMessage() == null) {
                                        loadingDialog.StopLoadingDialog();
                                       UserPhone = model.getPhone();

                                        Dexter.withContext(requireContext()).withPermission(Manifest.permission.CALL_PHONE)
                                                .withListener(new PermissionListener() {
                                                    @Override
                                                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                                        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+UserPhone));
                                                        try{
                                                            startActivity(intent);
                                                        }catch (Exception e)
                                                        {
                                                            Toast.makeText(requireContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                                                        }
                                                    }

                                                    @Override
                                                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                                                    }

                                                    @Override
                                                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                                        permissionToken.continuePermissionRequest();
                                                    }
                                                }).check();

                                    } else {
                                        loadingDialog.StopLoadingDialog();
                                        Toast.makeText(requireContext(), "Data Not Found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<UserModel> call, Throwable t) {
                                loadingDialog.StopLoadingDialog();
                                Toast.makeText(requireContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        return binding.getRoot();
    }
    private void LoadData()
    {
        spf = new SpfUserData(requireContext());
        ItemImg = spf.getItemDetails().getString("ItemImg",null);
        ItemPrice = spf.getItemDetails().getString("ItemPrice",null);
        ItemTitle = spf.getItemDetails().getString("ItemTitle",null);
        ItemDesc = spf.getItemDetails().getString("ItemDesc",null);
        ItemLocation = spf.getItemDetails().getString("ItemLocation",null);
        ItemId = spf.getItemDetails().getInt("ItemId", 0);
        UserId = spf.getItemDetails().getInt("UserId", 0);

        Glide.with(requireContext()).load(ApiUtilities.SellItemImage+ItemImg).into(binding.igItemDetails);
        binding.txItemDetailsLocation.setText(ItemLocation);
        binding.txItemDetailsName.setText(ItemTitle);
        binding.txItemDetailsPrice.setText(ItemPrice);
        binding.txItemDesc.setText(ItemDesc);
    }
}