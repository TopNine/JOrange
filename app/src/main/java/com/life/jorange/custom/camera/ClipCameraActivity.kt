package com.life.jorange.custom.camera

import com.life.jorange.databinding.ActivityClipCameraBinding
import com.life.jorange.main.activity.BaseActivity

class ClipCameraActivity : BaseActivity<ActivityClipCameraBinding>() {
    override fun getViewBinding(): ActivityClipCameraBinding {
        return ActivityClipCameraBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.root
    }
}