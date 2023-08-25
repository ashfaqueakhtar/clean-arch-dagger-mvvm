package com.example.dagger2exmp.presentation.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetModule::class,
        AppModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,

        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
}