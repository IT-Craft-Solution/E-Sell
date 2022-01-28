package com.itcraftsolution.esell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.itcraftsolution.esell.Fragment.HomeCatShowFragment;
import com.itcraftsolution.esell.Fragment.SplashFragment;
import com.itcraftsolution.esell.Fragment.UserProfileFragment;
import com.itcraftsolution.esell.Fragment.login;
import com.itcraftsolution.esell.Fragment.mapsAndLocation;

public class UserLogin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_rigth,R.anim.enter_from_rigth);
        fragmentTransaction.replace(R.id.frUserDetailsContainer , new SplashFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}

