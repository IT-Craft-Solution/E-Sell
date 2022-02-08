package com.itcraftsolution.esell.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.itcraftsolution.esell.Fragment.ActiveOrdersFragment;
import com.itcraftsolution.esell.Fragment.ExpireOrdersFragment;

public class AccMyorderViewPagerAdapter extends FragmentStateAdapter {

    private String[] titles = new String[]{"Active","Expire"};

    public AccMyorderViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new ActiveOrdersFragment();
            case 1:
                return new ExpireOrdersFragment();
        }
        return new ActiveOrdersFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
