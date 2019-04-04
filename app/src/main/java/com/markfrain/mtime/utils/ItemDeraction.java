package com.markfrain.mtime.utils;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemDeraction extends RecyclerView.ItemDecoration {
    private int div;

    public ItemDeraction(int div) {
        super();
        this.div = div;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = div;
    }
}
