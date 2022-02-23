package com.life.jorange.custom.camera

import android.content.Context
import com.life.jorange.base.BaseDialogFragment
import com.life.jorange.databinding.ActivityClipCameraBinding

class ClipCameraActivity(context2: Context) :
    BaseDialogFragment<ActivityClipCameraBinding>(context2) {
    override fun handleView() {

    }

    override fun getChildViewBinding(): ActivityClipCameraBinding {
        return ActivityClipCameraBinding.inflate(layoutInflater)
    }

}