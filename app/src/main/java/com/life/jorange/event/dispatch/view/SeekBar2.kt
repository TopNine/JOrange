package com.life.jorange.event.dispatch.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

private const val TAG = "SeekBar2"

class SeekBar2(val context2: Context, val attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatSeekBar(context2, attrs) {

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i(TAG, "onTouchEvent: ")
        val onTouchEvent = super.onTouchEvent(event)
        Log.d(TAG, "onTouchEvent: $onTouchEvent")
        return onTouchEvent
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.i(TAG, "dispatchTouchEvent: ")
        val dispatchTouchEvent = super.dispatchTouchEvent(event)
        Log.d(TAG, "dispatchTouchEvent: $dispatchTouchEvent")
        return dispatchTouchEvent
    }
}