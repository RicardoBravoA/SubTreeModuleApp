package com.rba.mylibrary

interface TimerInterface {
    fun onTimerDown(milliseconds: Long)
    fun onTimerFinish()
}