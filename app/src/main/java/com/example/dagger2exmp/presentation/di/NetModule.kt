package com.example.dagger2exmp.presentation.di

import com.example.dagger2exmp.data.api.AppService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()


    @Singleton
    @Provides
    fun provideAppService(retrofit: Retrofit): AppService {
        return retrofit.create(AppService::class.java)
    }
}