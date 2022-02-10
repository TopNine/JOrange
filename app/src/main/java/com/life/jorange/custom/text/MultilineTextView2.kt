package com.life.jorange.custom.text

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp
import com.life.jorange.utils.getAvatar

/**
 * create time: 2022/2/6
 * Descrite:
 */

private val IMAGE_WIDTH = 100.dp
private val IMAGE_PADDING = 20.dp

class MultilineTextView2(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {
    private val text =
        "曲曲折折的荷塘上面，弥望的是田田的叶子。叶子出水很高，像亭亭的舞女的裙。层层的叶子中间，零星地点缀着些白花，有袅娜地开着的，有羞涩地打着朵儿的；正如一粒粒的明珠，又如碧天里的星星，又如刚出浴的美人。微风过处，送来缕缕清香，仿佛远处高楼上渺茫的歌声似的。这时候叶子与花也有一丝的颤动，像闪电般，霎时传过荷塘的那边去了。叶子本是肩并肩密密地挨着，这便宛然有了一道凝碧的波痕。叶子底下是脉脉的流水，遮住了，不能见一些颜色；而叶子却更见风致了。"

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            textSize = 20.dp
        }
    private val fontMetrics = Paint.FontMetrics()
    private val measureWidth = floatArrayOf(0f)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(
            getAvatar(IMAGE_WIDTH, resources),
            width - IMAGE_WIDTH,
            IMAGE_PADDING,
            paint
        )

        paint.getFontMetrics(fontMetrics)

        var start = 0
        var count: Int
        var offset = -fontMetrics.top
        var maxWidth: Float
        while (start < text.length) {
            maxWidth =
                if (offset + fontMetrics.bottom > IMAGE_PADDING &&
                    offset + fontMetrics.top < IMAGE_WIDTH + IMAGE_PADDING
                )
                    width - IMAGE_WIDTH else width.toFloat()
            count = paint.breakText(text, start, text.length, true, maxWidth, measureWidth)
            canvas.drawText(text, start, start + count, 0f, offset, paint)
            start += count
            offset += paint.fontSpacing
        }
    }
}