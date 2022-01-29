package com.itcraftsolution.esell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.itcraftsolution.esell.Fragment.HomeCatShowFragment;
import com.itcraftsolution.esell.Fragment.login;
import com.itcraftsolution.esell.Model.HomeCategory;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.HomeCategorySampleBinding;

import java.util.ArrayList;

public class HomeCatRecyclerAdapter extends RecyclerView.Adapter<HomeCatRecyclerAdapter.viewHolder> {

    Context context;
    ArrayList<HomeCategory> homeCategories;

    public HomeCatRecyclerAdapter(Context context, ArrayList<HomeCategory> homeCategories) {
        this.context = context;
        this.homeCategories = homeCategories;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_category_sample , parent , false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        HomeCategory homeCategory = homeCategories.get(position);

        holder.binding.igSampleHomeCat.setImageResource(homeCategory.getCat_Img());
        holder.binding.txSampleHomeCat.setText(homeCategory.getCat_Name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth)
                        .replace(R.id.frMainContainer , new HomeCatShowFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeCategories.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        HomeCategorySampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = HomeCategorySampleBinding.bind(itemView);

        }
    }
}