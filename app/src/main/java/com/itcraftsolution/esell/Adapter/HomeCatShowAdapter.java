package com.itcraftsolution.esell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.itcraftsolution.esell.Fragment.HomeCatShowFragment;
import com.itcraftsolution.esell.Fragment.ItemDetailsFragment;
import com.itcraftsolution.esell.Model.HomeCatShow;
import com.itcraftsolution.esell.Model.HomeFreshItem;
import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.HomeCatShowSampleBinding;
import com.itcraftsolution.esell.databinding.HomeFreshitemSampleBinding;

import java.util.ArrayList;

public class HomeCatShowAdapter extends RecyclerView.Adapter<HomeCatShowAdapter.viewHolder> {

    Context context;
    ArrayList<HomeCatShow> homeCatShows;

    public HomeCatShowAdapter(Context context, ArrayList<HomeCatShow> homeCatShows) {
        this.context = context;
        this.homeCatShows = homeCatShows;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_cat_show_sample , parent , false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        HomeCatShow homeCatShow = homeCatShows.get(position);

        holder.binding.igHomeCatShowImage.setImageResource(homeCatShow.getItemImage());
        holder.binding.txHomeCatDesc.setText(homeCatShow.getItemName());
        holder.binding.txHomeCatPrice.setText(homeCatShow.getItemPrice());
        holder.binding.txHomeCatItemLocation.setText(homeCatShow.getItemLocation());

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
        return homeCatShows.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        HomeCatShowSampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = HomeCatShowSampleBinding.bind(itemView);
        }
    }
}
