package com.yunuscagliyan.turingtodo.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunuscagliyan.turingtodo.R;
import com.yunuscagliyan.turingtodo.databinding.FragmentDashBoardBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {


    FragmentDashBoardBinding dashBoardBinding;
    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        dashBoardBinding=FragmentDashBoardBinding.inflate(inflater);

        return dashBoardBinding.getRoot();
    }

}
