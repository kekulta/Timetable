package com.kekulta.timetable.ui.recycler.week

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.kekulta.timetable.ui.viewobjects.TimetableDayVo

class WeekRecyclerDelegate(
    private val recyclerView: RecyclerView,
    private val tabLayout: TabLayout,
) {
    private val weekRecyclerAdapter = WeekRecyclerAdapter()
    private val tabLayoutAdapter = TabLayoutAdapter(tabLayout, ::onTabSelected)
    private val pagerSnapHelper = PagerSnapHelperWithCallback(tabLayoutAdapter::selectTab)
    private val layoutManager =
        LinearLayoutManager(recyclerView.context, LinearLayoutManager.HORIZONTAL, false)

    init {
        recyclerView.adapter = weekRecyclerAdapter
        pagerSnapHelper.attachToRecyclerView(recyclerView)
        recyclerView.layoutManager = layoutManager
    }

    fun submitList(list: List<TimetableDayVo>) {
        tabLayoutAdapter.submitList(extractDate(list))
        weekRecyclerAdapter.submitList(list)
    }

    private fun onTabSelected(position: Int) {
        recyclerView.smoothScrollToPosition(position)
    }

    private fun extractDate(list: List<TimetableDayVo>): List<String> {
        return list.map { vo ->
            when (vo) {
                is TimetableDayVo.Correct -> vo.date
                is TimetableDayVo.Broken -> vo.date
            }
        }
    }
}

