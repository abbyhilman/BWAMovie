package com.byhil.bwamovie.setting.wallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.byhil.bwamovie.R
import com.byhil.bwamovie.setting.wallet.adapter.WalletAdapter
import com.byhil.bwamovie.setting.wallet.model.Wallet
import com.byhil.bwamovie.sign.signin.User
import com.byhil.bwamovie.utils.Preferences
import kotlinx.android.synthetic.main.activity_my_wallet.*
import kotlinx.android.synthetic.main.activity_my_wallet.tv_saldo
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList


class WalletActivity : AppCompatActivity() {

    private var dataList = ArrayList<Wallet>()
    lateinit var preferences: Preferences
    lateinit var user : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_wallet)

        preferences = Preferences(this)
        user = intent.getParcelableExtra("data")!!

        loadDummyData()

    }

    private fun initListener() {
        rc_history.layoutManager = LinearLayoutManager(this)
        rc_history.adapter = WalletAdapter(dataList){

        }

        if (preferences.getValues("saldo").equals("")){
            tv_saldo.setText("Saldo Anda kosong")
        } else {
            val localeID = Locale("in", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
            tv_saldo.text = formatRupiah.format(preferences.getValues("saldo")!!.toDouble())
        }


        btn_top_up.setOnClickListener {
            startActivity(Intent(this, WalletTopUpActivity::class.java).putExtra("data", user))
        }
    }



    private fun loadDummyData() {
        dataList.add(
                Wallet(
                        "Avengers Returns",
                        "Sabtu 12 Jan, 2020",
                        700000.0,
                        "0"
                )
        )
        dataList.add(
                Wallet(
                        "Top Up",
                        "Sabtu 12 Jan, 2020",
                        1700000.0,
                        "1"
                )
        )
        dataList.add(
                Wallet(
                        "Avengers Returns",
                        "Sabtu 12 Jan, 2020",
                        700000.0,
                        "0"
                )
        )

        initListener()
    }
}