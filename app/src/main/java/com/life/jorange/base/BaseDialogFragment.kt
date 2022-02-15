package com.life.jorange.base

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.life.jorange.R
import com.life.jorange.databinding.DialogBaseBinding
import com.life.jorange.utils.screenHeight
import com.life.jorange.utils.screenWidth

/**
 * create time: 2022/2/15
 * Descrite:
 */
open class BaseDialogFragment<V : ViewBinding> : DialogFragment() {
    protected lateinit var binding: DialogBaseBinding
    protected var childBinding: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.base_dialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogBaseBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val childView = getChildView(view.context)
        childView?.let {
            binding.root.addView(childView)
        }

        childBinding = getChildViewBinding()
        childBinding?.let {
            binding.root.addView(childBinding?.root)
        }
        binding.root.setOnClickListener {
            dismissAllowingStateLoss()
        }

        handleView()
    }

    open fun handleView() {

    }

    open fun getChildView(context: Context): View? {
        return null
    }

    open fun getChildViewBinding(): V? {
        return null
    }
}