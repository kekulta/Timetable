package com.kekulta.timetable.ui.recycler.week

import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class PagerSnapHelperWithCallback(
    private val callback: (Int) -> (Unit)
) : PagerSnapHelper() {
    override fun findTargetSnapPosition(
        layoutManager: RecyclerView.LayoutManager?,
        velocityX: Int,
        velocityY: Int
    ): Int {
        val target = super.findTargetSnapPosition(layoutManager, velocityX, velocityY)
        callback.invoke(target)
        return target
    }
}