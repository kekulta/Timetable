package com.kekulta.timetable.ui

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class DisposableActivity : AppCompatActivity() {
    private val activityDisposableScope = CompositeDisposable()
    private val disposablesMap = mutableMapOf<Any, Disposable>()

    fun setDisposable(key: Any, disposableScope: () -> (Disposable)) {
        disposablesMap[key]?.dispose()

        disposableScope.invoke().let { disposable ->
            activityDisposableScope.add(disposable)
            disposablesMap[key] = disposable
        }
    }

    fun addDisposable(disposableScope: () -> (Disposable)) {
        activityDisposableScope.add(disposableScope.invoke())
    }

    fun clearDisposable(disposable: Disposable) {
        activityDisposableScope.remove(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        activityDisposableScope.clear()
    }
}