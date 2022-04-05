package com.life.jorange.event.multi

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogEventMultiEx2Binding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
private const val TAG = "EventMultiDialog2"

class EventMultiDialog2(context2: Context) :
    BaseDialogFragment<DialogEventMultiEx2Binding>(context2) {
    override fun getChildViewBinding(): DialogEventMultiEx2Binding {
        return DialogEventMultiEx2Binding.inflate(layoutInflater)
    }

    override fun handleView() {
    }
}