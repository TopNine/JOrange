package com.life.jorange.main.activity

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogConstraintLayoutBinding

/**
 * @author: zhangly
 * create time: 2022/1/26
 * Descrite:
 */
class ConstraintLayoutDialog(context2: Context) :
    BaseDialogFragment<DialogConstraintLayoutBinding>(context2) {
    override fun getChildViewBinding(): DialogConstraintLayoutBinding {
        return DialogConstraintLayoutBinding.inflate(layoutInflater)
    }

    override fun handleView() {
    }
}