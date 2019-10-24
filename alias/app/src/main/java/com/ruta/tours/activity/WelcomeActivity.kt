package com.ruta.tours.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.ruta.tours.R
import com.ruta.tours.entity.ImageModel
import java.util.*
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    private var imageModelArrayList: ArrayList<ImageModel> = ArrayList()

    private val myImageList = intArrayOf(
        R.drawable.slider1, R.drawable.slider2, R.drawable.slider3,
        R.drawable.slider4, R.drawable.slider5, R.drawable.slider6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        imageModelArrayList = populateList()

        init()

        btnContinuar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    // populate arraylist
    private fun populateList(): ArrayList<ImageModel> {
        val list = ArrayList<ImageModel>()

        for (element in myImageList) {
            list.add(ImageModel(element))
        }

        return list
    }

    private fun init() {
        viewPager.adapter = SlidingImage_Adapter(this, this.imageModelArrayList)
        indicator.setViewPager(viewPager)

        val density = resources.displayMetrics.density

        //Set circle indicator radius
        indicator.radius = 5 * density

        var currentPage = 0
        // Auto start of viewpager
        val handler = Handler()
        val updateRunnable = Runnable {
            if (currentPage == imageModelArrayList.size) {
                currentPage = 0
            }
            viewPager.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(updateRunnable)
            }
        }, 3000, 3000)

        // Pager listener over indicator
        indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                currentPage = position
            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {
                //Do nothing
            }

            override fun onPageScrollStateChanged(pos: Int) {
                //Do nothing
            }
        })
    }
}
