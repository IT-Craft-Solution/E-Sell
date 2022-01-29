package com.itcraftsolution.esell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.itcraftsolution.esell.Fragment.SellItemFormFragment;
import com.itcraftsolution.esell.Model.SellCategory;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.SellCategorySampleBinding;
import com.itcraftsolution.esell.spf.SpfUserData;

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
        public void onClick(View view) {
            SpfUserData spfUserData = new SpfUserData();
            spfUserData.setSpfHome(context, sellCategory.getName());
            ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
//                    .setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth)
                    .replace(R.id.frMainContainer , new SellItemFormFragment())
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
