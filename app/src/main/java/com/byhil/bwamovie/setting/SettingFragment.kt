package com.byhil.bwamovie.setting

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.byhil.bwamovie.R
import com.byhil.bwamovie.setting.editprofile.EditProfileActivity
import com.byhil.bwamovie.setting.wallet.WalletActivity
import com.byhil.bwamovie.utils.Preferences
import kotlinx.android.synthetic.main.fragment_setting.*


/**
 * A simple [Fragment] subclass.
 * Use the [SettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingFragment : Fragment() {

    lateinit var preferences: Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preferences = Preferences(context!!)

        tv_nama.setText(preferences.getValues("nama"))
        tv_email.setText(preferences.getValues("email"))

        Glide.with(this)
            .load(preferences.getValues("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(iv_profile)

        tv_wallet.setOnClickListener {
            var intent = Intent(context, WalletActivity::class.java)
            startActivity(intent)
        }
        tv_profile.setOnClickListener {
            var intent = Intent(context, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }

}