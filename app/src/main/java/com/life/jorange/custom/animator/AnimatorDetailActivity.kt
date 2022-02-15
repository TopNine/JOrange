package com.life.jorange.custom.animator

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.life.jorange.databinding.ActivityAnimatorBinding
import com.life.jorange.utils.dp

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class AnimatorDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startAnim()
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
        val animator = ObjectAnimator.ofFloat(binding.animView, "radios", 150.dp)
        animator.startDelay = 1000
        animator.start()
    }
}