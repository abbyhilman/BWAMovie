package com.byhil.bwamovie.setting.wallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.byhil.bwamovie.R
import kotlinx.android.synthetic.main.activity_wallet_top_up.*

class WalletTopUpActivity : AppCompatActivity() {

    private var status10K:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet_top_up)

        btn_top_up.setOnClickListener {
            startActivity(Intent(this, WalletSuccessActivity::class.java))
        }

        tv_10k.setOnClickListener {
            if (status10K){
                unselectMoney(tv_10k)
            } else {
                selectMoney(tv_10k)
            }
        }
    }

    private fun selectMoney(textView: TextView){
        textView.setTextColor(resources.getColor(R.color.colorPink))
        textView.setBackgroundResource(R.drawable.shape_line_pink)
        status10K = true
        btn_top_up.visibility = View.VISIBLE
    }

    private fun unselectMoney(textView: TextView){
        textView.setTextColor(resources.getColor(R.color.colorWhiteGrey))
        textView.setBackgroundResource(R.drawable.shape_line_white)
        status10K = false
        btn_top_up.visibility = View.INVISIBLE
    }
}