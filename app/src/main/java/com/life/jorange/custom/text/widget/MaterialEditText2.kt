package com.life.jorange.custom.text.widget

import android.animation.ObjectAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.life.jorange.R
import com.life.jorange.utils.dp

/**
 * create time: 2022/2/24
 * Descrite:
 */
private val TEXT_SIZE = 12.dp
private val TEXT_MARGIN = 8.dp
private val HORIZONTAL_OFFSET = 5.dp
private val VERTICAL_OFFSET = 23.dp
private val EXTRA_VERTICAL_OFFSET = 10.dp

class MaterialEditText2(context: Context, attrs: AttributeSet) : AppCompatEditText(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = TEXT_SIZE
    }
    var userFloatingLabel2 = false
        set(value) {
            if (value == field) {
                return
            }

            field = value

            if (field) {
                setPadding(
                    paddingLeft,
                    (paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(),
                    paddingRight,
                    paddingBottom
                )
            } else {
                setPadding(
                    paddingLeft,
                    (paddingTop - TEXT_SIZE - TEXT_MARGIN).toInt(),
                    paddingRight,
                    paddingBottom
                )
            }
        }

    private var floatingLabelShown = false

    private val animator by lazy {
        ObjectAnimator.ofFloat(this, "floatingLabelFraction", 0f, 1f)
    }

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialEditText2)
        userFloatingLabel2 =
            typedArray.getBoolean(R.styleable.MaterialEditText2_userFloatingLabel2, true)
        typedArray.recycle()
    }

    var floatingLabelFraction = 0f
        set(value) {
            field = value
            invalidate()
        }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {

        if (!userFloatingLabel2) {
            return
        }

        if (!floatingLabelShown && !text.isNullOrEmpty()) {
            floatingLabelShown = true
            animator.start()
        } else if (floatingLabelShown && text.isNullOrEmpty()) {
            floatingLabelShown = false
            animator.reverse()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.alpha = (floatingLabelFraction * 0xff).toInt()
        val currentVerticalValue =
            VERTICAL_OFFSET + EXTRA_VERTICAL_OFFSET * (1 - floatingLabelFraction)
        canvas.drawText(
            hint.toString(),
            HORIZONTAL_OFFSET, currentVerticalValue, paint
        )
    }
}