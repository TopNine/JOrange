package com.life.jorange.generics;

import android.content.Context;

import androidx.annotation.NonNull;

import com.life.jorange.base.BaseListDialogFragment;
import com.life.jorange.base.entity.ListInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * create time: 2022/6/4
 * Descrite:
 */

public class GenericsListDialog extends BaseListDialogFragment {
    private static final int ID_METHODS = 643;

    public GenericsListDialog(@NonNull Context context2) {
        super(context2);
    }

    @Override
    public void handleItemClick(@NonNull ListInfo item) {
        super.handleItemClick(item);
        switch (item.getId()) {
            case ID_METHODS:
                new GenericMethodDialog(getContext2()).showDialog();
                break;
        }
    }

    @NonNull
    @Override
    public List<ListInfo> getItems() {
        return getGenericsItems();
    }

    private List<ListInfo> getGenericsItems() {
        List<ListInfo> items = new ArrayList<>();
        items.add(new ListInfo(ID_METHODS, "泛型方法和类型推断"));
        return items;
    }
}
