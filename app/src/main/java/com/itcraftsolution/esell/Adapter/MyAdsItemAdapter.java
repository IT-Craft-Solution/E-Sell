package com.itcraftsolution.esell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itcraftsolution.esell.Model.MyAdsItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.MyadsItemSampleBinding;

import java.util.ArrayList;

public class MyAdsItemAdapter extends RecyclerView.Adapter<MyAdsItemAdapter.viewHolder>{
    Context context;
    ArrayList<MyAdsItem> myAdsItems;

    public MyAdsItemAdapter(Context context, ArrayList<MyAdsItem> myAdsItems) {
        this.context = context;
        this.myAdsItems = myAdsItems;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.myads_item_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        MyAdsItem myAdsItem = myAdsItems.get(position);

        holder.binding.igItemImage.setImageResource(myAdsItem.getItemImage());
        holder.binding.txItemName.setText(myAdsItem.getItemName());
        holder.binding.txItemPrice.setText(myAdsItem.getItemPrice());
        holder.binding.txItemLocation.setText(myAdsItem.getItemLocation());
        holder.binding.txDate.setText(myAdsItem.getDate());
        holder.binding.txViews.setText(myAdsItem.getItemViews());
        holder.binding.txLikes.setText(myAdsItem.getItemLikes());

    }

    @Override
    public int getItemCount() {
        return myAdsItems.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        MyadsItemSampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = MyadsItemSampleBinding.bind(itemView);
        }
    }
}
