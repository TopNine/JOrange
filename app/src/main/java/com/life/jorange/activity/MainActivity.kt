package com.life.jorange.activity

import com.life.jorange.anim.ViewAnimatorActivity
import com.life.jorange.base.ID_ANIMATOR_LAYOUT
import com.life.jorange.base.ID_CONSTRAINT_LAYOUT
import com.life.jorange.base.ID_CUSTOM_LIST
import com.life.jorange.base.ID_KOTLIN
import com.life.jorange.custom.CustomListActivity
import com.life.jorange.entity.ListInfo
import com.life.jorange.kotlin.KotlinActivity
import com.life.jorange.utils.launchActivity

class MainActivity : BaseListActivity() {

    override fun handleItemClick(listInfo: ListInfo) {
        when (listInfo.id) {
            ID_CONSTRAINT_LAYOUT -> launchActivity<ConstraintLayoutActivity>()
            ID_CUSTOM_LIST -> launchActivity<CustomListActivity>()
            ID_KOTLIN -> launchActivity<KotlinActivity>()
            ID_ANIMATOR_LAYOUT -> launchActivity<ViewAnimatorActivity>()
        }
    }
}