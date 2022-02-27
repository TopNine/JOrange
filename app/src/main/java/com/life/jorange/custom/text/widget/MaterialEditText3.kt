package com.life.jorange.custom.text.widget

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.life.jorange.R
import com.life.jorange.utils.dp

/**
 * create time: 2022/2/25
 * Descrite:
 */
private val TEXT_SIZE = 12.dp
private val TEXT_MARGIN = 8.dp
private val HORIZONTAL_OFFSET = 5.dp
private val VERTICAL_OFFSET = 20.dp
private val EXTRA_VERTICAL_OFFSET = 10.dp

class MaterialEditText3(context: Context, attrs: AttributeSet) : AppCompatEditText(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = TEXT_SIZE
        color = Color.RED
    }

    var userFloatingLabel3 = false
        set(value) {
            if (field == value) {
                return
            }

            field = value

            if (field) {
                setPadding(
                    paddingLeft,
                    (paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(), paddingRight, paddingBottom
                )
            } else {
                setPadding(
                    paddingLeft,
                    (paddingTop - TEXT_SIZE - TEXT_MARGIN).toInt(), paddingRight, paddingBottom
                )
            }

        }
    private var floatingLabelShown = false

    var floatingLabelFraction = 0f
        set(value) {
            field = value
            invalidate()
        }

    private val animator = ObjectAnimator.ofFloat(this, "floatingLabelFraction", 0f, 1f)

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialEditText3)
        userFloatingLabel3 =
            typedArray.getBoolean(R.styleable.MaterialEditText3_userFloatingLabel3, true);
        typedArray.recycle()
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if (floatingLabelShown && text.isNullOrEmpty()) {
            floatingLabelShown = false
            animator.reverse()
        } else if (!floatingLabelShown && !text.isNullOrEmpty()) {
            floatingLabelShown = true

            animator.start()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (userFloatingLabel3) {
            paint.alpha = (floatingLabelFraction * 0xff).toInt()
            val verticalOffset =
                VERTICAL_OFFSET + EXTRA_VERTICAL_OFFSET * (1 - floatingLabelFraction)
            canvas.drawText(hint.toString(), HORIZONTAL_OFFSET, verticalOffset, paint)
        }
    }
}