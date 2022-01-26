package com.life.jorange.viewmodel

import androidx.lifecycle.ViewModel
import com.life.jorange.base.ID_CONSTRAINT_LAYOUT
import com.life.jorange.entity.MainInfo

/**
 * @author: zhangly
 * create time: 2022/1/26
 * Descrite:
 */
fun getMainList(): MutableList<MainInfo> {
    val items = mutableListOf<MainInfo>()
    items.add(MainInfo(ID_CONSTRAINT_LAYOUT, "Constraint Layout"))
    return items
}