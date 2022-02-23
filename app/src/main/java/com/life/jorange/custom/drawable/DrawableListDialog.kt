package com.life.jorange.custom.drawable

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import com.life.jorange.base.BaseListDialogFragment
import com.life.jorange.base.entity.ListInfo
import com.life.jorange.utils.dp

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:Drawable 和 Bitmap的区别
 * Bitmap : 像素数据的映射，到内存对象中
 * Drawable: 是一种绘制规则， 在canvas上层， 可以调用canvas进行绘制， 相当于view的职责， 只是view可以测量，绘制，布局，
 * drawable只能够进行绘制
 *
 * 互转：通常是创建新的对象，重新进行绘制
 *
 */

private const val ID_DRAWABLE = 11
private const val ID_BITMAP = 12

class DrawableListDialog(context2: Context) : BaseListDialogFragment(context2) {

    override fun getItems(): MutableList<ListInfo> {
        return getDrawableList()
    }

    override fun handleItemClick(item: ListInfo) {
        when (item.id) {
            ID_DRAWABLE -> DrawableDialog(context2).showDialog()
            ID_BITMAP -> BitmapDialog(context2).showDialog()
        }

//        val bitmap = Bitmap.createBitmap(20.dp.toInt(), 20.dp.toInt(), Bitmap.Config.ARGB_8888)
//        bitmap.toDrawable(resources)
//
//        val drawable = BitmapDrawable()
//        drawable.toBitmap(20, 20, Bitmap.Config.ARGB_8888)
    }

    private fun getDrawableList(): MutableList<ListInfo> {
        val items = mutableListOf<ListInfo>()
        items.add(ListInfo(ID_DRAWABLE, "Drawable Detail"))
        items.add(ListInfo(ID_BITMAP, "Bitmap Detail"))
        return items
    }
}