package com.itcraftsolution.esell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.itcraftsolution.esell.Model.ChatMessage;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.ChatreciveSampleBinding;
import com.itcraftsolution.esell.databinding.ChatsendSampleBinding;

import java.util.ArrayList;
import java.util.Objects;

public class ChatMessageAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<ChatMessage> list;
    final int ITEM_SENT = 1;
    final int ITEM_RECEIVE = 2;

    public ChatMessageAdapter(Context context, ArrayList<ChatMessage> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == ITEM_SENT)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.chatsend_sample, parent, false);
            return new SentviewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.chatrecive_sample, parent, false);
            return new ReceiverviewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatMessage message = list.get(position);
        if(holder.getClass() == SentviewHolder.class)
        {
            SentviewHolder viewHolder = (SentviewHolder) holder;
            viewHolder.binding.txSendMSg.setText(message.getMessage());
        }else
        {
            ReceiverviewHolder viewHolder = (ReceiverviewHolder) holder;
            viewHolder.binding.txReceiverMsg.setText(message.getMessage());
        }
    }

    @Override
    public int getItemViewType(int position) {
        ChatMessage message = list.get(position);
        if(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid().equals(message.getSenderId()))
        {
            return ITEM_SENT;
        }else {
            return ITEM_RECEIVE;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class SentviewHolder extends RecyclerView.ViewHolder {
        ChatsendSampleBinding binding;
        public SentviewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ChatsendSampleBinding.bind(itemView);
        }
    }

    public static class ReceiverviewHolder extends RecyclerView.ViewHolder {
        ChatreciveSampleBinding binding;
        public ReceiverviewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ChatreciveSampleBinding.bind(itemView);
        }
    }
}
