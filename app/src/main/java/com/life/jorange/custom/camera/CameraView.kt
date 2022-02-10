package com.life.jorange.custom.camera

import android.content.Context
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp
import com.life.jorange.utils.getAvatar

private val BITMAP_SIZE = 200.dp
private val BITMAP_PADDING = 100.dp

/**
 * 三维变化, 代码反着思考
 * 图片翻页效果实现
 */
class CameraView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(BITMAP_SIZE, resources)
    private val camera = Camera()

    init {
        //绕着x轴旋转，需要设置轴心，camera无法设置，需要移动canvas位置
        camera.rotateX(30f)
        //兼容不同像素密度的手机, 映射图片大小，单位是英寸（72像素）
        camera.setLocation(0f, 0f, -6f * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //上半部分
        //clip 需要配置 save（），restore（）使用
        canvas.save()
        //恢复轴心
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        //canvas旋转后复位
        canvas.rotate(-30f)
        canvas.clipRect(-BITMAP_SIZE, -BITMAP_SIZE, BITMAP_SIZE, 0f)
        //裁切前canvas旋转30 °，实现斜着切
        canvas.rotate(30f)
        //移动轴心到左上角
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()

        //下半部分
        canvas.save()
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-30f)
        //camera绑定懂啊canvas上
        camera.applyToCanvas(canvas)
        canvas.clipRect(-BITMAP_SIZE, 0f, BITMAP_SIZE, BITMAP_SIZE)
        canvas.rotate(30f)
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()
    }
}