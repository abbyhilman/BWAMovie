package com.byhil.bwamovie.home

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.byhil.bwamovie.R
import com.byhil.bwamovie.home.dashboard.DashboardFragment
import com.byhil.bwamovie.home.tiket.TiketFragment
import com.byhil.bwamovie.setting.SettingFragment
import com.byhil.bwamovie.sign.signin.User
import com.byhil.bwamovie.utils.Preferences

class HomeActivity : AppCompatActivity() {
    lateinit var user : User
    private lateinit var preferences: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        preferences = Preferences(this)

        Log.v("tamvan", "data :  " + intent.getParcelableExtra("data"))

        user = intent.getParcelableExtra("data")!!


        var iv_menu1 = findViewById<ImageView>(R.id.iv_menu1)
        var iv_menu2 = findViewById<ImageView>(R.id.iv_menu2)
        var iv_menu3 = findViewById<ImageView>(R.id.iv_menu3)

        val fragmentHome = DashboardFragment()
        val fragmentTiket = TiketFragment()
        val fragmentSetting = SettingFragment()


        setFragment(fragmentHome)

        iv_menu1.setOnClickListener {
            setFragment(fragmentHome)

            changeIcon(iv_menu1, R.drawable.ic_home_active)
            changeIcon(iv_menu2, R.drawable.ic_tiket)
            changeIcon(iv_menu3, R.drawable.ic_profile)
        }

        iv_menu2.setOnClickListener {
            setFragment(fragmentTiket)

            changeIcon(iv_menu1, R.drawable.ic_home)
            changeIcon(iv_menu2, R.drawable.ic_tiket_active)
            changeIcon(iv_menu3, R.drawable.ic_profile)
        }

        iv_menu3.setOnClickListener {
            setFragment(fragmentSetting)
            changeIcon(iv_menu1, R.drawable.ic_home)
            changeIcon(iv_menu2, R.drawable.ic_tiket)
            changeIcon(iv_menu3, R.drawable.ic_profile_active)
        }

    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putParcelable("data", user)
        fragment.setArguments(bundle)
        fragmentTransaction.replace(R.id.layout_frame, fragment)
        fragmentTransaction.commit()
    }

    private fun changeIcon(imageView: ImageView, int: Int){
        imageView.setImageResource(int)
    }
}