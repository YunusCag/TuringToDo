package com.yunuscagliyan.turingtodo.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yunuscagliyan.turingtodo.R;
import com.yunuscagliyan.turingtodo.adapters.SliderAdapter;
import com.yunuscagliyan.turingtodo.dataEvent.DataTransfer;
import com.yunuscagliyan.turingtodo.databinding.FragmentBoardingFragmentsBinding;

import org.greenrobot.eventbus.EventBus;


public class BoardingFragments extends Fragment {
    private static final int SPLASH_TIME_OUT=4000;

    FragmentBoardingFragmentsBinding boardingFragmentsBinding;
    SliderAdapter sliderAdapter;
    TextView[] mDots;
    private int mCurrentPageIndicator=-1;
    public BoardingFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boardingFragmentsBinding=FragmentBoardingFragmentsBinding.inflate(inflater);

        sliderAdapter=new SliderAdapter(getContext());
        boardingFragmentsBinding.slideViewPager.setAdapter(sliderAdapter);
        boardingFragmentsBinding.slideViewPager.addOnPageChangeListener(viewPagerListener);
        addDotsIndicator(0);
        addClickListener();


        return boardingFragmentsBinding.getRoot();

    }

    private void addClickListener() {
        boardingFragmentsBinding.btnBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentPageIndicator>-1&&mCurrentPageIndicator<mDots.length){
                    boardingFragmentsBinding.slideViewPager.setCurrentItem(mCurrentPageIndicator-1);
                }
            }
        });
        boardingFragmentsBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DataTransfer.BoardingSplashFragment(true,SPLASH_TIME_OUT));
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots =new TextView[3];
        boardingFragmentsBinding.dotsLayout.removeAllViews();
        for (int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(getContext());
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            boardingFragmentsBinding.dotsLayout.addView(mDots[i]);

        }
        if(position>-1&&mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }
    ViewPager.OnPageChangeListener viewPagerListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPageIndicator=position;

            if(position==0){
                boardingFragmentsBinding.btnBefore.setVisibility(View.INVISIBLE);
                boardingFragmentsBinding.btnNext.setVisibility(View.INVISIBLE);
            }else if(position==mDots.length){
                boardingFragmentsBinding.btnBefore.setVisibility(View.VISIBLE);
                boardingFragmentsBinding.btnNext.setVisibility(View.INVISIBLE);
            }else if(position==mDots.length-1){
                boardingFragmentsBinding.btnNext.setVisibility(View.VISIBLE);
            }else {
                boardingFragmentsBinding.btnBefore.setVisibility(View.VISIBLE);
                boardingFragmentsBinding.btnNext.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
