package com.yunuscagliyan.turingtodo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.yunuscagliyan.turingtodo.R;
import com.yunuscagliyan.turingtodo.databinding.SlideBackgroundBinding;

import de.hdodenhof.circleimageview.CircleImageView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public int[] slideImages={
            R.drawable.first_slide,
            R.drawable.secondi_slide,
            R.drawable.last_slide

    };
    public String[] slideTitle;
    public String[] slideDescription;

    public SliderAdapter(Context context) {
        this.context = context;
        layoutInflater= LayoutInflater.from(context);
        slideTitle=context.getResources().getStringArray(R.array.onBoardingPagerTitle);
        slideDescription=context.getResources().getStringArray(R.array.onBoardingPagerDescription);
    }

    @Override
    public int getCount() {
        return slideImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((ConstraintLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        SlideBackgroundBinding binding= DataBindingUtil.inflate(layoutInflater,R.layout.slide_background,container,false);


        Glide.with(context).load(slideImages[position]).into(binding.slideImageView);
        binding.tvSlideTitle.setText(slideTitle[position]);
        binding.tvSlideText.setText(slideDescription[position]);
        container.addView(binding.getRoot());
        binding.executePendingBindings();

        return binding.getRoot();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
