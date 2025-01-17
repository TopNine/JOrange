package com.life.jorange.custom.animator

import android.animation.*
import android.content.Context
import android.util.Log
import android.view.animation.BounceInterpolator
import android.view.animation.LinearInterpolator
import com.life.jorange.R
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.ActivityAnimatorBinding
import com.life.jorange.utils.dp
import java.util.LinkedList

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
private const val TAG = "AnimatorDetailDialog"
class AnimatorDetailDialog(context2: Context) : BaseDialogFragment<ActivityAnimatorBinding>(context2) {
    override fun getChildViewBinding(): ActivityAnimatorBinding {
        return ActivityAnimatorBinding.inflate(layoutInflater)
    }

    private fun startAnim() {
        childBinding.animView.animate()
            .translationX(100f.dp)
            .translationY(100f.dp)
            .scaleX(2f)
            .scaleY(2f)
            .rotationX(360f)
            .setDuration(500)
    }

    override fun handleView() {
        childBinding.button1.setOnClickListener {
//            startAnim()
            test7()
//            test4()
//            test10()
        }

        childBinding.button2.setOnClickListener {
//            test2()
//            test8()
//            test11()
        }

        childBinding.button3.setOnClickListener {
//            test3()
            test6()
        }

        childBinding.button4.setOnClickListener {
//            test4()
            test9()
        }

        childBinding.animView.setOnClickListener {

        }

//        childBinding.animView.stateListAnimator = AnimatorInflater.loadStateListAnimator(context, R.xml.anim_scale)
        val list = LinkedList<String>()
        list.add("a")
        list.add("b")
        list.addFirst("c")
        list.add(1,"d")
        list.forEach {
            Log.d(TAG, "handleView: $it")
        }
    }

    private fun test2() {
        //每次只能操作一个属性
        val animator = ObjectAnimator.ofFloat(childBinding.animView, "translationX", 100.dp)
        val animator2 = ObjectAnimator.ofFloat(childBinding.animView, "translationY", 100.dp)
        val animator3 = ObjectAnimator.ofFloat(childBinding.animView, "scaleX", 2f)
        val animator4 = ObjectAnimator.ofFloat(childBinding.animView, "scaleY", 2f)
        val animator5 = ObjectAnimator.ofFloat(childBinding.animView, "rotationX", 360f)
        val animator6 = ObjectAnimator.ofFloat(childBinding.animView, "alpha", 0.5f)
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(animator, animator2, animator3)
//        animatorSet.startDelay = 1000
        animatorSet.start()
    }

    private fun test3() {
        //每次只能操作一个属性
        val animator = ObjectAnimator.ofFloat(childBinding.animView, "translationX", 100.dp)
        val animator2 = ObjectAnimator.ofFloat(childBinding.animView, "translationY", 100.dp)
        val animator3 = ObjectAnimator.ofFloat(childBinding.animView, "scaleX", 2f)
        val animator4 = ObjectAnimator.ofFloat(childBinding.animView, "scaleY", 2f)
        val animator5 = ObjectAnimator.ofFloat(childBinding.animView, "rotationX", 360f)
        val animator6 = ObjectAnimator.ofFloat(childBinding.animView, "alpha", 0.5f)
        val animatorSet = AnimatorSet()
        animatorSet.play(animator).with(animator2).after(animator3).with(animator4).before(animator5).after(animator6)
//        animatorSet.startDelay = 1000
        animatorSet.start()
        animatorSet.reverse()
    }

    private fun test4() {
        val animator = ObjectAnimator.ofFloat(childBinding.animView, "translationY", 200.dp)
        animator.duration = 800
        animator.interpolator = BounceInterpolator()
        animator.start()
    }

    private fun test5() {
        val holder1 = PropertyValuesHolder.ofFloat("translationX", 100.dp)
        val holder2 = PropertyValuesHolder.ofFloat("translationY", 100.dp)
        val holder3 = PropertyValuesHolder.ofFloat("scaleX", 2f)
        val holder4 = PropertyValuesHolder.ofFloat("scaleY", 2f)
        val holder5 = PropertyValuesHolder.ofFloat("rotationX", 360f)
        val holder6 = PropertyValuesHolder.ofFloat("alpha", 0.5f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(childBinding.animView, holder1, holder2, holder3, holder4, holder5, holder6)
        animator.start()
    }

    private fun test6() {
        val keyframe1 = Keyframe.ofFloat(0f, 0f)
        val keyframe2 = Keyframe.ofFloat(0.2f, 100.dp * 2f)
        val keyframe3 = Keyframe.ofFloat(0.8f, 100.dp * 1.5f)
        val keyframe4 = Keyframe.ofFloat(1.0f, 100.dp * 1f)
        val propertyValuesHolder = PropertyValuesHolder.ofKeyframe(
            "translationY", keyframe1, keyframe2, keyframe3, keyframe4
        )
        val animator = ObjectAnimator.ofPropertyValuesHolder(childBinding.animView, propertyValuesHolder)
        animator.duration = 2000
        animator.interpolator = LinearInterpolator()
        animator.start()
    }


    private fun test7() {
        (AnimatorInflater.loadAnimator(context, R.animator.anim_img) as AnimatorSet).apply {
            setTarget(childBinding.animView)
            start()
        }
    }

    private fun test8() {
    }

    private fun test9() {
        ValueAnimator.ofFloat(0f, 100.dp).apply {
            addUpdateListener { updatedAnimation ->
                childBinding.animView.translationY = updatedAnimation.animatedValue as Float
            }
            start()
        }
    }

//    private fun test10() {
//        childBinding.animView.addView(ImageView(context).apply {
//            layoutParams = LinearLayout.LayoutParams(100.dp.toInt(), 100.dp.toInt())
//            setBackgroundResource(R.drawable.common_img_2)
//        })
//    }
//
//    private fun test11() {
//        childBinding.animView.removeViewAt(childBinding.animView.childCount - 1)
//    }

}