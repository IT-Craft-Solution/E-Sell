package com.itcraftsolution.esell.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.itcraftsolution.esell.Adapter.ActiveOrderRecyclerAdapter;
import com.itcraftsolution.esell.Adapter.HomeCatShowAdapter;
import com.itcraftsolution.esell.Adapter.HomeFreshItemRecyclerAdapter;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.Extra.LoadingDialog;
import com.itcraftsolution.esell.Model.HomeCatShow;
import com.itcraftsolution.esell.Model.MyAdsItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentActiveOrdersBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActiveOrdersFragment extends Fragment {


    public ActiveOrdersFragment() {
        // Required empty public constructor
    }

    private FragmentActiveOrdersBinding binding;
    private SpfUserData spfdata;
    private int UserId;
    private ActiveOrderRecyclerAdapter adapter;
    private LoadingDialog loadingDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentActiveOrdersBinding.inflate(getLayoutInflater());

        loadingDialog = new LoadingDialog(requireActivity());
        loadingDialog.StartLoadingDialog();
        FetchData();



        return binding.getRoot();
    }
    private void FetchData()
    {
        spfdata = new SpfUserData(requireContext());
        UserId = spfdata.getSpf().getInt("UserId",0);

        ApiUtilities.apiInterface().MyadSellItem(UserId).enqueue(new Callback<List<MyAdsItem>>() {
            @Override
            public void onResponse(Call<List<MyAdsItem>> call, Response<List<MyAdsItem>> response) {
                List<MyAdsItem> list = response.body();
                if(list != null)
                {
                    if(list.get(0).getMessage() == null)
                    {
                        adapter= new ActiveOrderRecyclerAdapter(requireContext(),list);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 1);
                        binding.rvActiveOrdersItem.setLayoutManager(gridLayoutManager);
                        loadingDialog.StopLoadingDialog();
                        binding.rvActiveOrdersItem.setAdapter(adapter);
                    }else {
                        loadingDialog.StopLoadingDialog();
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