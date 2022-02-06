package com.life.jorange.custom.graph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.life.jorange.databinding.ActivityGraphMeasureBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:图形的位置和尺寸测量
 */
class GraphMeasureActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGraphMeasureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGraphMeasureBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}