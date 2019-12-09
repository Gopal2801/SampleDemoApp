package com.example.sampledemoapp.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.sampledemoapp.R;

public class Helper {

    public static void loadImage(Context aContext, String aImgUrl, ImageView aTargetIM) {
        Glide.with(aContext)
                .load(aImgUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(aTargetIM);
    }
}
