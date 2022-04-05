package com.life.jorange.event

import android.content.Context
import com.life.jorange.base.BaseListDialogFragment
import com.life.jorange.base.entity.ListInfo
import com.life.jorange.event.dispatch.EventDispatchDialog
import com.life.jorange.event.gesture.EventGestureDialog
import com.life.jorange.event.multi.EventMultiDialog
import com.life.jorange.event.multi.EventMultiDialog2
import com.life.jorange.event.multi.EventMultiDialog3

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:事件消费
 */

private const val ID_EVENT_DISPATCH = 11
private const val ID_EVENT_GESTURE = 12
private const val ID_EVENT_MULTI = 13
private const val ID_EVENT_MULTI_2 = 14
private const val ID_EVENT_MULTI_3 = 15

class EventListDialog(context2: Context) : BaseListDialogFragment(context2) {

    override fun getItems(): MutableList<ListInfo> {
        return getEventList()
    }

    override fun handleItemClick(item: ListInfo) {
        when (item.id) {
            ID_EVENT_DISPATCH -> EventDispatchDialog(context2).showDialog()
            ID_EVENT_GESTURE -> EventGestureDialog(context2).showDialog()
            ID_EVENT_MULTI -> EventMultiDialog(context2).showDialog()
            ID_EVENT_MULTI_2 -> EventMultiDialog2(context2).showDialog()
            ID_EVENT_MULTI_3 -> EventMultiDialog3(context2).showDialog()
        }
    }

    private fun getEventList(): MutableList<ListInfo> {
        val items = mutableListOf<ListInfo>()
        items.add(ListInfo(ID_EVENT_DISPATCH, "Event Dispatch"))
        items.add(ListInfo(ID_EVENT_GESTURE, "Event Gesture"))
        items.add(ListInfo(ID_EVENT_MULTI, "Event Multi 接力型"))
        items.add(ListInfo(ID_EVENT_MULTI_2, "Event Multi 配合型"))
        items.add(ListInfo(ID_EVENT_MULTI_3, "Event Multi 各自为战型"))
        return items
    }
}