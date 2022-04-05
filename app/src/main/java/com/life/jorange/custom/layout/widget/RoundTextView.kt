package com.life.jorange.custom.layout.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.life.jorange.R
import com.life.jorange.utils.dp
import kotlin.random.Random

private val ROUND_CORNER = 5.dp
private val CHILD_PADDING_X = 10.dp
private val CHILD_PADDING_Y = 5.dp


class RoundTextView(context: Context) :
    AppCompatTextView(context) {

    private val colors = intArrayOf(
        ContextCompat.getColor(context, R.color.red_50),
        ContextCompat.getColor(context, R.color.yellow),
        ContextCompat.getColor(context, R.color.gray),
    )

    private val textSizes = floatArrayOf(
        15f,
        20f,
        25f
    )

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        setTextColor(colors[Random.nextInt(colors.size)])
        textSize = textSizes[Random.nextInt(textSizes.size)]
        setPadding(
            CHILD_PADDING_X.toInt(),
            CHILD_PADDING_Y.toInt(), CHILD_PADDING_X.toInt(), CHILD_PADDING_Y.toInt()
        )
    }

    override fun onDraw(canvas: Canvas) {
        val rectF = RectF(0f, 0f, width.toFloat(), height.toFloat())
        canvas.drawRoundRect(
            rectF, ROUND_CORNER,
            ROUND_CORNER, paint
        )
        super.onDraw(canvas)
    }
}