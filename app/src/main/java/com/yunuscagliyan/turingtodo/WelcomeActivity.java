package com.yunuscagliyan.turingtodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.yunuscagliyan.turingtodo.asistants.TuringApp;
import com.yunuscagliyan.turingtodo.dataEvent.DataTransfer;
import com.yunuscagliyan.turingtodo.databinding.ActivityWelcomeBinding;
import com.yunuscagliyan.turingtodo.fragments.BoardingFragments;
import com.yunuscagliyan.turingtodo.fragments.SplashScreenFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import maes.tech.intentanim.CustomIntent;

public class WelcomeActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT=4000;
    ActivityWelcomeBinding welcomeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        welcomeBinding= DataBindingUtil.setContentView(this,R.layout.activity_welcome);
        showFirstTime();

    }

    private void showFirstTime() {
        boolean firstTime= TuringApp.readSharedFirstTime(this);
        if(firstTime){
            showOnBoardingFragment();
        }else {
            showSplashScreenFragment(SPLASH_TIME_OUT);
        }

    }

    public void showOnBoardingFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(welcomeBinding.mainContainer.getId(),new BoardingFragments(),"boarding_fragment").commit();
    }
    public void showSplashScreenFragment(final int duration){
        getSupportFragmentManager().beginTransaction()
                .replace(welcomeBinding.mainContainer.getId(),new SplashScreenFragment(),"splash_fragment").commit();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(duration);
                    TuringApp.writeSharedFirstTime(WelcomeActivity.this,false);
                    Intent intent=new Intent(WelcomeActivity.this,HomeActivity.class);
                    startActivity(intent);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

    @Subscribe
    public void onBoardingSplash(DataTransfer.BoardingSplashFragment boardingSplashFragment){
        if (boardingSplashFragment.isShowSplash()&&boardingSplashFragment.getSplashTimeOut()>0){
            showSplashScreenFragment(boardingSplashFragment.getSplashTimeOut());
        }
    }
    @Subscribe
    public void onSplashHome(DataTransfer.SplashHomeFragment splashHomeFragment){

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
