package com.life.jorange.custom.graph

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp
import kotlin.math.cos
import kotlin.math.sin

private val RADIO = 100f.dp
private val DISTANCE = 20f.dp

class PieView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var count = 0
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val angles = floatArrayOf(30f, 60f, 90f, 120f, 60f)
    private val colors = intArrayOf(Color.RED, Color.BLACK, Color.YELLOW, Color.GRAY, Color.GREEN)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var startAngle = 0f
        angles.forEachIndexed { index, angle ->
            if (index == count % 5) {
                canvas.save()
                canvas.translate(
                    DISTANCE * cos(markArc(startAngle, angle)),
                    DISTANCE * sin(markArc(startAngle, angle))
                )
            }
            paint.color = colors[index]
            canvas.drawArc(
                width / 2f - RADIO,
                height / 2f - RADIO,
                width / 2f + RADIO,
                height / 2f + RADIO,
                startAngle, angle, true, paint
            )
            startAngle += angle
            if (index == count) {
                canvas.restore()
            }
        }


        if (count < 5) {
            count++
            postInvalidateDelayed(1000)
        }
    }

    private fun markArc(startAngle: Float, sweepAngle: Float): Float {
        return Math.toRadians((sweepAngle / 2 + startAngle).toDouble())
            .toFloat()
    }
}