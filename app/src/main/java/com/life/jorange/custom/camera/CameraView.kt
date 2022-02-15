package com.life.jorange.custom.camera

import android.content.Context
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp
import com.life.jorange.utils.getAvatar

/**
 * create time: 2022/2/7
 * Descrite:几何变换，过程需要反着写， 更容易理解
 */
private val BITMAP_SIZE = 200.dp
private val BITMAP_PADDING = 100.dp

class CameraView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(BITMAP_SIZE, resources)
    private val camera = Camera()

    init {
        //绕着x轴旋转，需要设置轴心, 无法设置轴心，就设置图像的轴心
        camera.rotateX(30f)
        //不同手机上显示不兼容，像素密度不同
        camera.setLocation(
            0f,
            0f,
            -6f * resources.displayMetrics.density //默认是-8，单位是英寸（72个像素），不是标准的英寸，不是像素
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //上半部分
        canvas.save()
        //把轴心移动到左上角
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-30f)
        //在旋转之前裁切
        canvas.clipRect(
            -BITMAP_SIZE, -BITMAP_SIZE, BITMAP_SIZE,
            0f
        )
        canvas.rotate(30f)
        //添加到canvas上
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()

        //下半部分
        canvas.save()
        //把轴心移动到左上角
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-30f)
        camera.applyToCanvas(canvas)
        //在旋转之前裁切
        canvas.clipRect(
            -BITMAP_SIZE, 0f, BITMAP_SIZE,
            BITMAP_SIZE
        )
        canvas.rotate(30f)
        //添加到canvas上
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()
    }
}