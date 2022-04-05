package com.life.jorange.event.dispatch.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.appcompat.widget.LinearLayoutCompat
import com.life.jorange.utils.dp
import java.lang.Math.abs

private const val TAG = "TabLayout2"

class TabLayout2(val context2: Context, val attrs: AttributeSet?) :
    LinearLayoutCompat(context2, attrs) {
    init {
        for (index: Int in 1..3) {
            generalButton(index)
        }
    }

    private fun generalButton(index: Int): TextView2 {
        val button = TextView2(context2)
        val layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 100)
        layoutParams.weight = 1.0f
        layoutParams.gravity = Gravity.CENTER
        button.text = "button {$index}"
        layoutParams.topMargin = 10.dp.toInt()
        button.layoutParams = layoutParams
        button.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                Log.d(TAG, "onClick: button{$index}")
            }
        })
        addView(button)
        return button
    }

    var statX = 0.0f
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        Log.i(TAG, "onInterceptTouchEvent: ")
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                statX = ev.rawX
                isTouching = false
            }
            MotionEvent.ACTION_MOVE -> {
                val shouldTouch =
                    (abs(ev.rawX - statX) > ViewConfiguration.get(context2).scaledTouchSlop)
                Log.d(TAG, "onInterceptTouchEvent: $shouldTouch")
                Log.d(TAG, "dispatchTouchEvent: $shouldTouch")
                if (shouldTouch) {
                    isTouching = true
//                    for (child in children) {
//                        child.isClickable = false
//                    }
                    return true
                }
//                return false
            }
            MotionEvent.ACTION_UP -> {
                statX = 0.0f
                if (isTouching) {
                    isTouching = false
                    return false
                }
            }
        }
        return false
    }

    override fun canScrollHorizontally(direction: Int): Boolean {
        return false
    }

    var isTouching: Boolean = false
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        Log.i(TAG, "dispatchTouchEvent: ")
//        when (ev.action) {
//            MotionEvent.ACTION_DOWN -> {
//                statX = ev.rawX
//                isTouching = false
//            }
//            MotionEvent.ACTION_MOVE -> {
//                val shouldTouch =
//                    (kotlin.math.abs(ev.rawX - statX) > ViewConfiguration.get(context2).scaledTouchSlop)
//                Log.d(TAG, "dispatchTouchEvent: $shouldTouch")
//                if (kotlin.math.abs(ev.rawX - statX) > ViewConfiguration.get(context2).scaledTouchSlop) {
//                    isTouching = true
//                    return false
//                }
//            }
//            MotionEvent.ACTION_UP -> {
//                statX = 0.0f
//                if (isTouching) {
//                    isTouching = false
//                    return false
//                }
//            }
//        }

        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i(TAG, "onTouchEvent: ")
        return false
    }

}