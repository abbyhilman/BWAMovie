package com.byhil.bwamovie.setting.wallet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.byhil.bwamovie.R
import com.byhil.bwamovie.home.HomeActivity
import com.byhil.bwamovie.home.tiket.TiketActivity
import com.byhil.bwamovie.sign.signin.User
import com.byhil.bwamovie.utils.Preferences
import kotlinx.android.synthetic.main.activity_wallet_success.*

class WalletSuccessActivity : AppCompatActivity() {
    lateinit var user : User
    private lateinit var preferences: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet_success)

        preferences = Preferences(this)

        Log.v("tamvan", "data :  " + intent.getParcelableExtra("data"))

        user = intent.getParcelableExtra("data")!!

        btn_lihat.setOnClickListener {
            finishAffinity()

            startActivity(Intent(this, WalletActivity::class.java).putExtra("data", user))
        }

        btn_beranda.setOnClickListener {
            finishAffinity()

            startActivity(Intent(this, HomeActivity::class.java).putExtra("data", user))
        }

    }


}