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

private val IMG_WIDTH = 200.dp
private val IMG_PADDING = 20.dp
private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

class AvatarView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bound = RectF(
        IMG_PADDING,
        IMG_PADDING,
        IMG_PADDING + IMG_WIDTH,
        IMG_PADDING + IMG_WIDTH
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //画圆环，加描边
        canvas.drawOval(
            IMG_PADDING - 5.dp,
            IMG_PADDING - 5.dp,
            IMG_PADDING + IMG_WIDTH + 5.dp,
            IMG_PADDING + IMG_WIDTH + 5.dp,
            paint
        )
        //开启离屏缓冲
        val count = canvas.saveLayer(bound, null)
        //画圆，用于指定裁切位置
        canvas.drawOval(
            IMG_PADDING,
            IMG_PADDING,
            IMG_PADDING + IMG_WIDTH,
            IMG_PADDING + IMG_WIDTH,
            paint
        )
        //所有view都被裁切，包括主view， 需要适用离屏缓冲: 划出一份屏幕外区域，先画图，在恢复到屏幕上
        paint.xfermode = XFERMODE
        //画图
        canvas.drawBitmap(getAvatar(IMG_WIDTH, resources), IMG_PADDING, IMG_PADDING, paint)
        // 恢复离屏缓冲位置
        canvas.restoreToCount(count)

    }
}