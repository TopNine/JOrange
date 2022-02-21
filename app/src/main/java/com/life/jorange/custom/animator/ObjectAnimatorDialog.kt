package com.life.jorange.custom.animator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.ActivityAnimator2Binding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:AnimSet 可以将多个动画组合执行
 */
class ObjectAnimatorDialog(context2: Context) : BaseDialogFragment<ActivityAnimator2Binding>(context2) {

    private fun startAnim() {
        val bottomFlipAnimator = ObjectAnimator.ofFloat(childBinding.animView, "bottomFlip", 60f)
        bottomFlipAnimator.duration = 1000
        bottomFlipAnimator.startDelay = 1000

        val flipRotationAnimator =
            ObjectAnimator.ofFloat(childBinding.animView, "flipRotation", 270f)
        flipRotationAnimator.duration = 1000
        flipRotationAnimator.startDelay = 200

        val topFlipAnimator = ObjectAnimator.ofFloat(childBinding.animView, "topFlip", -60f)
        topFlipAnimator.startDelay = 200
        topFlipAnimator.duration = 1000

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator)
        animatorSet.start()
    }

    override fun handleView() {
        startAnim()
    }

    override fun getChildViewBinding(): ActivityAnimator2Binding {
        return ActivityAnimator2Binding.inflate(layoutInflater)
    }
}