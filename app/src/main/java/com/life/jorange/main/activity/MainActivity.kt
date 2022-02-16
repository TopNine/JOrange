package com.life.jorange.main.activity

import android.os.Bundle
import com.life.jorange.base.entity.ListInfo
import com.life.jorange.custom.CustomListActivity
import com.life.jorange.custom.animator.AnimatorListDialog
import com.life.jorange.kotlin.KotlinActivity
import com.life.jorange.utils.launchActivity

private const val ID_CONSTRAINT_LAYOUT = 1
private const val ID_KOTLIN = 2
private const val ID_ANIMATOR_LAYOUT = 10
private const val ID_CUSTOM_LIST = 21

class MainActivity : BaseListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val solution = Solution()
//        val head = ListNode(1, ListNode(3, ListNode(2, null)))
//        solution.reversePrint(head)
    }

    override fun handleItemClick(listInfo: ListInfo) {
        when (listInfo.id) {
            ID_CONSTRAINT_LAYOUT -> launchActivity<ConstraintLayoutActivity>()
            ID_CUSTOM_LIST -> launchActivity<CustomListActivity>()
            ID_KOTLIN -> launchActivity<KotlinActivity>()
            ID_ANIMATOR_LAYOUT -> AnimatorListDialog(this).showDialog()
        }
    }

    override fun getItems(): MutableList<ListInfo> {
        val items = mutableListOf<ListInfo>()
        items.add(ListInfo(ID_CONSTRAINT_LAYOUT, "Constraint Layout"))
        items.add(ListInfo(ID_CUSTOM_LIST, "Custom List"))
        items.add(ListInfo(ID_KOTLIN, "Kotlin Layout"))
        items.add(ListInfo(ID_ANIMATOR_LAYOUT, "Animate List"))
        return items
    }
}