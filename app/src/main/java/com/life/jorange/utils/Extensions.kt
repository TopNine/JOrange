package com.life.jorange.utils

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.TypedValue
import com.life.jorange.R

/**
 * @author: zhangly
 * create time: 2022/1/27
 * Descrite:
 */
val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

val Int.dp
    get() = this.toFloat().dp

val Float.sp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this,
        Resources.getSystem().displayMetrics
    )

val Int.sp
    get() = this.toFloat().sp

inline fun <reified T : Activity> Activity.launchActivity() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T : Activity> Activity.launchActivity(intent: Intent) {
    intent.setClass(this, T::class.java)
    startActivity(intent)
}

fun getAvatar(width: Float, resources: Resources): Bitmap {
    return getAvatar(R.drawable.avatar_rengwuxian, width, resources)
}

fun getAvatar(drawableId: Int, width: Float, resources: Resources): Bitmap {
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
    BitmapFactory.decodeResource(resources, drawableId, options)
    options.inJustDecodeBounds = false
    options.inDensity = options.outWidth
    options.inTargetDensity = width.toInt()
    return BitmapFactory.decodeResource(resources, drawableId, options)
}

val screenWidth = Resources.getSystem().displayMetrics.widthPixels
val screenHeight = Resources.getSystem().displayMetrics.heightPixels