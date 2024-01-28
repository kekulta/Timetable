package com.kekulta.timetable.ui.recycler.day

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kekulta.timetable.ui.viewobjects.TimetableItemVo

class DayRecyclerDelegate(private val recyclerView: RecyclerView) {
    private val adapter = DayRecyclerAdapter()
    private val marginDecor = MarginItemDecoration(12.0)

    init {
        recyclerView.itemAnimator = null
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(marginDecor)
        recyclerView.layoutManager =
            LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
    }

    fun submitList(list: List<TimetableItemVo>) {
        adapter.submitList(list)
    }
}