package com.life.jorange.event.drag.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

/**
 * create time: 2022/4/7
 * Descrite:
 */
private const val COLUMNS = 2
private const val ROWS = 3
class DragHelperGridView(context: Context, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(widthMeasureSpec)

    }
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
    }
}