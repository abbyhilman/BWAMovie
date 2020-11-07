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

        Glide.with(this)
            .load(preferences.getValues("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(iv_profile)
    }

//    private fun saveData(sUsername: String, sPassword: String, sNama: String, sEmail: String) {
//            var user = User()
//            user.email = sEmail
//            user.username = sUsername
//            user.nama = sNama
//            user.password = sPassword
//
//            if (sUsername != null) {
//                checkingUsername(sUsername, user)
//            }
//    }

//    private fun checkingUsername(sUsername: String, data: User) {
//        mDatabaseReference.child(sUsername).addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                var user = dataSnapshot.getValue(User::class.java)
//                if (user == null) {
//                    mDatabaseReference.child(sUsername).setValue(data)
//
//                    var goSigUpPhotoscreen = Intent(this@EditProfileActivity,
//                        SignUpPhotoscreenActivity::class.java).putExtra("nama", data.nama)
//                    startActivity(goSigUpPhotoscreen)
//
//                } else {
//                    Toast.makeText(this@EditProfileActivity, "User sudah digunakan", Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                Toast.makeText(this@EditProfileActivity, ""+databaseError.message, Toast.LENGTH_LONG).show()
//            }
//
//        })
//    }
}