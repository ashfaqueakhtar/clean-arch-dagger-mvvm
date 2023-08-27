package com.example.dagger2exmp.presentation.di.tvShow

import com.example.dagger2exmp.presentation.artists.ArtistsActivity
import dagger.Subcomponent

@TvScope
@Subcomponent(modules = [TvModule::class])
interface TvSubComponent {
    fun inject(tvActivity: ArtistsActivity)


    @Subcomponent.Factory
    interface Factory {
        fun create(): TvSubComponent
    }
}