package com.itcraftsolution.esell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.itcraftsolution.esell.Api.ApiUtilities;
import com.itcraftsolution.esell.Fragment.ItemDetailsFragment;
import com.itcraftsolution.esell.Model.HomeFreshItem;
import com.itcraftsolution.esell.Model.MyAdsItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.HomeFreshitemSampleBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

import java.util.ArrayList;
import java.util.List;

public class HomeFreshItemRecyclerAdapter extends RecyclerView.Adapter<HomeFreshItemRecyclerAdapter.viewHolder> {

    Context context;
    List<MyAdsItem> homeFreshItems;
    SpfUserData spf;

    public HomeFreshItemRecyclerAdapter(Context context, List<MyAdsItem> homeFreshItems) {
        this.context = context;
        this.homeFreshItems = homeFreshItems;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_freshitem_sample , parent , false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        MyAdsItem model = homeFreshItems.get(position);

    Glide.with(context).load(ApiUtilities.SellItemImage+model.getItem_img()).into(holder.binding.igSampleHomeFreshItem);
    holder.binding.txSampleHomeFreshItemName.setText(model.getTitle());
    holder.binding.txSampleHomeFreshItemPrice.setText(String.valueOf("₹ "+model.getPrice()));
    holder.binding.txSampleHomeFreshItemLocation.setText(String.valueOf(model.getCity_area()+" ,"+model.getLocation()));
        spf = new SpfUserData();
        spf.setItemDetail(context, model.getItem_img(), String.valueOf("₹ "+model.getPrice()),model.getTitle(),String.valueOf(model.getCity_area()+" ,"+model.getLocation())
                ,model.getDescription(),model.getId());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth)
                    .replace(R.id.frMainContainer , new ItemDetailsFragment())
                    .addToBackStack(null)
                    .commit();
        }
    });
    }

    @Override
    public int getItemCount() {
        return homeFreshItems.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        HomeFreshitemSampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = HomeFreshitemSampleBinding.bind(itemView);
        }
    }
}
