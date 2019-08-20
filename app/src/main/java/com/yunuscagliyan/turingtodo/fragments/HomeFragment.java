package com.yunuscagliyan.turingtodo.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yunuscagliyan.turingtodo.R;
import com.yunuscagliyan.turingtodo.databinding.FragmentHomeBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    FragmentHomeBinding homeBinding;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    public HomeFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        homeBinding=FragmentHomeBinding.inflate(inflater);
        drawerLayout=homeBinding.drawerLayout;
        toolbar=homeBinding.homeToolbar;
        init();


        return homeBinding.getRoot();
    }

    public void init(){
        homeBinding.bottomNav.setOnNavigationItemSelectedListener(this);
        homeBinding.homeToolbar.setNavigationIcon(R.drawable.ic_menu);

        toggle=new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.back,R.string.back);
        drawerLayout.addDrawerListener(toggle);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment=null;
        String fragmentTag="";
        switch (menuItem.getItemId()){
            case R.id.dashboard:
                fragment=new DashBoardFragment();
                fragmentTag="fragment_dashboard";
                break;
            case R.id.calendar:
                fragment=new CalendarFragment();
                fragmentTag="fragment_calendar";
                break;
            case R.id.setting:
                fragment=new SettingFragment();
                fragmentTag="fragment_setting";
                break;
                default:
                    fragment=new DashBoardFragment();
                    fragmentTag="fragment_dashboard";
        }
        if (fragment!=null){
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.homeContainer,fragment,fragmentTag)
                    .commit();
            return true;
        }


        return false;
    }
}
