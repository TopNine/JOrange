package com.life.jorange.custom.text

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.ActivityTextMeasureBinding

/**
 * create time: 2022/2/5
 * Descrite:
 */
class TextMeasureActivity(context2: Context) :
    BaseDialogFragment<ActivityTextMeasureBinding>(context2) {
    override fun handleView() {

    }

    override fun getChildViewBinding(): ActivityTextMeasureBinding {
        return ActivityTextMeasureBinding.inflate(layoutInflater)
    }


}