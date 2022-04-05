package com.life.jorange.custom.layout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp

private val RADIO = 100.dp
private val PADDING = 100.dp

class MeasureCircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val size = (PADDING + RADIO) * 2
        val measureWidth = measureSize(size.toInt(), widthMeasureSpec)
        val measureHeight = measureSize(size.toInt(), heightMeasureSpec)
        setMeasuredDimension(measureWidth, measureHeight)
    }

    private fun measureSize(size: Int, measureSpec: Int): Int {
        val widthMode = MeasureSpec.getMode(measureSpec)
        val widthSize = MeasureSpec.getSize(measureSpec)
        return when (widthMode) {
            MeasureSpec.EXACTLY -> widthSize
            MeasureSpec.AT_MOST -> size
            else -> {
                size
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(PADDING + RADIO, PADDING + RADIO, RADIO, paint)
    }
}