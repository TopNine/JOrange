package com.life.jorange.custom.graph

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp

private val RADIO = 100f.dp

class TestView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val path = Path()
    private lateinit var pathMeasure: PathMeasure

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        path.reset()
        path.addCircle(width / 2f, height / 2f, RADIO, Path.Direction.CW)
        path.addRect(
            width / 2f - RADIO,
            height / 2f,
            width / 2f + RADIO,
            height / 2f + 2 * RADIO,
            Path.Direction.CW
        )
        path.addCircle(width / 2f, height / 2f, RADIO * 1.5f, Path.Direction.CW)
        //forceClosed 是否自动闭合， 比如弧是否封口
        pathMeasure = PathMeasure(path, false)
        //测量长度
        pathMeasure.length
        //路径位置切角
        pathMeasure.getPosTan(0f, floatArrayOf(0f), floatArrayOf(0f))
        //填充规则， winding 旋转式，一个方向  event_odd
        path.fillType = Path.FillType.INVERSE_EVEN_ODD
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path, paint)
    }
}