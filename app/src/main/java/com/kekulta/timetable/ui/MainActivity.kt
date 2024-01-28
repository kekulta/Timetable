package com.kekulta.timetable.ui


import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kekulta.timetable.App
import com.kekulta.timetable.R
import com.kekulta.timetable.data.network.retrofit.RetrofitKaiService
import com.kekulta.timetable.databinding.ActivityMainBinding
import com.kekulta.timetable.domain.extensions.observeMain
import com.kekulta.timetable.domain.viewmodel.MainViewModel
import com.kekulta.timetable.ui.recycler.week.WeekRecyclerDelegate
import javax.inject.Inject


class MainActivity : DisposableActivity() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var service: RetrofitKaiService
    private val viewModel: MainViewModel by viewModels { factory }

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)
    private val recyclerDelegate: WeekRecyclerDelegate by lazy {
        WeekRecyclerDelegate(binding.weekContainer, binding.weekTab)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.requireInstance().requireComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.parityButton.setOnClickListener {
            viewModel.onParityClick()
        }

        setDisposable("Main") {
            viewModel.distinctState.observeMain().subscribe { vo ->
                recyclerDelegate.submitList(vo.list)
            }
        }
    }
}