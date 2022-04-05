package com.life.jorange.event.multi.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.life.jorange.utils.dp
import com.life.jorange.utils.getAvatar

class MultiTouchViewEx1(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val bitmap = getAvatar(300.dp, resources)

    private var offsetX = 0f
    private var offsetY = 0f

    private var originalOffsetX = 0f
    private var originalOffsetY = 0f

    private var downX = 0f
    private var downY = 0f

    private var trackingPointerId = 0

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawBitmap(bitmap, offsetX, offsetY, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val actionIndex = event.actionIndex
        val pointerId = event.getPointerId(actionIndex)
        val pointerCount = event.pointerCount
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x
                downY = event.y
                trackingPointerId = event.getPointerId(0)

                originalOffsetX = offsetX
                originalOffsetY = offsetY
            }

            MotionEvent.ACTION_POINTER_DOWN -> {
                downX = event.getX(actionIndex)
                downY = event.getY(actionIndex)
                trackingPointerId = event.getPointerId(actionIndex)

                originalOffsetX = offsetX
                originalOffsetY = offsetY
            }

            MotionEvent.ACTION_MOVE -> {
                val index = event.findPointerIndex(trackingPointerId)
                offsetX = event.getX(index) - downX + originalOffsetX
                offsetY = event.getY(index) - downY + originalOffsetY
                invalidate()
            }
            MotionEvent.ACTION_POINTER_UP -> {
                if (pointerId == trackingPointerId) {
                    val newIndex = if (event.findPointerIndex(pointerId) == pointerCount - 1) {
                        pointerCount - 2
                    } else {
                        pointerCount - 1
                    }
                    trackingPointerId = event.getPointerId(newIndex)
                    downX = event.getX(newIndex)
                    downY = event.getY(newIndex)
                    originalOffsetX = offsetX
                    originalOffsetY = offsetY
                }
            }
        }
        return true
    }
}