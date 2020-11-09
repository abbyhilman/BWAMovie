package com.byhil.bwamovie.checkout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.byhil.bwamovie.R
import com.byhil.bwamovie.home.HomeActivity
import com.byhil.bwamovie.home.tiket.TiketActivity
import com.byhil.bwamovie.model.Checkout
import com.byhil.bwamovie.model.Film
import com.byhil.bwamovie.utils.Preferences
import kotlinx.android.synthetic.main.activity_checkout_success.*

class CheckoutSuccessActivity : AppCompatActivity() {

    private lateinit var preferences: Preferences
    private var dataList = ArrayList<Checkout>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_success)

        preferences = Preferences(this)
        dataList = intent.getSerializableExtra("data") as ArrayList<Checkout>
        val data = intent.getParcelableExtra<Film>("datas")

        btn_simpan.setOnClickListener {
            finishAffinity()

            val intent = Intent(this, TiketActivity::class.java).putExtra("data", dataList).putExtra("datas", data)
            startActivity(intent)
        }

        btn_beranda.setOnClickListener {
            finishAffinity()

            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }


}