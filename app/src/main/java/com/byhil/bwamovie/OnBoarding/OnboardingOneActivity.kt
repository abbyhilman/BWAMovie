package com.byhil.bwamovie.OnBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.byhil.bwamovie.R
import com.byhil.bwamovie.sign.signin.SignInActivity
import com.byhil.bwamovie.utils.Preferences

class OnboardingOneActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)

        preferences = Preferences(this)

        var btn_daftar = findViewById<Button>(R.id.btn_daftar)
        var btn_home = findViewById<Button>(R.id.btn_simpan)

        if (preferences.getValues("onboarding").equals("1")){
            finishAffinity()

            var intent = Intent (this@OnboardingOneActivity, SignInActivity::class.java)
            startActivity(intent)
        }

        btn_daftar.setOnClickListener {
            var intent = Intent (this@OnboardingOneActivity, OnboardingTwoActivity::class.java)
            startActivity(intent)
        }

        btn_home.setOnClickListener {
            preferences.setValues("onboarding", "1")
            var intent = Intent (this@OnboardingOneActivity, SignInActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}