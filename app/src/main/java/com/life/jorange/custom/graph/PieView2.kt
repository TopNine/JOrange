package com.life.jorange.custom.graph

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp
import kotlin.math.cos
import kotlin.math.sin

private val RADIO = 150.dp
private val DISTANCE = 20.dp

class PieView2(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val angles = floatArrayOf(60f, 90f, 120f, 30f, 60f)
    private val colors = intArrayOf(Color.RED, Color.YELLOW, Color.GREEN, Color.GRAY, Color.BLUE)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var count = 0
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var startAngle = 0f
        angles.forEachIndexed { index, angle ->
            if (index == count % 5) {
                canvas.save()
                canvas.translate(
                    DISTANCE * cos(distanceAngle(startAngle, angle)),
                    DISTANCE * sin(distanceAngle(startAngle, angle))
                )
            }
            paint.color = colors[index]
            canvas.drawArc(
                width / 2 - RADIO,
                height / 2 - RADIO,
                width / 2 + RADIO,
                height / 2 + RADIO,
                startAngle, angle, true, paint
            )

            if (index == count % 5) {
                canvas.restore()
            }

            startAngle += angle
        }


        if (count < 20) {
            count++
            postInvalidateDelayed(1000)
        }
    }

    private fun distanceAngle(startAngle: Float, sweepAngle: Float): Float {
        return Math.toRadians((startAngle + sweepAngle / 2).toDouble()).toFloat()
    }
}