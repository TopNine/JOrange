package com.life.jorange.anim

import com.life.jorange.base.ID_ANIMATOR_DETAIL
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
        }
    }
}