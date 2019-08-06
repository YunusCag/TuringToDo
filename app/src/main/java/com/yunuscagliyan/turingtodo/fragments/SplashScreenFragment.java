package com.yunuscagliyan.turingtodo.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.yunuscagliyan.turingtodo.R;
import com.yunuscagliyan.turingtodo.dataEvent.DataTransfer;
import com.yunuscagliyan.turingtodo.databinding.FragmentSplashScreenBinding;

import org.greenrobot.eventbus.EventBus;


public class SplashScreenFragment extends Fragment {

    private static final int SPLASH_TIME_OUT=4000;

    FragmentSplashScreenBinding splashScreenBinding;
    public SplashScreenFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        splashScreenBinding=FragmentSplashScreenBinding.inflate(inflater);

        createAnimation();


        return splashScreenBinding.getRoot();
    }

    private void createAnimation() {
        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.splash_transfer_anim);
        splashScreenBinding.ivAppIcon.startAnimation(animation);

        sendDataToWelcome();
    }

    private void sendDataToWelcome() {
        EventBus.getDefault().post(new DataTransfer.SplashHomeFragment(SPLASH_TIME_OUT));
    }
    
}
