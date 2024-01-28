package com.kekulta.timetable

import android.app.Application
import com.kekulta.timetable.di.AppModule
import com.kekulta.timetable.di.ApplicationComponent
import com.kekulta.timetable.di.DaggerApplicationComponent

class App : Application() {
    private var appComponent: ApplicationComponent? = null

    override fun onCreate() {
        instance = this
        appComponent = initDagger()
        super.onCreate()
    }

    fun requireComponent(): ApplicationComponent =
        requireNotNull(appComponent) { "Can't not get instance of component before onCreate!" }

    private fun initDagger(): ApplicationComponent {
        return DaggerApplicationComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        private var instance: App? = null
        fun requireInstance(): App =
            requireNotNull(instance) { "Can't not get instance of application before onCreate!" }
    }
}