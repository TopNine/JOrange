package com.life.jorange.base

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.life.jorange.R
import com.life.jorange.utils.sp

/**
 * create time: 2022/2/16
 * Descrite:
 */

class CloseView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        isFakeBoldText = true
    }

    private val text = "Close"
    private val bounds = Rect()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.parseColor("#4D4A4A48")
        canvas.drawCircle(width / 2f, height / 2f, width / 2f, paint)
        paint.color = Color.RED
        paint.textSize = 20.sp
        paint.getTextBounds(text, 0, text.length, bounds)
        canvas.drawText("Close", width / 2f, height / 2f - (bounds.top + bounds.bottom) / 2f, paint)
    }
}