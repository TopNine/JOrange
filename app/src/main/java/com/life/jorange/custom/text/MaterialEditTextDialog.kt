package com.life.jorange.custom.text

import android.content.Context
import androidx.core.view.postDelayed
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogMaterialEditTextBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class MaterialEditTextDialog(context2: Context) :
    BaseDialogFragment<DialogMaterialEditTextBinding>(context2) {
    override fun getChildViewBinding(): DialogMaterialEditTextBinding {
        return DialogMaterialEditTextBinding.inflate(layoutInflater)
    }

    override fun handleView() {
//        childBinding.materialEditText.userFloatingLabel = true
        childBinding.materialEditText.postDelayed(3000) {
//            childBinding.materialEditText.userFloatingLabel = false
        }
    }
}