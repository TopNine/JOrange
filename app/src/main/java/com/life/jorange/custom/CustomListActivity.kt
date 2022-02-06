package com.life.jorange.custom

import com.life.jorange.activity.BaseListActivity
import com.life.jorange.base.ID_CUSTOM_DRAW
import com.life.jorange.base.ID_CUSTOM_LIST
import com.life.jorange.base.ID_TEXT_MEASURE
import com.life.jorange.base.ID_XFERMODE
import com.life.jorange.custom.graph.GraphMeasureActivity
import com.life.jorange.custom.text.TextMeasureActivity
import com.life.jorange.custom.xfermode.XfermodeActivity
import com.life.jorange.entity.ListInfo
import com.life.jorange.utils.launchActivity
import com.life.jorange.viewmodel.getCustomList

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:自定义view列表
 */
class CustomListActivity : BaseListActivity() {
    override fun getItems(): MutableList<ListInfo> {
        return getCustomList()
    }

    override fun handleItemClick(listInfo: ListInfo) {
        when (listInfo.id) {
            ID_CUSTOM_DRAW -> launchActivity<GraphMeasureActivity>()
            ID_XFERMODE -> launchActivity<XfermodeActivity>()
            ID_TEXT_MEASURE -> launchActivity<TextMeasureActivity>()
        }
    }
}