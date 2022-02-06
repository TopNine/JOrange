package com.life.jorange.custom.graph

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp
import kotlin.math.cos
import kotlin.math.sin

private val RADIO = 100f.dp
private val SIZE = 150f.dp
private const val START_ANGLE = 120f
private const val SWEEP_ANGLE = 360 - START_ANGLE
private val DASH_WIDTH = 5.dp
private val DASH_LENGTH = 10.dp
private val LINE_LENGTH = 100.dp

class DashBordView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var count = 0
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            strokeWidth = 3.dp
            style = Paint.Style.STROKE
        }

    private val path = Path()
    private val dash = Path()
    private lateinit var pathEffect: PathDashPathEffect

    init {
        dash.addRect(0f, 0f, DASH_WIDTH, DASH_LENGTH, Path.Direction.CW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        path.addArc(
            width / 2f - SIZE, height / 2f - SIZE,
            width / 2f + SIZE, height / 2f + SIZE,
            90 + START_ANGLE / 2f, SWEEP_ANGLE
        )

        val pathMeasure = PathMeasure(path, false)
        // advance: 间隔（提前量）， phase：提前量（间隔）android搞反了
        pathEffect =
            PathDashPathEffect(
                dash,
                (pathMeasure.length - DASH_WIDTH) / 20, //20个刻度20个间隔
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
            width / 2 + LINE_LENGTH * cos(markArc()),
            height / 2f + LINE_LENGTH * sin(markArc()),
            paint
        )

        if (count < 20) {
            count++
            postInvalidateDelayed(1000)
        }
    }

    private fun markArc(): Float {
        return Math.toRadians((90 + START_ANGLE / 2 + count * SWEEP_ANGLE / 20).toDouble())
            .toFloat()
    }
}