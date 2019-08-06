package com.yunuscagliyan.turingtodo;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.yunuscagliyan.turingtodo.databinding.ActivityHomeBinding;
import com.yunuscagliyan.turingtodo.fragments.HomeFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.View;

import maes.tech.intentanim.CustomIntent;

public class HomeActivity extends AppCompatActivity {


    ActivityHomeBinding homeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding= DataBindingUtil.setContentView(this,R.layout.activity_home);

        CustomIntent.customType(HomeActivity.this,"fadein-to-fadeout");

        showHomeFragment();


    }

    private void showHomeFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(homeBinding.container.getId(),new HomeFragment()).commit();
    }

}
