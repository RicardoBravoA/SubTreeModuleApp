package com.ruta.tours.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ruta.tours.R

import kotlinx.android.synthetic.main.activity_help.*

class HelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        setSupportActionBar(toolbar)

    }

}
