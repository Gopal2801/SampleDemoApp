package com.example.sampledemoapp.utils

import android.content.Context
import android.graphics.Typeface

class Utils {

    fun setFontStyle(aContext: Context): Typeface? {
        return Typeface.createFromAsset(aContext.assets, "fonts/Roboto-Medium.ttf")
    }

}