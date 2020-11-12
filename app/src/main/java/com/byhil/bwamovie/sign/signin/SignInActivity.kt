package com.byhil.bwamovie.sign.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.byhil.bwamovie.home.HomeActivity
import com.byhil.bwamovie.R
import com.byhil.bwamovie.sign.signup.SignUpActivity
import com.byhil.bwamovie.utils.Preferences
import com.google.firebase.database.*


class SignInActivity : AppCompatActivity() {
    lateinit var iUsername:String
    lateinit var iPasword:String

    lateinit var mDatabase: DatabaseReference
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        var btn_home = findViewById<Button>(R.id.btn_simpan)
        var btn_daftar = findViewById<Button>(R.id.btn_daftar)
        var et_username = findViewById<EditText>(R.id.et_username)
        var et_password = findViewById<EditText>(R.id.et_password)

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferences = Preferences(this)


        preferences.setValues("onboarding", "1")
        if (preferences.getValues("status").equals("1")){
            finishAffinity()

            var goHome = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(goHome)
        }


        btn_home.setOnClickListener {
            iUsername = et_username.text.toString()
            iPasword = et_password.text.toString()

            if (iUsername.equals("")){
                et_username.error = "Silahkan tulis username anda"
                et_username.requestFocus()
            } else if (iPasword.equals("")){
                et_password.error = "Silahkan tulis password anda"
                et_password.requestFocus()
            } else {
                pushLogin(iUsername, iPasword)
            }
        }

        btn_daftar.setOnClickListener {
            var goSignUp = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(goSignUp)
        }

    }

    private fun pushLogin(iUsername: String, iPasword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var user = dataSnapshot.getValue(User::class.java)
                if (user == null){
                    Toast.makeText(this@SignInActivity, "User tidak ada",
                            Toast.LENGTH_LONG).show()
                } else {

                    if (user.password.equals(iPasword)){

                        preferences.setValues("nama", user.nama.toString())
                        preferences.setValues("user", user.username.toString())
                        preferences.setValues("pass", user.password.toString())
                        preferences.setValues("url", user.url.toString())
                        preferences.setValues("email", user.email.toString())
                        preferences.setValues("saldo", user.saldo.toString())
                        preferences.setValues("status", "1")


                        var intent = Intent(this@SignInActivity, HomeActivity::class.java).putExtra("data", user)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@SignInActivity, "Password Anda Salah",
                                Toast.LENGTH_LONG).show()
                    }


                }
            }

            override fun onCancelled(databaseError:  DatabaseError) {
                Toast.makeText(this@SignInActivity, databaseError.message,
                        Toast.LENGTH_LONG).show()
            }
        })
    }
}