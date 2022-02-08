package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import com.itcraftsolution.esell.Adapter.ChatBuyingAdapter;
import com.itcraftsolution.esell.Adapter.HomeFreshItemRecyclerAdapter;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.Extra.LoadingDialog;
import com.itcraftsolution.esell.Model.ChatMessage;
import com.itcraftsolution.esell.Model.ChatModel;
import com.itcraftsolution.esell.Model.UserModel;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentChatBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChatFragment extends Fragment {


    public ChatFragment() {
        // Required empty public constructor
    }


    FragmentChatBinding binding;
    private String UserName,ReceiverId;
    private ChatBuyingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(getLayoutInflater());
        LoadData();
        binding.igBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(ChatFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer , new HomeFragment())
                        .addToBackStack(null).commit();
            }
        });


        return binding.getRoot();
    }

    private void LoadData()
    {
        LoadingDialog loadingDialog = new LoadingDialog(requireActivity());
        loadingDialog.StartLoadingDialog();
        SpfUserData spfUserData = new SpfUserData(requireContext());
        ReceiverId = spfUserData.getCreateChat().getString("ReceiverId",null);
        UserName = spfUserData.getCreateChat().getString("UserName",null);

        ApiUtilities.apiInterface().ReadChatUser(ReceiverId,UserName)
                .enqueue(new Callback<List<ChatModel>>() {
                    @Override
                    public void onResponse(Call<List<ChatModel>> call, Response<List<ChatModel>> response) {
                        List<ChatModel> list = response.body();

                        if(list != null)
                        {
                            if(list.get(0).getMessage() == null)
                            {
                                adapter = new ChatBuyingAdapter(list,requireContext());
                                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 1);
                                binding.rvChatBuying.setLayoutManager(gridLayoutManager);
                                loadingDialog.StopLoadingDialog();
                                binding.rvChatBuying.setAdapter(adapter);
                            }
                            else {
                                loadingDialog.StopLoadingDialog();
                                Toast.makeText(requireContext(), "Data Not Found", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            loadingDialog.StopLoadingDialog();
                            Toast.makeText(requireContext(), "Model khali", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ChatModel>> call, Throwable t) {
                        loadingDialog.StopLoadingDialog();
                        Toast.makeText(requireContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}