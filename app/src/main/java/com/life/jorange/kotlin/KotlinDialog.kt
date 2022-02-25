package com.life.jorange.kotlin

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogKotlinBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class KotlinDialog(context2: Context) : BaseDialogFragment<DialogKotlinBinding>(context2) {
    override fun getChildViewBinding(): DialogKotlinBinding {
        return DialogKotlinBinding.inflate(layoutInflater)
    }

    override fun handleView() {
    }
}