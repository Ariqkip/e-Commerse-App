package com.deveric

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.deveric.Services.SharedPreference
import com.deveric.esales.Login
import com.deveric.esales.Products_Home
import com.deveric.esales.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spalsh_screen)

        val sp = SharedPreference(this)

        FirebaseApp.initializeApp(this)
        val auth = Firebase.auth
        val user_email = auth.currentUser?.email

        Log.e("User", user_email.toString())

        Handler(Looper.getMainLooper()).postDelayed({
            var isLoggedIn = sp.getPreference("isLoggedIn")
            if(isLoggedIn == "true"){
                if(user_email == null){
                    sp.setPreference("isLoggedIn", "false")
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    val intent = Intent(this, Products_Home::class.java)
                    startActivity(intent)
                    finish()
                }
            } else {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}