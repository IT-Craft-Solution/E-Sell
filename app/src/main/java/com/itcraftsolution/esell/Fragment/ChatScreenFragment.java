package com.itcraftsolution.esell.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.itcraftsolution.esell.databinding.FragmentChatScreenBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Chat Screen Fragment
public class ChatScreenFragment extends Fragment {

    public ChatScreenFragment() {
        // Required empty public constructor
    }

    private FragmentChatScreenBinding binding;

    FirebaseUser fuser;
    DatabaseReference reference;

//    MessageAdapter messageAdapter;
//    List<Chat> mchat;


    SpfUserData spf;

    ValueEventListener seenListener;

    String userid;

//    APIService apiService;

    boolean notify = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatScreenBinding.inflate(getLayoutInflater());

//        apiService = Client.getClient("https://fcm.googleapis.com/").create(APIService.class);
//
//
//        binding.recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
//        linearLayoutManager.setStackFromEnd(true);
//        binding.recyclerView.setLayoutManager(linearLayoutManager);
//
//
//
//        spf = new SpfUserData(requireContext());
//        userid = spf.getCreateChat().getString("ReceiverId",null);
//        fuser = FirebaseAuth.getInstance().getCurrentUser();
//
//        binding.btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                notify = true;
//                String msg = binding.textSend.getText().toString();
//                String time = String.valueOf(System.currentTimeMillis());
//                if (!msg.equals("")){
//                    sendMessage(fuser.getUid(), userid, msg, time);
//                } else {
//                    Toast.makeText(requireContext(), "You can't send empty message", Toast.LENGTH_SHORT).show();
//                }
//                binding.textSend.setText("");
//            }
//        });
//
//
//        reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);
//
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                User user = dataSnapshot.getValue(User.class);
//                assert user != null;
//                binding.username.setText(user.getUsername());
//                    Glide.with(requireContext()).load(user.getImageURL()).into(binding.profileImage);
//
//
//                readMesagges(fuser.getUid(), userid, user.getImageURL());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        seenMessage(userid);
//


        return binding.getRoot();
    }


//    private void seenMessage(final String userid){
//        reference = FirebaseDatabase.getInstance().getReference("Chats");
//        seenListener = reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    Chat chat = snapshot.getValue(Chat.class);
//                    if (chat.getReceiver().equals(fuser.getUid()) && chat.getSender().equals(userid)){
//                        HashMap<String, Object> hashMap = new HashMap<>();
//                        hashMap.put("isseen", true);
//                        snapshot.getRef().updateChildren(hashMap);
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//    private void sendMessage(String sender, final String receiver, String message, String time){
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("sender", sender);
//        hashMap.put("receiver", receiver);
//        hashMap.put("message", message);
//        hashMap.put("isseen", false);
//        hashMap.put("time", time);
//
//        reference.child("Chats").push().setValue(hashMap);
//
//
//        // add user to chat fragment
//        final DatabaseReference chatRef = FirebaseDatabase.getInstance().getReference("Chatlist")
//                .child(fuser.getUid())
//                .child(userid);
//
//        chatRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (!dataSnapshot.exists()){
//                    chatRef.child("id").setValue(userid);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        final DatabaseReference chatRefReceiver = FirebaseDatabase.getInstance().getReference("Chatlist")
//                .child(userid)
//                .child(fuser.getUid());
//        chatRefReceiver.child("id").setValue(fuser.getUid());
//
//        final String msg = message;
//
//        reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                User user = dataSnapshot.getValue(User.class);
//                if (notify) {
//                    sendNotifiaction(receiver, user.getUsername(), msg);
//                }
//                notify = false;
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//    private void sendNotifiaction(String receiver, final String username, final String message){
//        DatabaseReference tokens = FirebaseDatabase.getInstance().getReference("Tokens");
//        Query query = tokens.orderByKey().equalTo(receiver);
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    Token token = snapshot.getValue(Token.class);
//                    Data data = new Data(fuser.getUid(), R.drawable.logo, username+": "+message, "New Message",
//                            userid);
//
//                    assert token != null;
//                    Sender sender = new Sender(data, token.getToken());
//
//                    apiService.sendNotification(sender)
//                            .enqueue(new Callback<MyResponse>() {
//                                @Override
//                                public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
//                                    if (response.code() == 200){
//                                        assert response.body() != null;
//                                        if (response.body().success != 1){
//                                            //Toast.makeText(MessageActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//                                }
//
//                                @Override
//                                public void onFailure(Call<MyResponse> call, Throwable t) {
//
//                                }
//                            });
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//    private void readMesagges(final String myid, final String userid, final String imageurl){
//        mchat = new ArrayList<>();
//
//        reference = FirebaseDatabase.getInstance().getReference("Chats");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                mchat.clear();
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    Chat chat = snapshot.getValue(Chat.class);
//                    assert chat != null;
//                    if (chat.getReceiver().equals(myid) && chat.getSender().equals(userid) ||
//                            chat.getReceiver().equals(userid) && chat.getSender().equals(myid)){
//                        mchat.add(chat);
//                    }
//
//                    messageAdapter = new MessageAdapter(requireActivity(), mchat, imageurl);
//                    binding.recyclerView.setAdapter(messageAdapter);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//
////    private void currentUser(String userid){
////        SharedPreferences.Editor editor = requireContext().getSharedPreferences("PREFS", MODE_PRIVATE).edit();
////        editor.putString("currentuser", userid);
////        editor.apply();
////    }
//
//    private void status(String status){
//        reference = FirebaseDatabase.getInstance().getReference("Users").child(fuser.getUid());
//
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("status", status);
//
//        reference.updateChildren(hashMap);
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        status("online");
////        currentUser(userid);
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        reference.removeEventListener(seenListener);
//        status("offline");
////        currentUser("none");
//    }
}