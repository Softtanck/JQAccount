package com.openkotlin.jqacoount.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 *
 *  Current name : SpacesItemDecoration in `JQAcoount`
 *
 *  Created by Tanck on 2019-11-16 00:12.
 *
 *  Note : N/A
 *
 */
class SpacesItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.left = space
        outRect.right = space
        outRect.bottom = space

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildPosition(view) == 0)
            outRect.top = space
    }
}