package com.example.dagger2exmp.presentation.di.tvShow

import com.example.dagger2exmp.presentation.tvShows.TvShowActivity
import dagger.Subcomponent

@TvScope
@Subcomponent(modules = [TvModule::class])
interface TvSubComponent {
    fun inject(tvActivity: TvShowActivity)


    @Subcomponent.Factory
    interface Factory {
        fun create(): TvSubComponent
    }
}