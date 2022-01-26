package com.itcraftsolution.esell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.itcraftsolution.esell.Fragment.ChatScreenFragment;
import com.itcraftsolution.esell.Fragment.ItemDetailsFragment;
import com.itcraftsolution.esell.Model.ChatBuying;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.ChatBuyingSampleBinding;

import java.util.ArrayList;

public class ChatBuyingAdapter extends  RecyclerView.Adapter<ChatBuyingAdapter.viewHolder>{
    ArrayList<ChatBuying> chatBuyings;
    Context context;

    public ChatBuyingAdapter(ArrayList<ChatBuying> chatBuyings, Context context) {
        this.chatBuyings = chatBuyings;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chat_buying_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ChatBuying chatBuying = chatBuyings.get(position);

        holder.binding.igProfileDp.setImageResource(chatBuying.getItemImage());
        holder.binding.txUserName.setText(chatBuying.getUserName());
        holder.binding.txUserMessage.setText(chatBuying.getItemMessage());
        holder.binding.txChatTime.setText(chatBuying.getItemTime());
        holder.binding.txItemName.setText(chatBuying.getItemName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth)
                        .replace(R.id.frMainContainer , new ChatScreenFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return chatBuyings.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
            ChatBuyingSampleBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ChatBuyingSampleBinding.bind(itemView);
        }
    }
}
