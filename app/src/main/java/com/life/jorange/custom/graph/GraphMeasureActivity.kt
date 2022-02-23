package com.life.jorange.custom.graph

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.ActivityGraphMeasureBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:图形的位置和尺寸测量
 */
class GraphMeasureActivity(context2: Context) :
    BaseDialogFragment<ActivityGraphMeasureBinding>(context2) {
    override fun getChildViewBinding(): ActivityGraphMeasureBinding {
        return ActivityGraphMeasureBinding.inflate(layoutInflater)
    }

    override fun handleView() {

    }
}