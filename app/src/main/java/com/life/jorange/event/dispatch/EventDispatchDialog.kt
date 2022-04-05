package com.life.jorange.event.dispatch

import android.content.Context
import android.util.Log
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.DialogEventDispatchBinding
import java.util.*

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
private const val TAG = "EventDispatchDialog"

class EventDispatchDialog(context2: Context) :
    BaseDialogFragment<DialogEventDispatchBinding>(context2) {
    override fun getChildViewBinding(): DialogEventDispatchBinding {
        return DialogEventDispatchBinding.inflate(layoutInflater)
    }


    override fun handleView() {
        val list = mutableListOf<Int>()
        list.add(1)
        list.add(1)
        list.add(2)
        list.add(2)

        val indexOf = list.indexOf(0)
        val lastIndexOf = list.lastIndexOf(1)
        Log.d(TAG, "handleView: $indexOf , last index of $lastIndexOf")
        val array  = intArrayOf(1,1,2,2)
        listOf(array)
    }
}