package com.life.jorange.custom.animator

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogKeyFrameBinding
import com.life.jorange.utils.dp

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:关键帧
 * 对动画执行过程中精确控制
 */
class KeyFrameDialog(context2: Context) :
    BaseDialogFragment<DialogKeyFrameBinding>(context2) {
    override fun getChildViewBinding(): DialogKeyFrameBinding {
        return DialogKeyFrameBinding.inflate(layoutInflater)
    }

    override fun handleView() {
        startAnim()
    }

    private fun startAnim() {
        val keyframe1 = Keyframe.ofFloat(0f, 0f)
        val keyframe2 = Keyframe.ofFloat(0.2f, 200.dp * 1.5f)
        val keyframe3 = Keyframe.ofFloat(0.8f, 200.dp * 0.6f)
        val keyframe4 = Keyframe.ofFloat(1.0f, 200.dp * 1f)
        val propertyValuesHolder = PropertyValuesHolder.ofKeyframe(
            "translationX", keyframe1, keyframe2, keyframe3, keyframe4
        )
        val animator =
            ObjectAnimator.ofPropertyValuesHolder(childBinding.keyframeView, propertyValuesHolder)
        animator.startDelay = 1000
        animator.duration = 2000
        animator.start()
    }
}