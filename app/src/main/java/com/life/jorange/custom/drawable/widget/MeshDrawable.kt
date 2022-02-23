package com.life.jorange.custom.drawable.widget

import android.graphics.*
import android.graphics.drawable.Drawable
import com.life.jorange.utils.dp

/**
 * create time: 2022/2/21
 * Descrite:
 */

private val INTERVAL = 50.dp

class MeshDrawable : Drawable() {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            color = Color.RED
            strokeWidth = 5.dp
        }

    override fun draw(canvas: Canvas) {
        var x = bounds.left.toFloat()
        while (x <= bounds.right.toFloat()) {
            canvas.drawLine(
                x, bounds.top.toFloat(),
                x, bounds.bottom.toFloat(), paint
            )
            x += INTERVAL
        }

        var y = bounds.top.toFloat()
        while (y <= bounds.bottom.toFloat()) {
            canvas.drawLine(
                bounds.left.toFloat(), y,
                bounds.right.toFloat(), y, paint
            )
            y += INTERVAL
        }

    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getAlpha(): Int {
        return paint.alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getColorFilter(): ColorFilter? {
        return paint.colorFilter
    }

    //不透明度, 判断是否要融合绘制
    override fun getOpacity(): Int {
        return when (paint.alpha) {
            0 -> PixelFormat.TRANSPARENT
            0xff -> PixelFormat.OPAQUE
            else -> PixelFormat.TRANSLUCENT
        }
    }
}