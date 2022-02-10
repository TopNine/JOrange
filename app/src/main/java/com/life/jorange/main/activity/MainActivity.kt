package com.life.jorange.main.activity

import android.os.Bundle
import com.life.jorange.alg.offer.ListNode
import com.life.jorange.alg.offer.Solution
import com.life.jorange.anim.ViewAnimatorActivity
import com.life.jorange.base.ID_ANIMATOR_LAYOUT
import com.life.jorange.base.ID_CONSTRAINT_LAYOUT
import com.life.jorange.base.ID_CUSTOM_LIST
import com.life.jorange.base.ID_KOTLIN
import com.life.jorange.custom.CustomListActivity
import com.life.jorange.kotlin.KotlinActivity
import com.life.jorange.main.entity.ListInfo
import com.life.jorange.utils.launchActivity

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
            ID_ANIMATOR_LAYOUT -> launchActivity<ViewAnimatorActivity>()
        }
    }
}