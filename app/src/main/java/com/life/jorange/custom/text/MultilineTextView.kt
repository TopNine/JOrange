package com.life.jorange.custom.text

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp
import com.life.jorange.utils.getAvatar

/**
 * create time: 2022/2/6
 * Descrite:
 */

private val IMAGE_SIZE = 100.dp
private val IMAGE_PADDING = 20.dp

class MultilineTextView(context: Context, attributeSet: AttributeSet) :
    View(context, attributeSet) {
    private val text =
        "曲曲折折的荷塘上面，弥望的是田田的叶子。叶子出水很高，像亭亭的舞女的裙。层层的叶子中间，零星地点缀着些白花，有袅娜地开着的，有羞涩地打着朵儿的；正如一粒粒的明珠，又如碧天里的星星，又如刚出浴的美人。微风过处，送来缕缕清香，仿佛远处高楼上渺茫的歌声似的。这时候叶子与花也有一丝的颤动，像闪电般，霎时传过荷塘的那边去了。叶子本是肩并肩密密地挨着，这便宛然有了一道凝碧的波痕。叶子底下是脉脉的流水，遮住了，不能见一些颜色；而叶子却更见风致了。"

    // lorem ipsum 创建无意义的文字
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            textSize = 16.dp
        }
    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            textSize = 16.dp
        }

    private val fontMetrics = Paint.FontMetrics()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //width: 一行长度
        // spacingmult: 间距倍数
        //spacingadd： 额外间距增加
        //includepad： 额外行距
//        val staticLayout =
//            StaticLayout(text, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, false)
//        staticLayout.draw(canvas)

        canvas.drawBitmap(
            getAvatar(IMAGE_SIZE.toInt(), resources),
            width - IMAGE_SIZE,
            IMAGE_PADDING,
            paint
        )
        paint.getFontMetrics(fontMetrics)
        val measureWidth = floatArrayOf(0f)

        var start = 0
        var count: Int
        var offset = -fontMetrics.top

        while (start < text.length) {
            val realWidth =
                if (offset + fontMetrics.bottom > IMAGE_PADDING && offset
                    + fontMetrics.top < IMAGE_SIZE + IMAGE_PADDING) width - IMAGE_SIZE
                else width
            //measureForwards: 是否是往前测量
            //measureWidth： 测量出文字实际显示宽度
            count =
                paint.breakText(text, start, text.length, true, realWidth.toFloat(), measureWidth)
            canvas.drawText(
                text,
                start,
                start + count,
                0f,
                offset,  //默认行间距
                paint
            )

            start += count
            offset += paint.fontSpacing
        }
    }
}