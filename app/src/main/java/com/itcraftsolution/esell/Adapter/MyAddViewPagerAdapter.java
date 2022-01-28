package com.itcraftsolution.esell.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.itcraftsolution.esell.Fragment.ActiveOrdersFragment;
import com.itcraftsolution.esell.Fragment.AdsFragment;
import com.itcraftsolution.esell.Fragment.ExpireOrdersFragment;
import com.itcraftsolution.esell.Fragment.FavoriteFragment;

public class MyAddViewPagerAdapter extends FragmentStateAdapter {

    private String[] titles = new String[]{"MyAds","Favourite"};

    public MyAddViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new AdsFragment();
            case 1:
                return new FavoriteFragment();
        }
        return new AdsFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
