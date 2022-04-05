package com.life.jorange.event.gesture

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogEventGestureBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
private const val TAG = "EventGestureDialog"

class EventGestureDialog(context2: Context) :
    BaseDialogFragment<DialogEventGestureBinding>(context2) {
    override fun getChildViewBinding(): DialogEventGestureBinding {
        return DialogEventGestureBinding.inflate(layoutInflater)
    }


    override fun handleView() {
    }
}