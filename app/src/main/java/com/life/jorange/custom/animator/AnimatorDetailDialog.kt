package com.life.jorange.custom.animator

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.ActivityAnimatorBinding
import com.life.jorange.utils.dp

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class AnimatorDetailDialog(context2: Context) : BaseDialogFragment<ActivityAnimatorBinding>(context2 ) {
    override fun getChildViewBinding(): ActivityAnimatorBinding {
        return ActivityAnimatorBinding.inflate(layoutInflater)
    }

    private fun startAnim() {
//        binding.animView.animate()
//            .translationX(200f.dp)
//            .translationY(200f.dp)
//            .scaleX(2f)
//            .scaleY(2f)
//            .rotationX(360f)
//            .alpha(0.5f)
//            .startDelay = 1000

        //每次只能操作一个属性
        val animator = ObjectAnimator.ofFloat(childBinding?.animView, "radios", 150.dp)
        animator.startDelay = 1000
        animator.start()
    }

    override fun handleView() {
        startAnim()
    }
}