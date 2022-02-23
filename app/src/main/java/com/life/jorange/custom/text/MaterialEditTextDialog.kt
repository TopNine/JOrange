package com.life.jorange.custom.text

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogMaterialEditTextBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class MaterialEditTextDialog(context2: Context) : BaseDialogFragment<DialogMaterialEditTextBinding>(context2 ) {
    override fun getChildViewBinding(): DialogMaterialEditTextBinding {
        return DialogMaterialEditTextBinding.inflate(layoutInflater)
    }

    override fun handleView() {
    }
}