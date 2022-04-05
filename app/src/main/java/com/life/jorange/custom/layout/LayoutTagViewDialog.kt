package com.life.jorange.custom.layout

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogLayoutTagBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class LayoutTagViewDialog(context2: Context) :
    BaseDialogFragment<DialogLayoutTagBinding>(context2) {
    override fun getChildViewBinding(): DialogLayoutTagBinding {
        return DialogLayoutTagBinding.inflate(layoutInflater)
    }

    override fun handleView() {
        childBinding.root.addTagView()
    }
}