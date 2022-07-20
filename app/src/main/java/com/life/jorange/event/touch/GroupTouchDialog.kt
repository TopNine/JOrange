package com.life.jorange.event.touch

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogEventGroupTouchBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
private const val TAG = "GroupTouchDialog"

class GroupTouchDialog(context2: Context) :
    BaseDialogFragment<DialogEventGroupTouchBinding>(context2) {
    override fun getChildViewBinding(): DialogEventGroupTouchBinding {
        return DialogEventGroupTouchBinding.inflate(layoutInflater)
    }


    override fun handleView() {

    }
}