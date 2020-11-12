package com.byhil.bwamovie.setting.editprofile


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.byhil.bwamovie.R
import com.byhil.bwamovie.utils.Preferences
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        preferences = Preferences(this)

        et_username.setText(preferences.getValues("user"))
        et_password.setText(preferences.getValues("pass"))
        et_nama.setText(preferences.getValues("nama"))
        et_email.setText(preferences.getValues("email"))

        Glide.with(this)
            .load(preferences.getValues("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(iv_profile)
    }

}