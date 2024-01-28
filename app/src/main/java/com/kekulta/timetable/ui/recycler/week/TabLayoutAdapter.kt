package com.kekulta.timetable.ui.recycler.week

import com.google.android.material.tabs.TabLayout

class TabLayoutAdapter(
    private val tabLayout: TabLayout,
    private val onSelectedCallback: (Int) -> (Unit)
) {
    private data class Tab(val index: Int, val label: String)

    init {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                onSelectedCallback.invoke(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // NO-OP
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // NO-OP
            }
        })
    }

    fun submitList(list: List<String>) {
        val newTabs = list.mapIndexed() { index, label -> Tab(index, label) }.toSet()
        val oldTabs = buildSet {
            repeat(tabLayout.tabCount) { pos ->
                add(Tab(pos, requireNotNull(tabLayout.getTabAt(pos)).text?.toString() ?: ""))
            }
        }

        (oldTabs - newTabs).forEach { tab ->
            tabLayout.removeTabAt(tab.index)
        }
        (newTabs - oldTabs).forEach { tab ->
            tabLayout.addTab(tabLayout.newTab().apply { text = tab.label })
        }
    }

    fun selectTab(position: Int) {
        if (tabLayout.selectedTabPosition != position) {
            tabLayout.getTabAt(position)?.select()
        }
    }
}