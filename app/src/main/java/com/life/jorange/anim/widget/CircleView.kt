package com.life.jorange.anim.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.jar.Attributes

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class CircleView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.GREEN
        canvas.drawCircle(100f, 100f, 200f, paint)
    }
}