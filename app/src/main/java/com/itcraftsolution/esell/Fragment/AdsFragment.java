package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.itcraftsolution.esell.Adapter.MyAdsItemAdapter;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.Extra.LoadingDialog;
import com.itcraftsolution.esell.Model.MyAdsItem;
import com.itcraftsolution.esell.databinding.FragmentAdsBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

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
    private LoadingDialog loadingDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdsBinding.inflate(getLayoutInflater());

        loadingDialog = new LoadingDialog(requireActivity());
        loadingDialog.StartLoadingDialog();

        FetchData();

        return binding.getRoot();
    }

    private  void FetchData()
    {
        spf = new SpfUserData(requireContext());
        UserId = spf.getSpf().getInt("UserId",0);

        ApiUtilities.apiInterface().MyadSellItem(UserId).enqueue(new Callback<List<MyAdsItem>>() {
            @Override
            public void onResponse(Call<List<MyAdsItem>> call, Response<List<MyAdsItem>> response) {
            List<MyAdsItem> list = response.body();
            if(list != null)
            {
              if(list.get(0).getMessage() == null)
              {
                  Toast.makeText(requireContext(), ""+list.get(0).getItem_img(), Toast.LENGTH_SHORT).show();
                  adapter = new MyAdsItemAdapter(requireContext(),list);
                  GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 1);
                  binding.rvMyAdsItem.setLayoutManager(gridLayoutManager);
                  loadingDialog.StopLoadingDialog();
                  binding.rvMyAdsItem.setAdapter(adapter);
              }else {
                  loadingDialog.StopLoadingDialog();
                  binding.rvMyAdsItem.setVisibility(View.GONE);
                  binding.llNoDataFound.setVisibility(View.VISIBLE);
                  Toast.makeText(requireContext(), "Data Not Found", Toast.LENGTH_SHORT).show();
              }
            }
            }

            @Override
            public void onFailure(Call<List<MyAdsItem>> call, Throwable t) {
                loadingDialog.StopLoadingDialog();
                Toast.makeText(requireContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}