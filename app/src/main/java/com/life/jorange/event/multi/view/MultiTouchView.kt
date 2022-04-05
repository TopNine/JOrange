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
 * 接力型, 多指交替滑动
 * 将事件转移给当前移动手指
 */
class MultiTouchView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(200.dp, resources)

    //序列进行中偏移值
    private var offsetX = 0f
    private var offsetY = 0f

    //原始偏移值
    private var originalOffsetX = 0f
    private var originalOffsetY = 0f

    //按下点
    private var startX = 0f
    private var startY = 0f

    //最近点的 id
    private var trackingPointId = 0

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(bitmap, offsetX, offsetY, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                //记录最近点 id
                trackingPointId = event.getPointerId(0)
                //初始化按下坐标
                startX = event.x
                startY = event.y
                //初始化 初始偏移值
                originalOffsetX = offsetX
                originalOffsetY = offsetY
            }

            MotionEvent.ACTION_POINTER_DOWN -> {
                //获取移动点角标
                val actionIndex = event.actionIndex
                //记录最近点 id
                trackingPointId = event.getPointerId(actionIndex)
                //初始化最近点坐标
                startX = event.getX(actionIndex)
                startY = event.getY(actionIndex)
                //初始化 初始偏移值
                originalOffsetX = offsetX
                originalOffsetY = offsetY
            }

            MotionEvent.ACTION_MOVE -> {
                //根据最近点 id 获取角标
                val index = event.findPointerIndex(trackingPointId)
                //更新偏移值
                offsetX = event.getX(index) - startX + originalOffsetX
                offsetY = event.getY(index) - startY + originalOffsetY
                //重绘
                invalidate()
            }

            MotionEvent.ACTION_POINTER_UP -> {
                //获取最近点角标
                val index = event.actionIndex
                //获取最近点 id
                val pointerId = event.getPointerId(index)
                //松手 最近点 id 等于 移动 id
                if (pointerId == trackingPointId) {
                    //判断松手的角标是否是最后一个, 接力给上一个点
                    val newIndex = if (index == event.pointerCount - 1) {
                        event.pointerCount - 2
                    } else {
                        event.pointerCount - 1
                    }

                    //更新移动点 id
                    trackingPointId = event.getPointerId(newIndex)
                    //更新按下坐标
                    startX = event.getX(newIndex)
                    startY = event.getY(newIndex)
                    //更新原始偏移值
                    originalOffsetX = offsetX
                    originalOffsetY = offsetY
                }
            }
        }
        return true
    }
}