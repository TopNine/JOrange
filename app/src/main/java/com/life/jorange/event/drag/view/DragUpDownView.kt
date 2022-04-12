package com.life.jorange.event.drag.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.ViewCompat
import androidx.core.view.children
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.customview.widget.ViewDragHelper
import com.life.jorange.R
import com.life.jorange.utils.dp
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * create time: 2022/4/7
 * Descrite:
 */
private const val COLUMNS = 2
private const val ROWS = 3

class DragUpDownView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            color = Color.RED
        }
    private val dragCallback = DragCallback()
    private val dragHelper = ViewDragHelper.create(this, dragCallback)
    private val viewConfiguration = ViewConfiguration.get(context)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width / 2f, height / 2f, 100.dp, paint)
    }

    override fun onInterceptHoverEvent(event: MotionEvent): Boolean {
        return dragHelper.shouldInterceptTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        dragHelper.processTouchEvent(event)
        return true
    }

    override fun computeScroll() {
        if(dragHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this)
        }
    }

    inner class DragCallback : ViewDragHelper.Callback() {
        override fun tryCaptureView(child: View, pointerId: Int): Boolean {
            return child == children.elementAt(0)
        }

        override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
            val borderTop = paddingTop + marginTop + child.paddingTop + child.marginTop
            val borderBottom =
                height - paddingBottom - marginBottom - child.paddingBottom - child.marginBottom - 100.dp.toInt()
            return min(max(borderTop, top), borderBottom)
        }

        override fun getViewVerticalDragRange(child: View): Int {
            return super.getViewVerticalDragRange(child)
        }

        override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
            super.onViewReleased(releasedChild, xvel, yvel)
            if (abs(yvel) > viewConfiguration.scaledMinimumFlingVelocity) {
                if (yvel > 0) {
                    dragHelper.settleCapturedViewAt(0, height - releasedChild.height)
                } else {
                    dragHelper.settleCapturedViewAt(0, 0)
                }
            } else {
                if (releasedChild.top > height - releasedChild.bottom) {
                    dragHelper.settleCapturedViewAt(0, height - releasedChild.height)
                } else {
                    dragHelper.settleCapturedViewAt(0, 0)
                }
            }
            postInvalidateOnAnimation()
        }
    }
}