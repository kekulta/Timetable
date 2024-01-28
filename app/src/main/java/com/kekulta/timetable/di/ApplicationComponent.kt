package com.kekulta.timetable.di

import com.kekulta.timetable.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        MappersModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        UsecasesModule::class,
        FormattersModule::class,
        AppModule::class,
        PersistentModule::class,
    ]
)
@Singleton
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}