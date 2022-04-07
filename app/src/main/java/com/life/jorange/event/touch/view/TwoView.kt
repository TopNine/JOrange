package com.life.jorange.event.touch.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.widget.OverScroller
import androidx.core.view.children
import kotlin.math.abs

/**
 * create time: 2022/4/5
 * Descrite:
 */
class TwoView(context: Context, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    //按下位置
    private var downX = 0f
    private var downY = 0f

    //按下时x滚动距离
    private var downScrollX = 0f

    //是否正在滑动
    private var isScrolling = false

    //view 的配置,用于获取设定的默认值
    private val viewConfiguration = ViewConfiguration.get(context)

    //页面滑动最小值
    private val pageScroll = viewConfiguration.scaledPagingTouchSlop

    //滑动速度跟踪器
    private val velocityTracker = VelocityTracker.obtain()

    //最小速率
    private val minVelocityTracker = viewConfiguration.scaledMinimumFlingVelocity

    //最大速率
    private val maxVelocityTracker = viewConfiguration.scaledMaximumFlingVelocity

    //滚动器
    private val overScroller = OverScroller(context)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //给所有的子 view统一的宽和高,用的少,没有定制性
        measureChildren(widthMeasureSpec, heightMeasureSpec)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var childLeft = 0
        val childTop = 0
        var childRight = width
        val childBottom = height
        //重新布局子 view
        children.forEach { child ->
            child.layout(childLeft, childTop, childRight, childBottom)
            childLeft += width
            childRight += width
        }
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        if (event.actionMasked == MotionEvent.ACTION_DOWN) {
            velocityTracker.clear()
        }

        velocityTracker.addMovement(event)
        var result = false
        when (event.actionMasked) {
            //初始化是为了如果 down 事件在子 view 上, 也可以初始化按下的数据
            MotionEvent.ACTION_DOWN -> {
                //初始化滑动标识
                isScrolling = false
                //初始化 x, y 的坐标
                downX = event.x
                downY = event.y
                //初始化按下时滚动值
                downScrollX = scrollX.toFloat()
            }
            MotionEvent.ACTION_MOVE -> {
                if (!isScrolling) {
                    val dx = downX - event.x
                    //滑动距离是否大于最小滑动值
                    if (abs(dx) > pageScroll) {
                        isScrolling = true
                        //请求父 view 不要拦截
                        parent.requestDisallowInterceptTouchEvent(true)
                        result = true
                    }
                }
            }
        }
        return result
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x
                downY = event.y
                downScrollX = scrollX.toFloat()
            }
            MotionEvent.ACTION_MOVE -> {
                //计算滑动距离, 注意:值是反的, 与模型相关
                val dx = (downX - event.x + downScrollX).toInt()
                    //相当于 min,对比取最小值
                    .coerceAtLeast(0)
                    //相当于 max, 对比取最大值
                    .coerceAtMost(width)
                //滑动到指定位置
                scrollTo(dx, 0)
            }
            MotionEvent.ACTION_UP -> {
                //计算速度
                velocityTracker.computeCurrentVelocity(1000, maxVelocityTracker.toFloat())
                //获取速度
                val xVelocity = velocityTracker.xVelocity
                val currentScrollX = scrollX
                //速度小于最小速度
                val targetPage = if (abs(xVelocity) < minVelocityTracker) {
                    //滑动距离大于页面一半 1 否则 0
                    if (currentScrollX > width / 2) 1 else 0
                } else {
                    //速度小于 0 页面 1 否则 0
                    if (xVelocity < 0) 1 else 0
                }

                val scrollDistance =
                    if (targetPage == 1) width - currentScrollX else -currentScrollX
                overScroller.startScroll(currentScrollX, 0, scrollDistance, 0)
                //没有参数, 下一帧标记为失效, 配合computeScroll()刷新
                postInvalidateOnAnimation()
            }
        }
        return true
    }

    override fun computeScroll() {
        //判断滚动是否结束, 并计算偏移
        if (overScroller.computeScrollOffset()) {
            scrollTo(overScroller.currX, overScroller.currY)
            postInvalidateOnAnimation()
        }
    }
}