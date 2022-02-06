package com.life.jorange.custom.xfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp

/**
 * create time: 2022/2/5
 * Descrite:转换模式自定义view
 */

private val RADIO = 100.dp
private val SIZE = RADIO * 2
private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
private val circleBitmap = Bitmap.createBitmap(SIZE.toInt(), SIZE.toInt(), Bitmap.Config.ARGB_8888)
private val squareBitmap = Bitmap.createBitmap(SIZE.toInt(), SIZE.toInt(), Bitmap.Config.ARGB_8888)

class XfermodeView2(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private lateinit var bounds: RectF

    init {
        val canvas = Canvas(circleBitmap)
        paint.color = Color.RED
        canvas.drawCircle(RADIO, RADIO, RADIO, paint)
        canvas.setBitmap(squareBitmap)
        paint.color = Color.BLUE
        canvas.drawRect(
            0f,
            0f,
            SIZE,
            SIZE,
            paint
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        bounds =
            RectF(width / 2f - SIZE, 0f, width / 2f + RADIO, RADIO + SIZE)
        val count = canvas.saveLayer(bounds, null)
        canvas.drawBitmap(circleBitmap, width / 2f - RADIO, 0f, paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(squareBitmap, width / 2f - SIZE, RADIO, paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
    }
}