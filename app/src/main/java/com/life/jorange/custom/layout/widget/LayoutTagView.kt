package com.life.jorange.custom.layout.widget

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.children
import kotlin.math.max

/**
 * https://mp.weixin.qq.com/s/az1BpcgSRS8U0nAQp0Hqeg
 */
private val provinces = listOf(
    "北京市",
    "天津市",
    "上海市",
    "重庆市",
    "河北省",
    "山西省",
    "辽宁省",
    "吉林省",
    "黑龙江省",
    "江苏省",
    "浙江省",
    "安徽省",
    "福建省",
    "江西省",
    "山东省",
    "河南省",
    "湖北省",
    "湖南省",
    "广东省",
    "海南省",
    "四川省",
    "贵州省",
    "云南省",
    "陕西省",
    "甘肃省",
    "青海省",
    "台湾省",
    "内蒙古自治区",
    "广西壮族自治区",
    "西藏自治区",
    "宁夏回族自治区",
    "新疆维吾尔自治区",
    "香港特别行政区",
    "澳门特别行政区"
)

class LayoutTagView(context: Context, private val attrs: AttributeSet?) :
    ViewGroup(context, attrs) {
    private val childrenBounds = mutableListOf<Rect>()

    init {
        val roundTextView = RoundTextView(context)
        roundTextView.text = provinces[0]
        addTagView()
    }

    fun addTagView() {
        provinces.forEach() { province ->
            val roundTextView = RoundTextView(context).apply {
                text = province
                layoutParams = MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            }
            addView(roundTextView)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var widthUsed = 0
        var heightUsed = 0
        var lineWidthUsed = 0
        var lineHeightUsed = 0
        val specWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        val specWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        for ((index, child) in children.withIndex()) {
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            if (specWidthMode != MeasureSpec.UNSPECIFIED && (lineWidthUsed + child.measuredWidth > specWidthSize)) {
                lineWidthUsed = 0
                heightUsed += lineHeightUsed
                lineHeightUsed = 0
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            }
            if (index >= childrenBounds.size) {
                childrenBounds.add(Rect())
            }
            val childBounds = childrenBounds[index]
            childBounds.set(
                lineWidthUsed,
                heightUsed,
                lineWidthUsed + child.measuredWidth,
                heightUsed + child.measuredHeight
            )
            lineWidthUsed += child.measuredWidth
            widthUsed = max(widthUsed, lineWidthUsed)
            lineHeightUsed = max(child.measuredHeight, lineHeightUsed)
        }
        val selfWidth = widthUsed
        val selfHeight = heightUsed + lineHeightUsed
        setMeasuredDimension(selfWidth, selfHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for ((index, child) in children.withIndex()) {
            val childBounds = childrenBounds[index]
            child.layout(
                childBounds.left,
                childBounds.top,
                childBounds.right,
                childBounds.bottom
            )
        }
    }

    /**
     * 修复 LayoutParams 转换异常
     */
    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    /**
     * 修复子 view 的 LayoutParams 转换异常
     */
    override fun checkLayoutParams(p: LayoutParams?): Boolean {
        return p is MarginLayoutParams
    }
}