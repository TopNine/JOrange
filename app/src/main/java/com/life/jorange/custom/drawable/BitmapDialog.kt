package com.life.jorange.custom.drawable

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogBitmapBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:同一个view的多个属性合成一个动画
 */
class BitmapDialog(context2: Context) :
    BaseDialogFragment<DialogBitmapBinding>(context2) {
    override fun getChildViewBinding(): DialogBitmapBinding {
        return DialogBitmapBinding.inflate(layoutInflater)
    }

    override fun handleView() {
    }

}