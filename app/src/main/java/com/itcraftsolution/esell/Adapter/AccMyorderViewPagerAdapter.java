package com.itcraftsolution.esell.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.itcraftsolution.esell.Fragment.ActiveOrdersFragment;
import com.itcraftsolution.esell.Fragment.ExpireOrdersFragment;

public class AccMyorderViewPagerAdapter extends FragmentPagerAdapter {
    private static int Count = 2;
    public AccMyorderViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new ExpireOrdersFragment();

            default:
                return new ActiveOrdersFragment();
        }
    }

    @Override
    public int getCount() {
        return Count;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        if (position == 0) {
            title = "Active";
        } else if (position == 1) {
            title = "Expire";
        }

        return title;
    }
}
