package com.ruta.tours.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ruta.tours.R

class PasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
    }

    fun onLogin(view : View){
        val intent = Intent(this, LoginActivity:: class.java)
        startActivity(intent)
    }
}
