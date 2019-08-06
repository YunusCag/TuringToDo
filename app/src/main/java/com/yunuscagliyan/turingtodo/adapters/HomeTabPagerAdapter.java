package com.yunuscagliyan.turingtodo.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeTabPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> listFragment;
    List<String> listPageTitle;
    public HomeTabPagerAdapter(@NonNull FragmentManager fm,List<Fragment> listFragment,List<String> pageTitle) {
        super(fm);
        this.listFragment=listFragment;
        this.listPageTitle=pageTitle;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

}
