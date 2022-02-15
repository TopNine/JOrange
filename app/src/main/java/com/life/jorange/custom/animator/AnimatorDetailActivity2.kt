package com.life.jorange.custom.animator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.life.jorange.base.BaseActivity
import com.life.jorange.databinding.ActivityAnimator2Binding
import com.life.jorange.utils.dp

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class AnimatorDetailActivity2 : BaseActivity<ActivityAnimator2Binding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startAnim()
    }

    private fun startAnim() {
        val bottomFlipAnimator = ObjectAnimator.ofFloat(binding.animView, "bottomFlip", 60f)
        bottomFlipAnimator.duration = 1000
        bottomFlipAnimator.startDelay = 1000

        val flipRotationAnimator = ObjectAnimator.ofFloat(binding.animView, "flipRotation", 270f)
        flipRotationAnimator.duration = 1000
        flipRotationAnimator.startDelay = 200

        val topFlipAnimator = ObjectAnimator.ofFloat(binding.animView, "topFlip", -60f)
        topFlipAnimator.startDelay = 200
        topFlipAnimator.duration = 1000

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator)
        animatorSet.start()
    }

    override fun getViewBinding(layoutInflater: LayoutInflater): ActivityAnimator2Binding {
        return ActivityAnimator2Binding.inflate(layoutInflater)
    }
}