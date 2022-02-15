package com.life.jorange.custom.camera

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp
import com.life.jorange.utils.getAvatar

/**
 * create time: 2022/2/7
 * Descrite:
 */
private val BITMAP_SIZE = 200.dp
private val BITMAP_PADDING = 100.dp

class ClipView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val clipped = Path().apply {
        addOval(
            BITMAP_PADDING,
            BITMAP_PADDING,
            BITMAP_SIZE + BITMAP_PADDING,
            BITMAP_SIZE + BITMAP_PADDING, Path.Direction.CW
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //切出一块区域，作为画板
//        canvas.clipRect(
//            BITMAP_PADDING,
//            BITMAP_PADDING,
//            BITMAP_SIZE / 2 + BITMAP_PADDING,
//            BITMAP_SIZE / 2 + BITMAP_PADDING
//        )
        //切出一块图形, 有毛边（特性，不是bug），一般不用（是否可以加个圆环遮住？）
        canvas.clipPath(clipped)
        canvas.drawBitmap(
            getAvatar(BITMAP_SIZE, resources), BITMAP_PADDING,
            BITMAP_PADDING, paint
        )
    }
}