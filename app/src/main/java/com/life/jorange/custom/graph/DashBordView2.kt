package com.life.jorange.custom.graph

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp
import kotlin.math.cos
import kotlin.math.sin

private val RADIO = 150.dp
private const val START_ANGLE = 120f
private const val SWEEP_ANGLE = 360 - START_ANGLE
private val DASH_WIDTH = 4.dp
private val DASH_HEIGHT = 8.dp
private val LINE_LENGTH = 120.dp

class DashBordView2(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 3.dp
        style = Paint.Style.STROKE
    }

    private val path = Path()
    private val dash = Path()
    private lateinit var pathEffect: PathDashPathEffect

    private var count = 0

    init {
        dash.addRect(0f, 0f, DASH_WIDTH, DASH_HEIGHT, Path.Direction.CW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        path.addArc(
            width / 2f - RADIO,
            height / 2f - RADIO,
            width / 2f + RADIO,
            height / 2f + RADIO,
            90 + START_ANGLE / 2,
            SWEEP_ANGLE
        )
        val pathMeasure = PathMeasure(path, false)
        pathEffect = PathDashPathEffect(
            dash,
            (pathMeasure.length - DASH_WIDTH) / 20,
            0f,
            PathDashPathEffect.Style.ROTATE
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)
        paint.pathEffect = null
        canvas.drawPath(path, paint)
        canvas.drawLine(
            width / 2f,
            height / 2f,
            width / 2f + LINE_LENGTH * cos(lineAngle()),
            height / 2f + LINE_LENGTH * sin(lineAngle()),
            paint
        )

        if (count < 20) {
            count++
            postInvalidateDelayed(1000)
        }
    }

    private fun lineAngle(): Float {
        return Math.toRadians((90 + START_ANGLE / 2 + count * SWEEP_ANGLE / 20).toDouble())
            .toFloat()
    }
}