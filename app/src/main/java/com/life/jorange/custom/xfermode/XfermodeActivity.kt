package com.life.jorange.custom.xfermode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.life.jorange.databinding.ActivityXfermodeBinding

/**
 * create time: 2022/2/5
 * Descrite:
 */
class XfermodeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityXfermodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXfermodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}