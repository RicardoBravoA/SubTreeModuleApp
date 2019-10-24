package com.rba.mylibrary.util

import android.content.Context
import com.rba.mylibrary.R


object Util {
    fun twoDigits(context: Context, number: Long): String {
        return if (number in 0..9) {
            context.getString(R.string.concat_number, number.toString())
        } else number.toString()

    }
}