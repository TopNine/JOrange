package com.life.jorange.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.life.jorange.R
import com.life.jorange.base.OnItemClickListener
import com.life.jorange.entity.MainInfo

/**
 * @author: zhangly
 * create time: 2022/1/26
 * Descrite:
 */
class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var textView: TextView = view.findViewById(R.id.item_text)

    var mItemClickListener: OnItemClickListener<MainInfo>? = null

    fun bindHolder(mainInfo: MainInfo) {
        textView.text = mainInfo.name
        itemView.setOnClickListener {
            mItemClickListener?.onItemClick(mainInfo)
        }
    }
}