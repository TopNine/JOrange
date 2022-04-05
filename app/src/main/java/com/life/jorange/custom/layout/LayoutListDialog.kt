package com.life.jorange.custom.layout

import android.content.Context
import com.life.jorange.base.BaseListDialogFragment
import com.life.jorange.base.entity.ListInfo

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */

private const val ID_SQUARE_LAYOUT = 11
private const val ID_LAYOUT_CIRCLE_VIEW = 12
private const val ID_LAYOUT_TAG_VIEW = 13

class LayoutListDialog(context2: Context) : BaseListDialogFragment(context2) {

    override fun getItems(): MutableList<ListInfo> {
        return getLayoutList()
    }

    override fun handleItemClick(item: ListInfo) {
        when (item.id) {
            ID_SQUARE_LAYOUT -> LayoutImageViewDialog(context2).showDialog()
            ID_LAYOUT_CIRCLE_VIEW -> LayoutViewDialog(context2).showDialog()
            ID_LAYOUT_TAG_VIEW -> LayoutTagViewDialog(context2).showDialog()
        }
    }

    private fun getLayoutList(): MutableList<ListInfo> {
        val items = mutableListOf<ListInfo>()
        items.add(ListInfo(ID_SQUARE_LAYOUT, "ImageView Measure"))
        items.add(ListInfo(ID_LAYOUT_CIRCLE_VIEW, "View Measure"))
        items.add(ListInfo(ID_LAYOUT_TAG_VIEW, "ViewGroup Measure"))
        return items
    }
}