package com.itcraftsolution.esell;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationBarView;
import com.itcraftsolution.esell.Fragment.AccountFragment;
import com.itcraftsolution.esell.Fragment.ChatFragment;
import com.itcraftsolution.esell.Fragment.FavoriteFragment;
import com.itcraftsolution.esell.Fragment.HomeCatShowFragment;
import com.itcraftsolution.esell.Fragment.HomeFragment;
import com.itcraftsolution.esell.Fragment.ItemDetailsFragment;
import com.itcraftsolution.esell.Fragment.MyAddFragment;
import com.itcraftsolution.esell.Fragment.SellFragment;
import com.itcraftsolution.esell.Fragment.SellItemFormFragment;
import com.itcraftsolution.esell.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

   
    private  ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        defView();
        binding.mainBottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId())
                {
                    case R.id.bNavHome:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.bNavChat:
                        selectedFragment = new ChatFragment();
                        break;
                    case R.id.bNavSell:
                        selectedFragment = new SellFragment();
                        break;
                    case R.id.bNavMyAds:
                        selectedFragment = new SellItemFormFragment();
                        break;
                    case R.id.bNavAccount:
                        selectedFragment = new AccountFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frMainContainer , selectedFragment).commit();
                return  true;
            }
        });
    }

    private void defView() {
          FragmentTransaction firstFragment = getSupportFragmentManager().beginTransaction();
            firstFragment.replace(R.id.frMainContainer, new HomeFragment());
            firstFragment.commit();
    }

    @Override
    public void onBackPressed() {
        if(binding.mainBottomNav.getSelectedItemId() == R.id.bNavHome)
        {
            super.onBackPressed();
//            finishAffinity();
        }
        else {
            binding.mainBottomNav.setSelectedItemId(R.id.bNavHome);
        }
    }
}