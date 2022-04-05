package com.life.jorange.event.multi

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogEventMultiBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
private const val TAG = "EventMultiDialog"

class EventMultiDialog(context2: Context) :
    BaseDialogFragment<DialogEventMultiBinding>(context2) {
    override fun getChildViewBinding(): DialogEventMultiBinding {
        return DialogEventMultiBinding.inflate(layoutInflater)
    }


    override fun handleView() {
    }
}