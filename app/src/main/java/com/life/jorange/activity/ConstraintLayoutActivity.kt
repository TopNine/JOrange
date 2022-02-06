package com.life.jorange.activity

import android.os.Bundle

/**
 * @author: zhangly
 * create time: 2022/1/26
 * Descrite:
 */
class ConstraintLayoutActivity : BaseListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = this::class.simpleName ?: "BaseListActivity"
    }
}