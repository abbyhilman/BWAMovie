package com.byhil.bwamovie.home.tiket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.byhil.bwamovie.R
import com.byhil.bwamovie.checkout.CheckoutAdapter
import com.byhil.bwamovie.model.Checkout
import com.byhil.bwamovie.model.Film
import com.byhil.bwamovie.utils.Preferences
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.activity_tiket.*
import kotlinx.android.synthetic.main.activity_tiket.rc_checkout

class TiketActivity : AppCompatActivity() {

    private var dataList = ArrayList<Checkout>()
    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiket)

        preferences = Preferences(this)
        //dataList = intent.getSerializableExtra("data") as ArrayList<Checkout>
        var data = intent.getParcelableExtra<Film>("data")
        //var datas = intent.getParcelableExtra<Film>("datas")

        tv_title.text = data?.judul
        tv_genre.text = data?.genre
        tv_rate.text = data?.rating

        Glide.with(this)
                .load(data?.poster)
                .into(iv_poster_image)

//        tv_title.text = datas?.judul
//        tv_genre.text = datas?.genre
//        tv_rate.text = datas?.rating
//
//        Glide.with(this)
//                .load(datas?.poster)
//                .into(iv_poster_image)


        rc_checkout.layoutManager = LinearLayoutManager(this)
        dataList.add(Checkout("C1", ""))
        dataList.add(Checkout("C2", ""))

        rc_checkout.adapter = TiketAdapter(dataList){

        }
    }
}