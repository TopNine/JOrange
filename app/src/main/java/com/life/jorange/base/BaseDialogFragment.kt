package com.life.jorange.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.life.jorange.R
import com.life.jorange.databinding.DialogBaseBinding

/**
 * create time: 2022/2/15
 * Descrite:
 */
abstract class BaseDialogFragment<V : ViewBinding>(var context2: Context) : DialogFragment() {
    protected lateinit var binding: DialogBaseBinding
    protected lateinit var childBinding: V

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
        binding.root.setOnClickListener {
            dismissAllowingStateLoss()
        }

        val childView = getChildView(view.context)
        childView?.let {
            binding.containerView.addView(childView)
        }

        childBinding = getChildViewBinding()
        binding.containerView.addView(childBinding.root)
        binding.closeView.setOnClickListener {
            dismissAllowingStateLoss()
        }

        handleView()
    }

    abstract fun handleView()

    open fun getChildView(context: Context): View? {
        return null
    }

    abstract fun getChildViewBinding(): V

    fun showDialog() {
        show(
            (context2 as FragmentActivity).supportFragmentManager,
            this::class.simpleName
        )
    }
}