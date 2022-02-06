package com.life.jorange.custom.text

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.life.jorange.databinding.ActivityTextMeasureBinding

/**
 * create time: 2022/2/5
 * Descrite:
 */
class TextMeasureActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTextMeasureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextMeasureBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}