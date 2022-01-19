package com.itcraftsolution.esell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.itcraftsolution.esell.Fragment.HomeCatShowFragment;
import com.itcraftsolution.esell.Model.SellCategory;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.SellCategorySampleBinding;

import java.util.ArrayList;

public class SellCategoryRecyclerAdapter extends RecyclerView.Adapter<SellCategoryRecyclerAdapter.viewHolder> {

    Context context;
    ArrayList<SellCategory> sellCategories;

    public SellCategoryRecyclerAdapter(Context context, ArrayList<SellCategory> sellCategories) {
        this.context = context;
        this.sellCategories = sellCategories;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sell_category_sample , parent , false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    SellCategory sellCategory = sellCategories.get(position);

    holder.binding.igSellCategorySample.setImageResource(sellCategory.getCat_img());
    holder.binding.txSellCategoryName.setText(sellCategory.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frMainContainer , new HomeCatShowFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return sellCategories.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        SellCategorySampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = SellCategorySampleBinding.bind(itemView);
        }
    }
}
