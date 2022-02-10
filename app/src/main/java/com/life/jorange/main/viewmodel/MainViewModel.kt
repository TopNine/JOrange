package com.life.jorange.main.viewmodel

import com.life.jorange.base.*
import com.life.jorange.main.entity.ListInfo

/**
 * @author: zhangly
 * create time: 2022/1/26
 * Descrite:
 */
fun getMainList(): MutableList<ListInfo> {
    val items = mutableListOf<ListInfo>()
    items.add(ListInfo(ID_CONSTRAINT_LAYOUT, "Constraint Layout"))
    items.add(ListInfo(ID_CUSTOM_LIST, "Custom List"))
    items.add(ListInfo(ID_KOTLIN, "Kotlin Layout"))
    items.add(ListInfo(ID_ANIMATOR_LAYOUT, "Animate List"))
    return items
}

fun getCustomList(): MutableList<ListInfo> {
    val items = mutableListOf<ListInfo>()
    items.add(ListInfo(ID_CUSTOM_DRAW, "Custom Draw"))
    items.add(ListInfo(ID_XFERMODE, "Xfermode View"))
    items.add(ListInfo(ID_TEXT_MEASURE, "Text Measure View"))
    items.add(ListInfo(ID_CLIP_CAMERA, "Clip Camera View"))
    return items
}

fun getAnimatorList(): MutableList<ListInfo> {
    val items = mutableListOf<ListInfo>()
    items.add(ListInfo(ID_ANIMATOR_DETAIL, "Animate Detail"))
    return items
}