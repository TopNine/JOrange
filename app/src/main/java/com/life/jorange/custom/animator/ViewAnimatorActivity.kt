package com.life.jorange.custom.animator

import com.life.jorange.base.ID_ANIMATOR_DETAIL
import com.life.jorange.base.ID_ANIMATOR_DETAIL2
import com.life.jorange.base.ID_ANIMATOR_PROPERTY_HOLDER
import com.life.jorange.main.activity.BaseListActivity
import com.life.jorange.main.entity.ListInfo
import com.life.jorange.main.viewmodel.getAnimatorList
import com.life.jorange.utils.launchActivity

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class ViewAnimatorActivity : BaseListActivity() {

    override fun getItems(): MutableList<ListInfo> {
        return getAnimatorList()
    }

    override fun handleItemClick(listInfo: ListInfo) {
        when (listInfo.id) {
            ID_ANIMATOR_DETAIL -> launchActivity<AnimatorDetailActivity>()
            ID_ANIMATOR_DETAIL2 -> launchActivity<AnimatorDetailActivity2>()
            ID_ANIMATOR_PROPERTY_HOLDER -> showDialog()
        }
    }

    fun showDialog() {
        PropertyHolderDialog().run { show(supportFragmentManager, "property_holder_dialog") }
    }
}