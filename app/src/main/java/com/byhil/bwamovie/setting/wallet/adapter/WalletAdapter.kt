package com.byhil.bwamovie.setting.wallet.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.byhil.bwamovie.R
import com.byhil.bwamovie.setting.wallet.model.Wallet
import java.text.NumberFormat
import java.util.*

class WalletAdapter(private var data: List<Wallet>,
                    private val listener:(Wallet)-> Unit)
    : RecyclerView.Adapter<WalletAdapter.ViewHolder>() {

    lateinit var contextAdapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): WalletAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView = layoutInflater.inflate(R.layout.row_item_transaksi, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position], listener, contextAdapter)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle = view.findViewById<TextView>(R.id.tv_movie)
        private val tvDate = view.findViewById<TextView>(R.id.tv_date)
        private val tvMoney = view.findViewById<TextView>(R.id.tv_money)

        fun bindItem(data: Wallet, listener: (Wallet) -> Unit, context: Context) {
            tvTitle.text = data.title
            tvDate.text = data.date

            val localID = Locale("id", "ID")
            val formatRupiah = NumberFormat.getCurrencyInstance(localID)

            if(data.status.equals("0")){
                tvMoney.text = "- "+formatRupiah.format(data.money)
            } else {
                tvMoney.text = "+ "+formatRupiah.format(data.money)
                tvMoney.setTextColor(Color.GREEN)
            }

            //tvMoney.setText(formatRupiah.format(data.money!!.toDouble()))

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }



}
