package com.life.jorange.generics;

import android.content.Context;

import androidx.annotation.NonNull;

import com.life.jorange.base.BaseDialogFragment;
import com.life.jorange.databinding.DialogGenericMethodBinding;

/**
 * create time: 2022/6/4
 * Descrite:
 */
class GenericMethodDialog extends BaseDialogFragment<DialogGenericMethodBinding> {
    public GenericMethodDialog(@NonNull Context context2) {
        super(context2);
    }

    @NonNull
    @Override
    public DialogGenericMethodBinding getChildViewBinding() {
        return DialogGenericMethodBinding.inflate(getLayoutInflater());
    }

    @Override
    public void handleView() {
        
    }
}
