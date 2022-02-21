package com.life.jorange.custom.animator

import android.animation.ObjectAnimator
import android.content.Context
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogKeyFrameBinding
import com.life.jorange.utils.dp

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:差值器
 * 设置一个从时间完成度到动画完成度的公式
 * 动画的速度曲线L：先快后慢， 先慢后快等等
 */
class AnimInterpolatorDialog(context2: Context) :
    BaseDialogFragment<DialogKeyFrameBinding>(context2) {
    override fun getChildViewBinding(): DialogKeyFrameBinding {
        return DialogKeyFrameBinding.inflate(layoutInflater)
    }

    override fun handleView() {
        startAnim()
    }

    private fun startAnim() {
        val animator =
            ObjectAnimator.ofFloat(childBinding.keyframeView, "translationX", 200.dp)
        animator.startDelay = 1000
        animator.duration = 2000
        animator.interpolator = AccelerateDecelerateInterpolator() //先加速后减速差值器
        animator.interpolator = AccelerateInterpolator() //加速差值器 ：出场动画
        animator.interpolator = DecelerateInterpolator() //减速差值器 ：入场动画
        animator.interpolator = LinearInterpolator() //匀速差值器 ：
        animator.start()
    }
}