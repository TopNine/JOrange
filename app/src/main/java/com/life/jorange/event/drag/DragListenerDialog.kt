package com.life.jorange.event.drag

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogEventDragListenerBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
private const val TAG = "DragListenerDialog"
class DragListenerDialog(context2: Context) :
    BaseDialogFragment<DialogEventDragListenerBinding>(context2) {
    override fun getChildViewBinding(): DialogEventDragListenerBinding {
        return DialogEventDragListenerBinding.inflate(layoutInflater)
    }

    override fun handleView() {

    }
}