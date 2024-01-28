package com.kekulta.timetable.domain.extensions

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> Observable<T>.observeMain(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.observeIo(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(Schedulers.io())
}

fun Completable.observeIo(): Completable {
    return subscribeOn(Schedulers.io()).observeOn(Schedulers.io())
}