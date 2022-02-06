package com.life.jorange.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.life.jorange.databinding.ActivityKotlinBinding

/**
 * @author: zhangly
 * create time: 2022/2/4
 * Descrite:
 */
class KotlinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKotlinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        test()
    }

    private fun test() {

    }
}