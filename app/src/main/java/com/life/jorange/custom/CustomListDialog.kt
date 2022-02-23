package com.life.jorange.custom

import android.content.Context
import com.life.jorange.base.BaseListDialogFragment
import com.life.jorange.base.entity.ListInfo
import com.life.jorange.custom.camera.ClipCameraActivity
import com.life.jorange.custom.graph.GraphMeasureActivity
import com.life.jorange.custom.text.MaterialEditTextDialog
import com.life.jorange.custom.text.TextMeasureActivity
import com.life.jorange.custom.xfermode.XfermodeActivity
import com.life.jorange.main.activity.BaseListActivity
import com.life.jorange.utils.launchActivity

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:自定义view列表
 */

private const val ID_CUSTOM_DRAW = 22
private const val ID_XFERMODE = 23
private const val ID_TEXT_MEASURE = 24
private const val ID_CLIP_CAMERA = 25
private const val ID_MATERIAL_EDIT_TEXT = 26

class CustomListDialog(context2: Context) : BaseListDialogFragment(context2) {
    override fun getItems(): MutableList<ListInfo> {
        return getCustomList()
    }

    override fun handleItemClick(listInfo: ListInfo) {
        when (listInfo.id) {
            ID_CUSTOM_DRAW -> GraphMeasureActivity(context2).showDialog()
            ID_XFERMODE -> XfermodeActivity(context2).showDialog()
            ID_TEXT_MEASURE -> TextMeasureActivity(context2).showDialog()
            ID_CLIP_CAMERA -> ClipCameraActivity(context2).showDialog()
            ID_MATERIAL_EDIT_TEXT -> MaterialEditTextDialog(context2).showDialog()
        }
    }

    private fun getCustomList(): MutableList<ListInfo> {
        val items = mutableListOf<ListInfo>()
        items.add(ListInfo(ID_CUSTOM_DRAW, "Custom Draw"))
        items.add(ListInfo(ID_XFERMODE, "Xfermode View"))
        items.add(ListInfo(ID_TEXT_MEASURE, "Text Measure View"))
        items.add(ListInfo(ID_CLIP_CAMERA, "Clip Camera View"))
        items.add(ListInfo(ID_MATERIAL_EDIT_TEXT, "Material edit text"))
        return items
    }
}