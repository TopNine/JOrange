package com.life.jorange.custom.xfermode

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.ActivityXfermodeBinding

/**
 * create time: 2022/2/5
 * Descrite:
 */
class XfermodeActivity(context2: Context) : BaseDialogFragment<ActivityXfermodeBinding>(context2) {
    override fun handleView() {
    }

    override fun getChildViewBinding(): ActivityXfermodeBinding {
        return ActivityXfermodeBinding.inflate(layoutInflater)
    }

}