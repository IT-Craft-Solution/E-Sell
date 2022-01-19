package com.itcraftsolution.esell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.itcraftsolution.esell.Fragment.ItemDetailsFragment;
import com.itcraftsolution.esell.Model.HomeFreshItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.HomeFreshitemSampleBinding;

import java.util.ArrayList;

public class HomeFreshItemRecyclerAdapter extends RecyclerView.Adapter<HomeFreshItemRecyclerAdapter.viewHolder> {

    Context context;
    ArrayList<HomeFreshItem> homeFreshItems;

    public HomeFreshItemRecyclerAdapter(Context context, ArrayList<HomeFreshItem> homeFreshItems) {
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
    HomeFreshItem homeFreshItem = homeFreshItems.get(position);

    holder.binding.igSampleHomeFreshItem.setImageResource(homeFreshItem.getItemImage());
    holder.binding.txSampleHomeFreshItemName.setText(homeFreshItem.getItemName());
    holder.binding.txSampleHomeFreshItemPrice.setText(homeFreshItem.getItemPrice());
    holder.binding.txSampleHomeFreshItemLocation.setText(homeFreshItem.getItemLocation());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
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
