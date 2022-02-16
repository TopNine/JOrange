package com.life.jorange.custom.animator

import android.content.Context
import com.life.jorange.base.BaseListDialogFragment
import com.life.jorange.base.entity.ListInfo

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */

private const val ID_ANIMATOR_DETAIL = 11
private const val ID_ANIMATOR_DETAIL2 = 12
private const val ID_ANIMATOR_PROPERTY_HOLDER = 13

class AnimatorListDialog(context2: Context) : BaseListDialogFragment(context2) {

    override fun getItems(): MutableList<ListInfo> {
        return getAnimatorList()
    }

    override fun handleItemClick(item: ListInfo) {
        when (item.id) {
            ID_ANIMATOR_DETAIL -> AnimatorDetailDialog(context2).showDialog()
            ID_ANIMATOR_DETAIL2 -> ObjectAnimatorDialog(context2).showDialog()
            ID_ANIMATOR_PROPERTY_HOLDER -> PropertyHolderDialog(context2).showDialog()
        }
    }

    private fun getAnimatorList(): MutableList<ListInfo> {
        val items = mutableListOf<ListInfo>()
        items.add(ListInfo(ID_ANIMATOR_DETAIL, "Animate Detail"))
        items.add(ListInfo(ID_ANIMATOR_DETAIL2, "Animate Set"))
        items.add(ListInfo(ID_ANIMATOR_PROPERTY_HOLDER, "View Property Holder"))
        return items
    }
}