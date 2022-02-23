package com.life.jorange.custom.drawable

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogDrawableBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:同一个view的多个属性合成一个动画
 */
class DrawableDialog(context2: Context) :
    BaseDialogFragment<DialogDrawableBinding>(context2) {
    override fun getChildViewBinding(): DialogDrawableBinding {
        return DialogDrawableBinding.inflate(layoutInflater)
    }

    override fun handleView() {

    }

}