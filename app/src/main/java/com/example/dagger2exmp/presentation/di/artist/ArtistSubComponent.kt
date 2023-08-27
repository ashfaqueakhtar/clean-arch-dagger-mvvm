package com.example.dagger2exmp.presentation.di.artist

import com.example.dagger2exmp.presentation.artists.ArtistsActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistsActivity: ArtistsActivity)


    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}