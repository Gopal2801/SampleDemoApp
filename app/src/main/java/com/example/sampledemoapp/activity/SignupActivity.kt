package com.example.sampledemoapp.activity

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sampledemoapp.R
import kotlinx.android.synthetic.main.sample_login.*
import kotlinx.android.synthetic.main.signup_activity.*
import kotlinx.android.synthetic.main.welcome_page_activiity.*
import kotlinx.android.synthetic.main.welcome_page_activiity.onboard_txt
import kotlinx.android.synthetic.main.welcome_page_activiity.welcom_txt

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)
        toSetTextStyle();
    }

    private fun toSetTextStyle() {
        val typeface = Typeface.createFromAsset(applicationContext.assets, "fonts/PlayfairDisplay-Regular.otf")
        welcom_txt.typeface = typeface;
        onboard_txt.typeface = typeface;
        // signup_btn.typeface = typeface;

    }

    override fun onBackPressed() {
        val intent = Intent(applicationContext, WelcomePageActivity::class.java)
        startActivity(intent)
        finish()
    }
}