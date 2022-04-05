package com.life.jorange.custom.layout

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogLayoutImageBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class LayoutImageViewDialog(context2: Context) :
    BaseDialogFragment<DialogLayoutImageBinding>(context2) {
    override fun getChildViewBinding(): DialogLayoutImageBinding {
        return DialogLayoutImageBinding.inflate(layoutInflater)
    }


    override fun handleView() {
    }
}