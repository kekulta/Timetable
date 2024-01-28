package com.kekulta.timetable.di

import com.kekulta.timetable.data.network.KaiService
import com.kekulta.timetable.data.network.Api
import com.kekulta.timetable.data.network.retrofit.RetrofitKaiApi
import com.kekulta.timetable.data.network.retrofit.RetrofitKaiService
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = Api.Common.KAI_BASE_URL

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofitKaiApi(retrofit: Retrofit): RetrofitKaiApi {
        return retrofit.create(RetrofitKaiApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitKaiService(api: RetrofitKaiApi): KaiService {
        return RetrofitKaiService(api)
    }

    @Provides
    @Singleton
    fun provideRetrofit(callAdapterFactory: CallAdapter.Factory, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .build()
    }

    @Provides
    fun provideRxJava2CallAdapterFactory(): CallAdapter.Factory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    fun provideGsonConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }
}