package com.life.jorange.custom.animator.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */

class CircleView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var radios = 50.dp
        set(value) {
            field = value
            //重绘， 不叫refresh，不是自动刷新
            invalidate()
        }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.GREEN
        canvas.drawCircle(width / 2f, height / 2f, radios, paint)
    }
}