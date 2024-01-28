package com.kekulta.timetable.domain.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class DisposableViewModel : ViewModel() {
    private val viewModelDisposableScope = CompositeDisposable()
    private val disposablesMap = mutableMapOf<Any, Disposable>()

    fun setDisposable(key: Any, disposableScope: () -> (Disposable)) {
        disposablesMap[key]?.dispose()

        disposableScope.invoke().let { disposable ->
            viewModelDisposableScope.add(disposable)
            disposablesMap[key] = disposable
        }
    }

    fun setIfDisposed(key: Any, disposableScope: () -> (Disposable)) {
        if (disposablesMap[key]?.isDisposed != false) {
            disposableScope.invoke().let { disposable ->
                viewModelDisposableScope.add(disposable)
                disposablesMap[key] = disposable
            }
        }
    }

    fun addDisposable(disposableScope: () -> (Disposable)) {
        viewModelDisposableScope.add(disposableScope.invoke())
    }

    fun clearDisposable(disposable: Disposable) {
        viewModelDisposableScope.remove(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelDisposableScope.clear()
    }
}