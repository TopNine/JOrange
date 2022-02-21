package com.life.jorange.custom.animator

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.PointF
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.custom.animator.widget.PointFView
import com.life.jorange.custom.animator.widget.ProvinceView
import com.life.jorange.databinding.DialogTypeEvaluatorBinding
import com.life.jorange.utils.dp

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:估值器
 * 评估一个精确值
 * 精确计算属性每一刻的动画完成度，去算出实际属性的值
 */
class AnimTypeEvaluatorDialog(context2: Context) :
    BaseDialogFragment<DialogTypeEvaluatorBinding>(context2) {
    override fun getChildViewBinding(): DialogTypeEvaluatorBinding {
        return DialogTypeEvaluatorBinding.inflate(layoutInflater)
    }

    override fun handleView() {
        startAnim()
    }

    private fun startAnim() {
        val animator =
            ObjectAnimator.ofObject(
                childBinding.pointView, "pointF", PointFView.PointFEvaluator(),
                PointF(100.dp, 200.dp)
            )
        animator.startDelay = 1000
        animator.duration = 2000
        animator.start()

        val animator2 =
            ObjectAnimator.ofObject(
                childBinding.provinceView, "province", ProvinceView.ProvinceEvaluator(), "澳门特别行政区"
            )
        animator2.startDelay = 1000
        animator2.duration = 10000
        animator2.start()
    }
}