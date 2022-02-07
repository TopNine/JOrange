package com.life.jorange.custom.text

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.life.jorange.R
import com.life.jorange.utils.dp

/**
 * create time: 2022/2/6
 * Descrite:文字测量，左右居中对齐，上下居中对齐
 */

private val RADIO = 150.dp

class SportView2(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            style = Paint.Style.STROKE
            strokeWidth = 20.dp
            textAlign = Paint.Align.CENTER
            textSize = 100.dp
            typeface = ResourcesCompat.getFont(context, R.font.font)
        }

    private val fontMetrics = Paint.FontMetrics()
    private val bounds = Rect()
    private val text = "abab"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.YELLOW
        canvas.drawCircle(width / 2f, height / 2f, RADIO, paint)

        paint.color = Color.RED
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(
            width / 2f - RADIO,
            height / 2f - RADIO,
            width / 2 + RADIO,
            height / 2f + RADIO,
            -90f,
            225f,
            false,
            paint
        )

        paint.style = Paint.Style.FILL
        paint.getTextBounds(text, 0, text.length, bounds)
        canvas.drawText(text, width / 2f, height / 2f - (bounds.top + bounds.bottom) / 2, paint)

        paint.getTextBounds(text, 0, text.length, bounds)
        paint.getFontMetrics(fontMetrics)
        canvas.drawText(text, (-bounds.left).toFloat(), (-bounds.top).toFloat(), paint)

        paint.textSize = 20.dp
        paint.getTextBounds(text, 0, text.length, bounds)
        paint.getFontMetrics(fontMetrics)
        canvas.drawText(text, (-bounds.left).toFloat(), (-bounds.top).toFloat(), paint)

    }
}