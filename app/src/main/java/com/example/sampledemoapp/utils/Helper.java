package com.example.sampledemoapp.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.sampledemoapp.R;

public class Helper {

    public static void loadImage(Context aContext, String aImgUrl, ImageView aTargetIM) {
        /*Glide.with(aContext)
                .load(aImgUrl).centerCrop()
                .placeholder(R.drawable.shadow)
                .error(R.drawable.shadow)
                .into(aTargetIM);*/

        Glide.with(aContext)
                .load(aImgUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.shadow)
                .into(aTargetIM);
    }
}
