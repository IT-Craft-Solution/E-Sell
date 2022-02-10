package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.itcraftsolution.esell.Adapter.ChatMessageAdapter;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.Extra.LoadingDialog;
import com.itcraftsolution.esell.MainActivity;
import com.itcraftsolution.esell.Model.ChatMessage;
import com.itcraftsolution.esell.Model.UserModel;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentChatScreenBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChatScreenFragment extends Fragment {


    public ChatScreenFragment() {
        // Required empty public constructor
    }

    private FragmentChatScreenBinding binding;
    private SpfUserData spf;
    private String ItemImg, ItemPrice, ItemTitle, ItemLocation, UserName,UserImg;
    private int ItemId, UserId;
    private LoadingDialog dialog;
    private ChatMessageAdapter adapter;
    private ArrayList<ChatMessage> messages;
    private String SenderRoom, ReceiverRoom, ReceiverUid;
    private FirebaseDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatScreenBinding.inflate(getLayoutInflater());
        LoadData();
        db = FirebaseDatabase.getInstance();

        messages = new ArrayList<>();

        adapter = new ChatMessageAdapter(requireContext(), messages);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.setStackFromEnd(true);
        binding.rvChatDetails.setLayoutManager(linearLayoutManager);
        binding.rvChatDetails.setAdapter(adapter);

        String SenderUid = FirebaseAuth.getInstance().getUid();

        SenderRoom = SenderUid + ReceiverUid;
        ReceiverRoom = ReceiverUid + SenderUid;


        db.getReference().child("Chats").child(SenderRoom).child("messages").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messages.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    ChatMessage chatMessage = snapshot1.getValue(ChatMessage.class);
                    messages.add(chatMessage);
                }
                adapter.notifyDataSetChanged();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(requireContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.igSendMSg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.edMessageBox.getText().toString().isEmpty()) {
                    binding.edMessageBox.requestFocus();
                }
                String message = binding.edMessageBox.getText().toString();
                Date date = new Date();
                ChatMessage chatMessage = new ChatMessage(message, SenderUid, date.getTime());

                db.getReference().child("Chats").child(SenderRoom).child("messages").push().setValue(chatMessage)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                binding.edMessageBox.setText("");
                                db.getReference().child("Chats").child(ReceiverRoom).child("messages").push().setValue(chatMessage)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {

                                            }
                                        });
                            }
                        });
            }
        });


        binding.igChatScreenBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(ChatScreenFragment.this);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth, R.anim.enter_from_rigth);
                fragmentTransaction.replace(R.id.frMainContainer, new ChatFragment())
                        .addToBackStack(null).commit();

            }
        });


        return binding.getRoot();
    }

    private void LoadData() {

        dialog = new LoadingDialog(requireActivity());
        dialog.StartLoadingDialog();
        spf = new SpfUserData(requireContext());
//        ItemImg = spf.getItemDetails().getString("ItemImg", null);
        ItemPrice = spf.getItemDetails().getString("ItemPrice", null);
//         spf.getItemDetails().getString("ItemTitle", null);
//         spf.getItemDetails().getString("ItemLocation", null);
//        ItemId = spf.getItemDetails().getInt("ItemId", 0);
//        UserId = spf.getItemDetails().getInt("UserId", 0);

        UserName = spf.getCreateChat().getString("UserName",null);
        UserImg =spf.getCreateChat().getString("UserImg",null);
        ItemLocation =spf.getCreateChat().getString("ItemLocation",null);
        ItemTitle =spf.getCreateChat().getString("ItemName",null);
        ReceiverUid =spf.getCreateChat().getString("ReceiverId",null);

        Glide.with(requireContext()).load(ApiUtilities.UserImage+UserImg).into(binding.igProfileDp);
        binding.txItemDetailsLocation.setText(ItemLocation);
        binding.txChatUserName.setText(UserName);
        binding.txChatItemName.setText(ItemTitle);
        binding.txChatItemPrice.setText(ItemPrice);
        dialog.StopLoadingDialog();

    }
}