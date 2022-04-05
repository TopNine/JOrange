package com.life.jorange.event.multi.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.SparseArray
import android.view.MotionEvent
import android.view.View
import androidx.core.util.forEach
import com.life.jorange.utils.dp

/**
 * 各自为战型
 */
class MultiTouchView3(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
            strokeJoin = Paint.Join.ROUND
            strokeWidth = 4.dp
            color = Color.RED
        }

    private val paths = SparseArray<Path>()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paths.forEach { _, path ->
            canvas.drawPath(path, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val actionIndex = event.actionIndex
        val pointerId = event.getPointerId(actionIndex)
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                val path = Path()
                //按下时移动
                path.moveTo(event.getX(actionIndex), event.getY(actionIndex))
                //添加到集合, 使用 id, index 是会变化的
                paths.append(event.getPointerId(actionIndex), path)
                //重绘
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                paths.forEach { id, path ->
                    val index = event.findPointerIndex(id)
                    path.lineTo(event.getX(index), event.getY(index))
                }

                //移动时拖尾
                invalidate()
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                //抬起时清空
                paths.remove(pointerId)
                invalidate()
            }
        }
        return true
    }
}