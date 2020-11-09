package com.byhil.bwamovie.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.byhil.bwamovie.R
import com.byhil.bwamovie.model.Checkout
import com.byhil.bwamovie.model.Film
import kotlinx.android.synthetic.main.activity_detail.tv_kursi
import kotlinx.android.synthetic.main.activity_pilih_bangku.*

class PilihBangkuActivity : AppCompatActivity() {

    var statusA1:Boolean = false
    var statusA2:Boolean = false
    var statusA3:Boolean = false
    var statusA4:Boolean = false
    var statusB1:Boolean = false
    var statusB2:Boolean = false
    var statusB3:Boolean = false
    var statusB4:Boolean = false
    var total:Int = 0

    private  var dataList = ArrayList<Checkout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_bangku)

        val data = intent.getParcelableExtra<Film>("data")
        tv_kursi.text = data?.judul

        a1.setOnClickListener {
            if (statusA1){
                a1.setImageResource(R.drawable.ic_rectangle_20)
                statusA1 = false
                total -= 1
                beliTiket(total)
            } else {
                a1.setImageResource(R.drawable.ic_rectangle_22)
                statusA1 = true
                total += 1
                beliTiket(total)

                val data = Checkout("A1", "70000")
                dataList.add(data)
            }
        }

        a2.setOnClickListener {
            if (statusA2){
                a2.setImageResource(R.drawable.ic_rectangle_20)
                statusA2 = false
                total -= 1
                beliTiket(total)
            } else {
                a2.setImageResource(R.drawable.ic_rectangle_22)
                statusA2 = true
                total += 1
                beliTiket(total)

                val data = Checkout("A2", "70000")
                dataList.add(data)
            }
        }

        a3.setOnClickListener {
            if (statusA3){
                a3.setImageResource(R.drawable.ic_rectangle_20)
                statusA3 = false
                total -= 1
                beliTiket(total)
            } else {
                a3.setImageResource(R.drawable.ic_rectangle_22)
                statusA3 = true
                total += 1
                beliTiket(total)

                val data = Checkout("A3", "70000")
                dataList.add(data)
            }
        }

        a4.setOnClickListener {
            if (statusA4){
                a4.setImageResource(R.drawable.ic_rectangle_20)
                statusA4 = false
                total -= 1
                beliTiket(total)
            } else {
                a4.setImageResource(R.drawable.ic_rectangle_22)
                statusA4 = true
                total += 1
                beliTiket(total)

                val data = Checkout("A4", "70000")
                dataList.add(data)
            }
        }

        b1.setOnClickListener {
            if (statusB1){
                a3.setImageResource(R.drawable.ic_rectangle_20)
                statusB1 = false
                total -= 1
                beliTiket(total)
            } else {
                b1.setImageResource(R.drawable.ic_rectangle_22)
                statusB1 = true
                total += 1
                beliTiket(total)

                val data = Checkout("B1", "50000")
                dataList.add(data)
            }
        }

        b2.setOnClickListener {
            if (statusB2){
                b2.setImageResource(R.drawable.ic_rectangle_20)
                statusB2 = false
                total -= 1
                beliTiket(total)
            } else {
                b2.setImageResource(R.drawable.ic_rectangle_22)
                statusB2 = true
                total += 1
                beliTiket(total)

                val data = Checkout("B2", "50000")
                dataList.add(data)
            }
        }

        b3.setOnClickListener {
            if (statusB3){
                b3.setImageResource(R.drawable.ic_rectangle_20)
                statusB3 = false
                total -= 1
                beliTiket(total)
            } else {
                b3.setImageResource(R.drawable.ic_rectangle_22)
                statusB3 = true
                total += 1
                beliTiket(total)

                val data = Checkout("B3", "50000")
                dataList.add(data)
            }
        }

        b4.setOnClickListener {
            if (statusB4){
                b4.setImageResource(R.drawable.ic_rectangle_20)
                statusB4 = false
                total -= 1
                beliTiket(total)
            } else {
                b4.setImageResource(R.drawable.ic_rectangle_22)
                statusB4 = true
                total += 1
                beliTiket(total)

                val data = Checkout("B4", "50000")
                dataList.add(data)
            }
        }

        btn_simpan.setOnClickListener {
            var intent = Intent(this, CheckoutActivity::class.java).putExtra("data", dataList).putExtra("datas", data)
            startActivity(intent)
        }
    }

    private fun beliTiket(total: Int) {
        if (total==0){
            btn_simpan.setText("Beli Tiket")
            btn_simpan.visibility = View.INVISIBLE
        } else {
            btn_simpan.setText("Beli Tiket ("+total+")")
            btn_simpan.visibility = View.VISIBLE
        }
    }
}