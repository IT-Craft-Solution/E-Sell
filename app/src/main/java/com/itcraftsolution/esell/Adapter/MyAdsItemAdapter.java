package com.itcraftsolution.esell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.Model.MyAdsItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.MyadsItemSampleBinding;
import java.util.List;

public class MyAdsItemAdapter extends RecyclerView.Adapter<MyAdsItemAdapter.viewHolder>{
    Context context;
    List<MyAdsItem> myAdsItems;

    public MyAdsItemAdapter(Context context, List<MyAdsItem> myAdsItems) {
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

        Glide.with(context).load(ApiUtilities.SellItemImage+myAdsItem.getItem_img()).into(holder.binding.igItemImage);
        holder.binding.txItemName.setText(myAdsItem.getTitle());
        holder.binding.txItemPrice.setText(String.valueOf("₹ "+myAdsItem.getPrice()));
        holder.binding.txDesc.setText(myAdsItem.getDescription());
        holder.binding.txItemLocation.setText(String.valueOf(myAdsItem.getCity_area()+" ,"+myAdsItem.getLocation()));
        holder.binding.txDate.setText(myAdsItem.getDate());

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
