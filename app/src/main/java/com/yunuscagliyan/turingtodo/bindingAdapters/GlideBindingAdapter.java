package com.yunuscagliyan.turingtodo.bindingAdapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

public class GlideBindingAdapter {

    @BindingAdapter("showImage")
    public static void showImage(final ConstraintLayout constraintLayout, Drawable drawableId){
        //constraintLayout.setImageResource(drawableId);
        Glide.with(constraintLayout.getContext())
                .load(drawableId)
                .into(new CustomTarget<Drawable>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        constraintLayout.setBackground(resource);
                    }
                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                        constraintLayout.setBackground(placeholder);

                    }
                });
    }
    @BindingAdapter("showImage")
    public static void showImage(ImageView imageView,Drawable drawableId){
        //imageView.setImageResource(drawableId);
        Context mContext=imageView.getContext();
        Glide.with(mContext)
                .load(drawableId)
                .into(imageView);



    }
}
