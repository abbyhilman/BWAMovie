package com.byhil.bwamovie.OnBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.byhil.bwamovie.R
import com.byhil.bwamovie.sign.signin.SignInActivity

class OnboardingThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_three)
        var btn_home = findViewById<Button>(R.id.btn_simpan)
        btn_home.setOnClickListener {
            finishAffinity()
            var intent = Intent (this@OnboardingThreeActivity, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}