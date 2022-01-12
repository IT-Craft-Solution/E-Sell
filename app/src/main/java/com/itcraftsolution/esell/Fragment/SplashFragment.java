package com.itcraftsolution.esell.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.itcraftsolution.esell.R;
import com.itcraftsolution.esell.databinding.FragmentSplashBinding;


public class SplashFragment extends Fragment {


    public SplashFragment() {
        // Required empty public constructor
    }

    private FragmentSplashBinding binding;
    private Animation topAnim, bottomAnim;
    private static int SPLASH_SCREEN = 2000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(getLayoutInflater());


        topAnim = AnimationUtils.loadAnimation(getContext(), R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bottom_animation);
        initViewsAndListener();
        return binding.getRoot();
    }

    private void initViewsAndListener() {
        binding.igSplashLogo.setAnimation(topAnim);
        binding.tvSlogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frUserDetailsContainer, new login());
                fragmentTransaction.commit();
            }
        }, SPLASH_SCREEN);
    }
}