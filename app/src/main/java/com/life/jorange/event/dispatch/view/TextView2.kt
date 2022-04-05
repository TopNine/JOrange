package com.life.jorange.event.dispatch.view

import android.content.Context
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView

private const val TAG = "TextView2"

class TextView2(val context2: Context) :
    AppCompatTextView(context2) {

    var statX = 0.0f
    var isTouching = false
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        Log.i(TAG, "onTouchEvent: ")
//        when (ev.action) {
//            MotionEvent.ACTION_DOWN -> {
//                statX = ev.rawX
//            }
//            MotionEvent.ACTION_MOVE -> {
//                val shouldTouch =
//                    (Math.abs(ev.rawX - statX) > ViewConfiguration.get(context2).scaledTouchSlop)
//                Log.d(TAG, "onTouchEvent shouldTouch: $shouldTouch")
//                if (shouldTouch) {
//                    isTouching = true
//                }
//            }
//            MotionEvent.ACTION_UP -> {
//                statX = 0.0f
//                if (isTouching) {
//                    isTouching = false
//                } else {
//                    performClick()
//                }
//            }
//        }

//        performClick()
//        return false
        val onTouchEvent = super.onTouchEvent(ev)
        Log.d(TAG, "onTouchEvent :   $onTouchEvent")
        return onTouchEvent
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.i(TAG, "dispatchTouchEvent: ")
        val dispatchTouchEvent = super.dispatchTouchEvent(event)
        Log.d(TAG, "dispatchTouchEvent: $dispatchTouchEvent")
        return dispatchTouchEvent
    }

//    override fun canScrollHorizontally(direction: Int): Boolean {
//        return false
//    }
}