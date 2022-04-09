package com.life.jorange.event.gesture.view

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.OverScroller
import android.widget.Scroller
import androidx.core.animation.doOnEnd
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.ViewCompat
import com.life.jorange.utils.dp
import com.life.jorange.utils.getAvatar
import kotlin.math.max
import kotlin.math.min

private val BITMAP_SIZE = 300.dp
private const val EXTRA_SCALE_FACTOR = 1.5f

/**
 * 1. 画出图片
 * 2。设置缩放
 * 3。添加缩放动画
 * 4。增加放大滑动
 * 5。滑动边界
 * 6. 快速滑动
 * 7。双击缩小时归位
 * 8. 双击跟手缩放
 * 9. 捏合缩放
 */
class ScalableImageView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    //获取 bitmap 的图片
    private val bitmap = getAvatar(BITMAP_SIZE, resources)

    //初始化画笔
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    //小图缩放值
    private var smallScale = 0f

    //大图缩放值
    private var bigScale = 0f

    //初始x, y位移值
    private var originalOffsetX = 0f
    private var originalOffsetY = 0f

    //滑动时偏移
    private var offsetX = 0f
    private var offsetY = 0f

    //是否是大图模式
    private var isBig = false

    //手势监听
    private val gestureListener = ScalableGestureListener()

    //缩放手势
    private val scaleGestureListener = ScalableScaleGestureListener()

    //手势探测器
    private val gestureDetector = GestureDetectorCompat(context, gestureListener)

    //缩放手势检查器
    private val scaleGestureDetector = ScaleGestureDetector(context, scaleGestureListener)

    //缩放动画属性, 当前状态和上一状态的系数值
    private var currentScale = 0f
        set(value) {
            field = value
            invalidate()
        }

    //缩放动画
    private val scaleAnimator = ObjectAnimator.ofFloat(this, "currentScale", smallScale, bigScale)
//    by lazy {
//        ObjectAnimator.ofFloat(this, "currentScale", smallScale, bigScale)
    //启用跟手缩放后, 不需要重置了
//            .apply {
//                doOnEnd {
//                    //缩小时重置偏移
//                    if (!isBig) {
//                        offsetX = 0f
//                        offsetY = 0f
//                    }
//                }
//            }
//    }

    //直线移动
    private val scroller = Scroller(context)

    //滑动计算器，惯性滑动，有速度变化
    private val overScroller = OverScroller(context)

    private val flingRunnable = FlingRunnable()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        originalOffsetX = (width - BITMAP_SIZE) / 2f
        originalOffsetY = (height - BITMAP_SIZE) / 2f

        if (bitmap.width / bitmap.height > width / height) {
            smallScale = width / bitmap.width.toFloat()
            bigScale = (height / bitmap.height.toFloat()) * EXTRA_SCALE_FACTOR
        } else {
            smallScale = height / bitmap.height.toFloat()
            bigScale = (width / bitmap.width.toFloat()) * EXTRA_SCALE_FACTOR
        }

        currentScale = smallScale
        //由于是动态的值, 需要在变化时进行更新
        scaleAnimator.setFloatValues(smallScale, bigScale)
    }

    //几何变换反着看流程
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //移动, scaleFraction改变影响力, 用于缩小时复位
        val scaleFraction = (currentScale - smallScale) / (bigScale - smallScale)
        canvas.translate(offsetX * scaleFraction, offsetY * scaleFraction)
        //放大
        canvas.scale(currentScale, currentScale, width / 2f, height / 2f)
        //画图
        canvas.drawBitmap(bitmap, originalOffsetX, originalOffsetY, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleGestureDetector.onTouchEvent(event)
        if (!scaleGestureDetector.isInProgress) {
            gestureDetector.onTouchEvent(event)
        }
        return true
    }

    //设置 x,y 的最小最大值
    private fun fixOffset() {
        //注意，offset方向时反的
        offsetX = min((bitmap.width * bigScale - width) / 2f, offsetX)
        offsetX = max(-(bitmap.width * bigScale - width) / 2f, offsetX)
        offsetY = min((bitmap.height * bigScale - height) / 2f, offsetY)
        offsetY = max(-(bitmap.height * bigScale - height) / 2f, offsetY)
    }

    inner class ScalableScaleGestureListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        //缩放中
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            val tempCurrentScale = currentScale * detector.scaleFactor
            if(tempCurrentScale < smallScale || tempCurrentScale > bigScale){
                return false
            }
            //缩放系数, 当前状态和初始状态的系数
            currentScale *= detector.scaleFactor
//            //比较最小值
//            currentScale = currentScale.coerceAtLeast(smallScale)
//                //比较最大值
//                .coerceAtMost(bigScale)
//            //返回 false, 初始状态的比值; 返回 true, 返回上一状态的比值
            return true
        }

        //缩放开始, 必须返回 true 消费
        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            offsetX = (detector.focusX - width / 2) * (1 - bigScale / smallScale)
            offsetY = (detector.focusY - height / 2) * (1 - bigScale / smallScale)
            return true
        }

        //缩放结束, 松手
        override fun onScaleEnd(detector: ScaleGestureDetector?) {
            super.onScaleEnd(detector)
        }
    }

    inner class ScalableGestureListener : GestureDetector.SimpleOnGestureListener() {
        //按下时回调,必须返回 true 才能接收后续事件
        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

        //按下 100ms 后回调, prePress 和 Press 两个状态结合
        override fun onShowPress(e: MotionEvent?) {
            super.onShowPress(e)
        }

        //按下抬起时回调, 相当于单击,长按时间内抬起, 返回值无效, 系统做报错记录用， 双击会多次回调
        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            return super.onSingleTapUp(e)
        }

        //按下 500ms 时回调
        override fun onLongPress(e: MotionEvent?) {
            super.onLongPress(e)
            //可设置是否开启长按
//            gestureDetector.setIsLongpressEnabled(false)
        }

        //双击, 是另一个监听器, 两次按下间隔300ms，大于40ms， 防手抖
        override fun onDoubleTap(e: MotionEvent): Boolean {
            isBig = !isBig
            if (isBig) {
                //计算偏移的初始值, 放大后点击的点的位置随着放大倍数变大, 需计算出放大后位置与放大前位置的差值,
                //也就是偏移的值, 需要减去这个偏移值, 所以是 1 - 放大系数
                offsetX = (e.x - width / 2) * (1 - bigScale / smallScale)
                offsetY = (e.y - height / 2) * (1 - bigScale / smallScale)
                //位置修正
                fixOffset()
                scaleAnimator.start()

            } else {
                scaleAnimator.reverse()
            }
            return true
        }

        //双击后的事件序列
        override fun onDoubleTapEvent(e: MotionEvent): Boolean {
            return super.onDoubleTapEvent(e)
        }

        //单击，确认非双击， 300ms判断机制，时间上不够及时，支持双击时实用此方法
        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            return super.onSingleTapConfirmed(e)
        }

        //滚动时回调, 手指移动时触发
        override fun onScroll(
            //按下事件
            downEvent: MotionEvent,
            //当前事件
            currentEvent: MotionEvent,
            //移动距离,注意是: 初始 - 当前的值
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            if (isBig) {
                offsetX -= distanceX
                offsetY -= distanceY
                fixOffset()
                invalidate()
            }
            return false
        }

        //手指快滑时松手,
        override fun onFling(
            //按下事件
            downEvent: MotionEvent,
            //当前事件
            currentEvent: MotionEvent,
            //速率
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            if (isBig) {
                overScroller.fling(
                    //定义中心点为原点， 那么偏移值就是当前的起点了
                    offsetX.toInt(),
                    offsetY.toInt(),
                    //设置速率
                    velocityX.toInt(),
                    velocityY.toInt(),
                    //图片放大后尺寸 - view尺寸  的一半
                    (-(bitmap.width * bigScale - width) / 2).toInt(),
                    ((bitmap.width * bigScale - width) / 2).toInt(),
                    (-(bitmap.height * bigScale - height) / 2).toInt(),
                    ((bitmap.height * bigScale - height) / 2).toInt()
                    //可超出区域
//                    ,40.dp.toInt(), 40.dp.toInt()
                )

                //下一帧推到主线程
                ViewCompat.postOnAnimation(this@ScalableImageView, flingRunnable)
                //立即推到主线程
                post(flingRunnable)
            }
            return false
        }
    }

    inner class FlingRunnable : Runnable {
        override fun run() {
            //计算滚动偏移
            if (overScroller.computeScrollOffset()) {
                offsetX = overScroller.currX.toFloat()
                offsetY = overScroller.currY.toFloat()
                invalidate()
                ViewCompat.postOnAnimation(this@ScalableImageView, flingRunnable)
            }
        }
    }
}