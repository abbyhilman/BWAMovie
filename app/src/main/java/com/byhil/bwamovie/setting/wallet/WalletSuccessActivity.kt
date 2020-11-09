package com.byhil.bwamovie.setting.wallet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.byhil.bwamovie.R
import com.byhil.bwamovie.home.HomeActivity
import com.byhil.bwamovie.home.tiket.TiketActivity
import kotlinx.android.synthetic.main.activity_wallet_success.*

class WalletSuccessActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet_success)


        btn_lihat.setOnClickListener {

        }

        btn_beranda.setOnClickListener {
            finishAffinity()

            startActivity(Intent(this, HomeActivity::class.java))
        }

    }


}