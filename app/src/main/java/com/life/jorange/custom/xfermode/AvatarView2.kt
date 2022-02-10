package com.life.jorange.custom.xfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp
import com.life.jorange.utils.getAvatar

/**
 * create time: 2022/2/5
 * Descrite:转换模式自定义view
 */

private val RADIO = 100.dp
private val IMAGE_WIDTH = RADIO * 2
private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

class AvatarView2(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val bounds = RectF(
            width / 2f - RADIO,
            height / 2f - RADIO,
            width / 2f + RADIO,
            height / 2f + RADIO
        )
        val count = canvas.saveLayer(bounds, null)
        canvas.drawCircle(width / 2f, height / 2f, RADIO, paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(
            getAvatar(IMAGE_WIDTH, resources),
            width / 2f - RADIO,
            height / 2f - RADIO,
            paint
        )
        canvas.restoreToCount(count)
    }
}