package com.example.dagger2exmp.presentation

import android.app.Application
import com.example.dagger2exmp.BuildConfig
import com.example.dagger2exmp.presentation.di.Injector
import com.example.dagger2exmp.presentation.di.artist.ArtistSubComponent
import com.example.dagger2exmp.presentation.di.core.AppComponent
import com.example.dagger2exmp.presentation.di.core.AppModule
import com.example.dagger2exmp.presentation.di.core.DaggerAppComponent
import com.example.dagger2exmp.presentation.di.core.NetModule
import com.example.dagger2exmp.presentation.di.core.RemoteDataModule
import com.example.dagger2exmp.presentation.di.movie.MovieSubComponent
import com.example.dagger2exmp.presentation.di.tvShow.TvSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}