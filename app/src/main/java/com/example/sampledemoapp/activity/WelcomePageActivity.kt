package com.example.sampledemoapp.activity

import android.content.Intent
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sampledemoapp.R
import kotlinx.android.synthetic.main.welcome_page_activiity.*


class WelcomePageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_page_activiity)
        //welcom_txt.typeface = Helper.setFontStyle(this)
        //onboard_txt.typeface = Helper.setFontStyle(this)
        toSetTextStyle()


        login_TXT.setOnClickListener {

            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        signup_BTN.setOnClickListener {

            val intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun toSetTextStyle() {
        val typeface = Typeface.createFromAsset(applicationContext.assets, "fonts/PlayfairDisplay-Regular.otf")
        welcom_txt.typeface = typeface;
        onboard_txt.typeface = typeface;
        content_txt.typeface = typeface;
        login_TXT.typeface = typeface;
        acc_txt.typeface = typeface;
        login_TXT.typeface = typeface;
        login_TXT.setPaintFlags(login_TXT.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
    }
}