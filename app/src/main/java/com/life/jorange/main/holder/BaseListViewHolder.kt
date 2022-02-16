package com.life.jorange.main.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.life.jorange.R
import com.life.jorange.base.OnItemClickListener
import com.life.jorange.base.entity.ListInfo

/**
 * @author: zhangly
 * create time: 2022/1/26
 * Descrite:
 */
class BaseListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var textView: TextView = view.findViewById(R.id.item_text)

    var mItemClickListener: OnItemClickListener<ListInfo>? = null

    fun bindHolder(listInfo: ListInfo) {
        textView.text = listInfo.name
        itemView.rootView.setOnClickListener {
            mItemClickListener?.onItemClick(listInfo)
        }
    }
}