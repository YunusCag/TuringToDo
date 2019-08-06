package com.yunuscagliyan.turingtodo.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunuscagliyan.turingtodo.R;
import com.yunuscagliyan.turingtodo.adapters.HomeTabPagerAdapter;
import com.yunuscagliyan.turingtodo.databinding.FragmentHomeBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    FragmentHomeBinding homeBinding;
    ArrayList<Fragment> listFragment;
    ArrayList<String> listPageTitle;
    HomeTabPagerAdapter tabPagerAdapter;

    public HomeFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        homeBinding=FragmentHomeBinding.inflate(inflater);
        init();
        setTaps();




        return homeBinding.getRoot();
    }

    private void setTaps() {
        homeBinding.tabLayout.getTabAt(0).setIcon(R.drawable.icon_home_rounded);
        homeBinding.tabLayout.getTabAt(1).setIcon(R.drawable.icon_calendar_rounded);
    }

    private void init() {
        listFragment=new ArrayList<>();
        listPageTitle=new ArrayList<>();

        setFragments(new DashBoardFragment(),"Home");
        setFragments(new CalendarFragment(),"Calendar");

        tabPagerAdapter=new HomeTabPagerAdapter(getFragmentManager(),listFragment,listPageTitle);
        homeBinding.homeViewPager.setAdapter(tabPagerAdapter);
        homeBinding.tabLayout.setupWithViewPager(homeBinding.homeViewPager);

    }

    public void setFragments(Fragment fragment,String title){
        listPageTitle.add(title);
        listFragment.add(fragment);

    }

}
