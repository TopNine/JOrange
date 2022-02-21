package com.life.jorange.custom.animator

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogPropertyHolderBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:同一个view的多个属性合成一个动画
 */
class PropertyHolderDialog(context2: Context) :
    BaseDialogFragment<DialogPropertyHolderBinding>(context2) {
    override fun getChildViewBinding(): DialogPropertyHolderBinding {
        return DialogPropertyHolderBinding.inflate(layoutInflater)
    }

    override fun handleView() {
        startAnim()
    }

    private fun startAnim() {
        val bottomFlipHolder = PropertyValuesHolder.ofFloat("bottomFlip", 60f)
        val flipRotationHolder = PropertyValuesHolder.ofFloat("flipRotation", 270f)
        val topFlipHolder = PropertyValuesHolder.ofFloat("topFlip", -60f)
        val holderAnimator = ObjectAnimator.ofPropertyValuesHolder(
            childBinding.animView,
            bottomFlipHolder,
            flipRotationHolder,
            topFlipHolder
        )

        holderAnimator.startDelay = 1000
        holderAnimator.duration = 2000
        holderAnimator.start()
    }
}