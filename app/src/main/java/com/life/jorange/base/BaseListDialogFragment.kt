package com.life.jorange.base

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.life.jorange.base.adapter.BaseListAdapter
import com.life.jorange.base.entity.ListInfo
import com.life.jorange.databinding.DialogBaseListBinding

/**
 * create time: 2022/2/15
 * Descrite:
 */
open class BaseListDialogFragment(context2: Context) :
    BaseDialogFragment<DialogBaseListBinding>(context2) {
    override fun getChildViewBinding(): DialogBaseListBinding {
        return DialogBaseListBinding.inflate(layoutInflater)
    }

    override fun handleView() {
        childBinding.root.apply {
            val baseAdapter = BaseListAdapter(getItems())
            baseAdapter.mClickListener = object : OnItemClickListener<ListInfo> {
                override fun onItemClick(t: ListInfo) {
                    handleItemClick(t)
                }
            }
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            layoutManager = LinearLayoutManager(context)
            adapter = baseAdapter
        }

        childBinding.root.setOnClickListener {
            dismissAllowingStateLoss()
        }
    }

    open fun handleItemClick(item: ListInfo) {
    }

    open fun getItems(): MutableList<ListInfo> {
        return mutableListOf()
    }
}