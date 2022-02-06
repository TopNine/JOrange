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

private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

class XfermodeView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    //创建圆bitmap
    private val circleBitmap =
        Bitmap.createBitmap(150.dp.toInt(), 150.dp.toInt(), Bitmap.Config.ARGB_8888)
    //创建方形bitmap
    private val squareBitmap =
        Bitmap.createBitmap(150.dp.toInt(), 150.dp.toInt(), Bitmap.Config.ARGB_8888)
    //离屏缓冲位置
    private val bound = RectF(
        150.dp,
        50f,
        300.dp,
        200.dp
    )

    init {
        val canvas = Canvas(circleBitmap)
        paint.color = Color.RED
        //画圆
        canvas.drawOval(50.dp, 0f, 150.dp, 100.dp, paint)
        canvas.setBitmap(squareBitmap)
        paint.color = Color.BLUE
        //画方形
        canvas.drawRect(0f, 50.dp, 100.dp, 150.dp, paint)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //开启离情缓冲
        val count = canvas.saveLayer(bound, null)
        //画圆
        canvas.drawBitmap(circleBitmap, 150.dp, 50.dp, paint)
        paint.xfermode = XFERMODE
        //画方形
        canvas.drawBitmap(squareBitmap, 150.dp, 50.dp, paint)
        paint.xfermode = null
        //重置离屏缓冲
        canvas.restoreToCount(count)
    }
}