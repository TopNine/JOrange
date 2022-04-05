package com.life.jorange.event.multi

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogEventMultiEx3Binding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
private const val TAG = "EventMultiDialog3"

class EventMultiDialog3(context2: Context) :
    BaseDialogFragment<DialogEventMultiEx3Binding>(context2) {
    override fun getChildViewBinding(): DialogEventMultiEx3Binding {
        return DialogEventMultiEx3Binding.inflate(layoutInflater)
    }


    override fun handleView() {
    }
}