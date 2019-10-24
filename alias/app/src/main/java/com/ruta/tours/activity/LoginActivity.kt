package com.ruta.tours.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ruta.tours.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity:: class.java))
        }

        btnLogin.setOnClickListener {
            startActivity(Intent(this, PrincipalActivity:: class.java))
            finish()
        }

    }
}
