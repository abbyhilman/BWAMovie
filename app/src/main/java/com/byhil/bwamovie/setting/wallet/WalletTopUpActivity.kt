package com.byhil.bwamovie.setting.wallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.byhil.bwamovie.R
import com.byhil.bwamovie.home.HomeActivity
import com.byhil.bwamovie.sign.signin.User
import com.byhil.bwamovie.utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_wallet_top_up.*
import kotlinx.android.synthetic.main.activity_wallet_top_up.btn_top_up
import kotlinx.android.synthetic.main.activity_wallet_top_up.tv_saldo
import java.lang.NumberFormatException
import java.text.NumberFormat
import java.util.*

class WalletTopUpActivity : AppCompatActivity() {

    private var status10K:Boolean = false
    private var status20K:Boolean = false
    private var status30K:Boolean = false
    private var status40K:Boolean = false
    private var status50K:Boolean = false
    private var status60K:Boolean = false
    lateinit var sWallet: String

    lateinit var preferences: Preferences
    lateinit var user : User
    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet_top_up)

        preferences = Preferences(this)
        mFirebaseInstance = FirebaseDatabase.getInstance()
        mFirebaseDatabase = mFirebaseInstance.getReference("User")

        Log.v("tamvan", "data :  " + intent.getParcelableExtra("data"))
        user = intent.getParcelableExtra("data")!!

        initListener()
    }

    private fun initListener() {
        btn_top_up.setOnClickListener {
            sWallet = et_amount.text.toString()

            if (sWallet.equals("")){
                et_amount.error = "Silahkan isi saldo anda"
                et_amount.requestFocus()
            } else {
                saveMoney(sWallet)
            }

        }

        tv_10k.setOnClickListener {
            if (status10K) {
                unselectMoney(tv_10k)
            } else {
                selectMoney(tv_10k)
            }
        }

        tv_20k.setOnClickListener {
            if (status20K){
                status20K = false
                btn_top_up.visibility = View.VISIBLE
                et_amount.setText("")
                tv_20k.setTextColor(resources.getColor(R.color.colorWhite))
                tv_20k.setBackgroundResource(R.drawable.shape_line_white)
            } else {
                status20K = true
                status10K = false
                status30K = false
                status40K = false
                status50K = false
                status60K = false
                btn_top_up.visibility = View.VISIBLE
                et_amount.setText("25000")
                tv_20k.setTextColor(resources.getColor(R.color.colorPink))
                tv_20k.setBackgroundResource(R.drawable.shape_line_pink)
            }
        }

        tv_30k.setOnClickListener {
            if (status30K){
                unselectMoney(tv_30k)
            } else {
                selectMoney(tv_30k)
            }
        }

        tv_40k.setOnClickListener {
            if (status40K){
                unselectMoney(tv_40k)
            } else {
                selectMoney(tv_40k)
            }
        }

        tv_50k.setOnClickListener {
            if (status50K){
                unselectMoney(tv_50k)
            } else {
                selectMoney(tv_50k)
            }
        }

        tv_60k.setOnClickListener {
            if (status60K){
                unselectMoney(tv_60k)
            } else {
                selectMoney(tv_60k)
            }
        }

        if (preferences.getValues("saldo").equals("")){
            tv_saldo.setText("Saldo Anda kosong")
        } else {
            val localeID = Locale("in", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
            tv_saldo.text = formatRupiah.format(preferences.getValues("saldo")!!.toDouble())
        }

        et_amount.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(
                    s: CharSequence,
                    start: Int,
                    before: Int,
                    count: Int
            ) { }

            override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
            ) {  }

            override fun afterTextChanged(s: Editable) {
                try {
                    if (s.toString().toInt() >= 10000) {
                        btn_top_up.visibility = View.VISIBLE
                    } else {
                        tv_10k.setTextColor(resources.getColor(R.color.colorWhite))
                        tv_10k.setBackgroundResource(R.drawable.shape_line_white)
                        status10K = false
                        btn_top_up.visibility = View.INVISIBLE
                    }
                } catch (e : NumberFormatException) {
                    tv_10k.setTextColor(resources.getColor(R.color.colorWhite))
                    tv_10k.setBackgroundResource(R.drawable.shape_line_white)
                    status10K = false
                    btn_top_up.visibility = View.INVISIBLE
                }
            }
        })
    }

    private fun saveMoney(sWallet: String) {

        mFirebaseDatabase.child(user.username!!).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                user.saldo = sWallet
                mFirebaseDatabase.child(user.username!!).setValue(user)

                preferences.setValues("nama", user.nama.toString())
                preferences.setValues("user", user.username.toString())
                preferences.setValues("pass", user.password.toString())
                preferences.setValues("saldo", user.saldo.toString())
                preferences.setValues("url", user.url.toString())
                preferences.setValues("email", user.email.toString())
                preferences.setValues("saldo", sWallet)

                finishAffinity()
                val intent = Intent(this@WalletTopUpActivity,
                        WalletSuccessActivity::class.java).putExtra("data", user)
                startActivity(intent)

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@WalletTopUpActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })

    }



    private fun selectMoney(textView: TextView){
        textView.setTextColor(resources.getColor(R.color.colorPink))
        textView.setBackgroundResource(R.drawable.shape_line_pink)
        status10K = true
        status30K = true
        status40K = true
        status50K = true
        status60K = true
        btn_top_up.visibility = View.VISIBLE
        et_amount.setText("10000")
    }

    private fun unselectMoney(textView: TextView){
        textView.setTextColor(resources.getColor(R.color.colorWhiteGrey))
        textView.setBackgroundResource(R.drawable.shape_line_white)
        status10K = false
        status30K = false
        status40K = false
        status50K = false
        status60K = false
        btn_top_up.visibility = View.INVISIBLE
        et_amount.setText("")
    }
}