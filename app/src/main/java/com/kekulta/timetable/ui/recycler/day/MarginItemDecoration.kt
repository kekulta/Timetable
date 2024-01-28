package com.kekulta.timetable.ui.recycler.day

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kekulta.timetable.ui.extensions.dp

class MarginItemDecoration(
    private val rightMargin: Double,
    private val topMargin: Double,
    private val bottomMargin: Double,
    private val leftMargin: Double,
) : RecyclerView.ItemDecoration() {

    constructor(margins: Double) : this(margins, margins, margins, margins)

    constructor(verticalMargins: Double, horizontalMargins: Double) : this(
        horizontalMargins, verticalMargins, horizontalMargins, verticalMargins
    )

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) {
                top = topMargin.dp.toInt()
            }
            left = leftMargin.dp.toInt()
            right = rightMargin.dp.toInt()
            bottom = bottomMargin.dp.toInt()
        }
    }
}