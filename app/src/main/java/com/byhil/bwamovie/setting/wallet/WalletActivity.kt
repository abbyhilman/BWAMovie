package com.byhil.bwamovie.setting.wallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.byhil.bwamovie.R
import com.byhil.bwamovie.setting.wallet.adapter.WalletAdapter
import com.byhil.bwamovie.setting.wallet.model.Wallet
import com.byhil.bwamovie.utils.Preferences
import kotlinx.android.synthetic.main.activity_my_wallet.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList


class WalletActivity : AppCompatActivity() {

    private var dataList = ArrayList<Wallet>()
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_wallet)

        dataList.add(
                Wallet(
                        "Avengers Returns",
                        "Sabtu, 12 Jan 2020",
                        70000.0,
                        "0"
                )
        )

        dataList.add(
                Wallet(
                        "Top up",
                        "Sabtu, 12 Jan 2020",
                        170000.0,
                        "1"
                )
        )

        dataList.add(
                Wallet(
                        "Avengers Returns",
                        "Sabtu, 12 Jan 2020",
                        70000.0,
                        "0"
                )
        )

        rc_history.layoutManager = LinearLayoutManager(this)
        rc_history.adapter = WalletAdapter(dataList){

        }
        preferences = Preferences(this)

        val localID = Locale("id", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localID)
        tv_saldo.setText(formatRupiah.format(preferences.getValues("saldo")!!.toDouble()))

        btn_top_up.setOnClickListener {
            startActivity(Intent(this, WalletTopUpActivity::class.java))
        }

    }
}