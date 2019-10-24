package com.rba.componentmodule1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rba.mylibrary.TimerInterface

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), TimerInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        tvData.setOnTimerListener(this)

    }

    override fun onTimerDown(milliseconds: Long) {

    }

    override fun onTimerFinish() {
        tvData.showLabelFinished()
    }

}
