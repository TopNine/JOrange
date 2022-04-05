package com.life.jorange.custom.layout

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogLayoutViewBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class LayoutViewDialog(context2: Context) :
    BaseDialogFragment<DialogLayoutViewBinding>(context2) {
    override fun getChildViewBinding(): DialogLayoutViewBinding {
        return DialogLayoutViewBinding.inflate(layoutInflater)
    }

    override fun handleView() {
    }
}