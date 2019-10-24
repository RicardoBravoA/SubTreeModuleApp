package com.rba.mylibrary

import android.content.Context
import android.os.CountDownTimer
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import com.rba.mylibrary.util.Util

class TimerView : LinearLayout {

    private var mHours: Long = 0
    private var mMinutes: Long = 0
    private var mSeconds: Long = 0
    private var mMilliSeconds: Long = 0
    private var mDays: Long = 0
    private var mListener: TimerInterface? = null
    private var mCountDownTimer: CountDownTimer? = null
    private var view: View? = null
    private var lblDay: AppCompatTextView? = null
    private var lblHour: AppCompatTextView? = null
    private var lblMinute: AppCompatTextView? = null
    private var lblSecond: AppCompatTextView? = null
    private var lblText: AppCompatTextView? = null
    private var linText: LinearLayout? = null
    private var linTime: LinearLayout? = null
    private var lblDayText: AppCompatTextView? = null
    private var lblHourText: AppCompatTextView? = null
    private var lblMinuteText: AppCompatTextView? = null
    private var lblSecondText: AppCompatTextView? = null
    private var showDisplay = false

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    fun setOnTimerListener(listener: TimerInterface) {
        mListener = listener
    }

    private fun init(attrs: AttributeSet) {

        view = View.inflate(context, R.layout.item_timer, this)

        lblDay = view?.findViewById(R.id.lblDay)
        lblHour = view?.findViewById(R.id.lblHour)
        lblMinute = view?.findViewById(R.id.lblMinute)
        lblSecond = view?.findViewById(R.id.lblSecond)
        lblText = view?.findViewById(R.id.lblText)
        lblDayText = view?.findViewById(R.id.lblDayText)
        lblHourText = view?.findViewById(R.id.lblHourText)
        lblMinuteText = view?.findViewById(R.id.lblMinuteText)
        lblSecondText = view?.findViewById(R.id.lblSecondText)
        linText = view?.findViewById(R.id.linText)
        linTime = view?.findViewById(R.id.linTime)

        val a = context!!.obtainStyledAttributes(attrs, R.styleable.TimerView, 0, 0)

        if (a != null) {

            showDisplay = a.getBoolean(R.styleable.TimerView_showDisplay, false)
            val milliStr = a.getString(R.styleable.TimerView_time)
            if (!TextUtils.isEmpty(milliStr) && TextUtils.isDigitsOnly(milliStr)) {
                mMilliSeconds = java.lang.Long.parseLong(a.getString(R.styleable.TimerView_time)!!)
                setTime(mMilliSeconds)
                //startCountDown();
            }

            a.recycle()
        }

        displayText()

    }

    private fun initCounter() {
        mCountDownTimer = object : CountDownTimer(mMilliSeconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                calculateTime(millisUntilFinished)
                if (mListener != null) {
                    mListener?.onTimerDown(millisUntilFinished)
                }
            }

            override fun onFinish() {
                calculateTime(0)
                if (mListener != null) {
                    mListener?.onTimerFinish()
                }
            }
        }
    }

    fun showLabelFinished() {
        showDisplay = false
        linText?.visibility = View.GONE
        linTime?.visibility = View.GONE
        lblText?.visibility = View.VISIBLE
        stopCountDown()
    }

    fun startCountDown() {
        if (mCountDownTimer != null) {
            mCountDownTimer?.start()
        }
    }

    fun stopCountDown() {
        if (mCountDownTimer != null) {
            mCountDownTimer?.cancel()
        }
    }

    fun setShowDisplay(state: Boolean) {
        showDisplay = state
    }

    fun setTime(milliSeconds: Long) {
        mMilliSeconds = milliSeconds
        initCounter()
        calculateTime(milliSeconds)
        startCountDown()
    }

    private fun calculateTime(milliSeconds: Long) {

        mSeconds = milliSeconds / 1000 % 60
        mMinutes = milliSeconds / (1000 * 60) % 60
        mHours = milliSeconds / (1000 * 60 * 60) % 24
        mDays = milliSeconds / (1000 * 60 * 60 * 24)

        displayText()
    }

    private fun displayText() {

        if (mDays == 0L && mSeconds == 0L && mHours == 0L && mMinutes == 0L) {
            linText?.visibility = View.GONE
            linTime?.visibility = View.GONE
            lblText?.visibility = View.VISIBLE
            showLabelFinished()
        } else {

            if (showDisplay) {
                linText?.visibility = View.VISIBLE
            } else {
                linText?.visibility = View.GONE
            }

            linTime?.visibility = View.VISIBLE
            lblText?.visibility = View.GONE


            if (mDays == 0L) {
                lblDay?.visibility = View.GONE
                lblDayText?.visibility = View.GONE
            } else {
                lblDay?.visibility = View.VISIBLE
                lblDayText?.visibility = View.VISIBLE
                lblDay?.text = Util.twoDigits(context, mDays)

                if (mDays == 1L) {
                    lblDayText?.text = context.getString(R.string.value_day)
                } else {
                    lblDayText?.text = context.getString(R.string.value_days)
                }
            }


            lblHour?.visibility = View.VISIBLE
            lblHourText?.visibility = View.VISIBLE
            lblHour?.text = Util.twoDigits(context, mHours)
            if (mHours == 1L) {
                lblHourText?.text = context.getString(R.string.value_hour)
            } else {
                lblHourText?.text = context.getString(R.string.value_hours)
            }

            lblMinute?.visibility = View.VISIBLE
            lblMinuteText?.visibility = View.VISIBLE
            lblMinute?.text = Util.twoDigits(context, mMinutes)
            if (mMinutes == 1L) {
                lblMinuteText?.text = context.getString(R.string.value_minute)
            } else {
                lblMinuteText?.text = context.getString(R.string.value_minutes)
            }

            lblSecond?.visibility = View.VISIBLE
            lblSecondText?.visibility = View.VISIBLE
            lblSecond?.text = Util.twoDigits(context, mSeconds)
            if (mSeconds == 1L) {
                lblSecondText?.text = context.getString(R.string.value_second)
            } else {
                lblSecondText?.text = context.getString(R.string.value_seconds)
            }

        }

    }


}