package com.life.jorange.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.life.jorange.base.OnItemClickListener
import com.life.jorange.databinding.HolderMainBinding
import com.life.jorange.entity.ListInfo
import com.life.jorange.holder.BaseListViewHolder

/**
 * @author: zhangly
 * create time: 2022/1/26
 * Descrite:
 */
class BaseListAdapter(private val items: MutableList<ListInfo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var binding: HolderMainBinding

    var mClickListener: OnItemClickListener<ListInfo>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = HolderMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BaseListViewHolder(binding.root).apply {
            mItemClickListener = mClickListener
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position >= items.size) {
            return
        }

        if (holder is BaseListViewHolder) {
            holder.bindHolder(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}