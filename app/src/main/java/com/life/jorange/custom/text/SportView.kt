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
 * Descrite:
 */
private val RADIO = 150.dp

class SportView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 100.dp
        //设置字体
        typeface = ResourcesCompat.getFont(context, R.font.font)
        //是否加粗
//        isFakeBoldText = true
        //设置文字居中， 可以设置左右居中
        textAlign = Paint.Align.CENTER
    }
    private val text = "aabb"
    private val bounds = Rect()
    private val fontMetrics = Paint.FontMetrics()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20.dp
        canvas.drawCircle(width / 2f, height / 2f, RADIO, paint)

        paint.color = Color.RED
        //弧度添加圆角
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(
            width / 2f - RADIO,
            height / 2f - RADIO,
            width / 2f + RADIO,
            height / 2f + RADIO,
            -90f,
            225f,
            false,
            paint
        )
        paint.style = Paint.Style.FILL
        paint.color = Color.GREEN
        //获取文字准确尺寸
//        paint.getTextBounds(text, 0, text.length, bounds)
        paint.getFontMetrics(fontMetrics)
        canvas.drawText(
            text,
            width / 2f,
            height / 2f - (fontMetrics.ascent + fontMetrics.descent) / 2,
            paint
        )

        paint.textAlign = Paint.Align.LEFT
        paint.textSize = 20.dp
        //获取文字模糊尺寸， 用于动态文字
        paint.getFontMetrics(fontMetrics)
        canvas.drawText(text, 0f, -fontMetrics.top, paint)
        paint.textSize = 100.dp
        //获取文字准确尺寸, 用于静态文字
        paint.getTextBounds(text, 0, text.length, bounds)
        canvas.drawText(text, -bounds.left.toFloat(), -bounds.top.toFloat(), paint)
    }
}