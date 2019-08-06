package com.yunuscagliyan.turingtodo.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunuscagliyan.turingtodo.R;
import com.yunuscagliyan.turingtodo.databinding.FragmentCalendarBinding;

import java.util.Calendar;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {


    FragmentCalendarBinding calendarBinding;
    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        calendarBinding=FragmentCalendarBinding.inflate(inflater);

        init();
        return calendarBinding.getRoot();

    }

    private void init() {



    }

}
