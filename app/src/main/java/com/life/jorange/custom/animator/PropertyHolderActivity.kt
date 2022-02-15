package com.life.jorange.custom.animator

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.LayoutInflater
import com.life.jorange.base.BaseActivity
import com.life.jorange.databinding.ActivityPropertyHolderBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class PropertyHolderActivity : BaseActivity<ActivityPropertyHolderBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startAnim()
    }

    private fun startAnim() {
        val bottomFlipHolder = PropertyValuesHolder.ofFloat("bottomFlip", 60f)
        val flipRotationHolder = PropertyValuesHolder.ofFloat("flipRotation", 270f)
        val topFlipHolder = PropertyValuesHolder.ofFloat("topFlip", -60f)
        val holderAnimator = ObjectAnimator.ofPropertyValuesHolder(
            binding.animView,
            bottomFlipHolder,
            flipRotationHolder,
            topFlipHolder
        )

        holderAnimator.startDelay = 1000
        holderAnimator.duration = 2000
        holderAnimator.start()
    }

    override fun getViewBinding(layoutInflater: LayoutInflater): ActivityPropertyHolderBinding {
        return ActivityPropertyHolderBinding.inflate(layoutInflater)
    }
}