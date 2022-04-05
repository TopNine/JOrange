package com.life.jorange.event.multi.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.life.jorange.utils.dp
import com.life.jorange.utils.getAvatar

/**
 * 配合型, 多指同时滑动
 * 查找多点之间的中间值
 */
class MultiTouchView2(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(200.dp, resources)

    //偏移值
    private var offsetX = 0f
    private var offsetY = 0f

    //原始偏移值
    private var originalOffsetX = 0f
    private var originalOffsetY = 0f

    //按下坐标
    private var startX = 0f
    private var startY = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(bitmap, offsetX, offsetY, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        //所有点的数量
        var pointerCount = event.pointerCount
        //所有点 x,y 坐标的和
        var sumX = 0f
        var sumY = 0f

        //是否是抬起事件, 用于修复抬起后所有点数量未及时变化, 导致中间值计算不准确而跳动
        val isPointerUp = event.actionMasked == MotionEvent.ACTION_POINTER_UP

        //所有点 x,y 坐标求和
        for (i in 0 until pointerCount) {
            //如果是抬起并且是抬起的角标, 不求和
            if (!(isPointerUp && i == event.actionIndex)) {
                sumX += event.getX(i)
                sumY += event.getY(i)
            }
        }

        //若果是抬起事件, 总数减一
        if (isPointerUp) {
            pointerCount--;
        }

        //获取 x, y 坐标中间值
        val focusX = sumX / pointerCount
        val focusY = sumY / pointerCount

        when (event.actionMasked) {
            //记录按下值为中间值, 记录原始偏移值
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN, MotionEvent.ACTION_POINTER_UP -> {
                startX = focusX
                startY = focusY
                originalOffsetX = offsetX
                originalOffsetY = offsetY
            }

            MotionEvent.ACTION_MOVE -> {
                // 更新偏移值
                offsetX = focusX - startX + originalOffsetX
                offsetY = focusY - startY + originalOffsetY
                invalidate()
            }
        }
        return true
    }
}