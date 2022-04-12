package com.life.jorange.event.drag.view

import android.content.ClipData
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.R
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.children

/**
 * create time: 2022/4/12
 * Descrite:
 */
class DragListenerLayout(context: Context, attrs: AttributeSet?) :
    ConstraintLayout(context, attrs) {
    private val collectListener = CollectListener()
    private val dragStart = OnLongClickListener { v ->
        val data = ClipData.newPlainText("name", v.contentDescription)
        ViewCompat.startDragAndDrop(v, data, DragShadowBuilder(v), null, 0)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        val avatarView = getChildAt(0)
        val logoView = getChildAt(1)
        val containerView = getChildAt(2)
        avatarView.setOnLongClickListener(dragStart)
        logoView.setOnLongClickListener(dragStart)
        containerView.setOnDragListener(collectListener)
    }

    inner class CollectListener : OnDragListener {
        override fun onDrag(v: View, event: DragEvent): Boolean {
            when (event.action) {
                DragEvent.ACTION_DROP -> {
                    if (v is LinearLayoutCompat) {
                        val text = event.clipData.getItemAt(0).text
                        val textView = TextView(context)
                        textView.textSize = 26f
                        textView.text = text
                        textView.setTextColor(Color.BLACK)
                        v.addView(textView)
                    }
                }
            }
            return true
        }

    }
}