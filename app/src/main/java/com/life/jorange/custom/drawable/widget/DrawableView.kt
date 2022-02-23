package com.life.jorange.custom.drawable.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.life.jorange.utils.dp

/**
 * create time: 2022/2/21
 * Descrite:有canvas的地方就可以使用， 自己创建canvas也可以
 */
class DrawableView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val drawable = MeshDrawable()
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //需要设置绘制边界
        drawable.setBounds(50.dp.toInt(), 80.dp.toInt(), width, height)
        drawable.draw(canvas)

//        canvas.drawBitmap(
//            Bitmap.createBitmap(
//                50.dp.toInt(),
//                50.dp.toInt(),
//                Bitmap.Config.ARGB_8888
//            ), 0f, 0f, paint
//        )
    }
}