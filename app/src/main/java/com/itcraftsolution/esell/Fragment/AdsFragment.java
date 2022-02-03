package com.itcraftsolution.esell.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.itcraftsolution.esell.Adapter.MyAdsItemAdapter;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.Model.MyAdsItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentAdsBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdsFragment extends Fragment {




    public AdsFragment() {
        // Required empty public constructor
    }

    private FragmentAdsBinding binding;
    private SpfUserData spf;
    private MyAdsItemAdapter adapter;
    private int UserId;
    private ProgressDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdsBinding.inflate(getLayoutInflater());

        dialog = new ProgressDialog(requireContext());
        dialog.setCancelable(false);
        dialog.setMessage("Data Updating....");
        dialog.show();

        FetchData();



        return binding.getRoot();
    }

    private  void FetchData()
    {
        spf = new SpfUserData();
        UserId = spf.getSpf(requireContext()).getInt("UserId",0);

        ApiUtilities.apiInterface().ReadSellItem(UserId).enqueue(new Callback<List<MyAdsItem>>() {
            @Override
            public void onResponse(Call<List<MyAdsItem>> call, Response<List<MyAdsItem>> response) {
            List<MyAdsItem> list = response.body();
            if(list != null)
            {
              if(list.get(0).getMessage() == null)
              {
                  adapter = new MyAdsItemAdapter(requireContext(),list);
                  GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 1);
                  binding.rvMyAdsItem.setLayoutManager(gridLayoutManager);
                  dialog.dismiss();
                  binding.rvMyAdsItem.setAdapter(adapter);
              }else {

                  Toast.makeText(requireContext(), "Data Not Found", Toast.LENGTH_SHORT).show();
              }
            }
            }

            @Override
            public void onFailure(Call<List<MyAdsItem>> call, Throwable t) {
                Toast.makeText(requireContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}