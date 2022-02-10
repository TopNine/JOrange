package com.life.jorange.custom.camera

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp
import com.life.jorange.utils.getAvatar

private val BITMAP_SIZE = 200.dp
private val BITMAP_PADDING = 100.dp

/**
 * 裁切出一块区域，画出图形
 * 使用方形图画出圆形图片
 */
class ClipView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(BITMAP_SIZE, resources)
    private val clipped = Path()

    init {
        clipped.addOval(
            BITMAP_PADDING,
            BITMAP_PADDING,
            BITMAP_PADDING + BITMAP_SIZE,
            BITMAP_PADDING + BITMAP_SIZE, Path.Direction.CW
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //使用path切出一个形状
        canvas.clipPath(clipped)
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
    }
}