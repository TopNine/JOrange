package com.life.jorange.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.life.jorange.base.OnItemClickListener
import com.life.jorange.databinding.HolderMainBinding
import com.life.jorange.entity.MainInfo
import com.life.jorange.holder.MainViewHolder

/**
 * @author: zhangly
 * create time: 2022/1/26
 * Descrite:
 */
class MainAdapter(private val items: MutableList<MainInfo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var binding: HolderMainBinding

    var mClickListener: OnItemClickListener<MainInfo>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = HolderMainBinding.inflate(LayoutInflater.from(parent.context))
        return MainViewHolder(binding.root).apply {
            mItemClickListener = mClickListener
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MainViewHolder) {
            holder.bindHolder(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}