package com.life.jorange.main.activity

import com.life.jorange.base.entity.ListInfo
import com.life.jorange.custom.CustomListDialog
import com.life.jorange.custom.animator.AnimatorListDialog
import com.life.jorange.custom.drawable.DrawableListDialog
import com.life.jorange.kotlin.KotlinDialog

private const val ID_CONSTRAINT_LAYOUT = 1
private const val ID_KOTLIN = 2
private const val ID_ANIMATOR_LAYOUT = 10
private const val ID_CUSTOM_LIST = 21
private const val ID_DRAWABLE_LIST = 22

class MainActivity : BaseListActivity() {
    override fun handleItemClick(listInfo: ListInfo) {
        when (listInfo.id) {
            ID_CONSTRAINT_LAYOUT -> ConstraintLayoutDialog(this).showDialog()
            ID_CUSTOM_LIST -> CustomListDialog(this).showDialog()
            ID_KOTLIN -> KotlinDialog(this).showDialog()
            ID_ANIMATOR_LAYOUT -> AnimatorListDialog(this).showDialog()
            ID_DRAWABLE_LIST -> DrawableListDialog(this).showDialog()
        }
    }

    override fun getItems(): MutableList<ListInfo> {
        val items = mutableListOf<ListInfo>()
        items.add(ListInfo(ID_CONSTRAINT_LAYOUT, "Constraint Layout"))
        items.add(ListInfo(ID_CUSTOM_LIST, "Custom List"))
        items.add(ListInfo(ID_KOTLIN, "Kotlin Layout"))
        items.add(ListInfo(ID_ANIMATOR_LAYOUT, "Animate List"))
        items.add(ListInfo(ID_DRAWABLE_LIST, "Drawable List"))
        return items
    }
}