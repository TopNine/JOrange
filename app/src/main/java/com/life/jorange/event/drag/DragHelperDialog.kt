package com.life.jorange.event.drag

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogEventDragBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
private const val TAG = "DragHelperDialog"
class DragHelperDialog(context2: Context) :
    BaseDialogFragment<DialogEventDragBinding>(context2) {
    override fun getChildViewBinding(): DialogEventDragBinding {
        return DialogEventDragBinding.inflate(layoutInflater)
    }


    override fun handleView() {

    }
}