package com.example.dagger2exmp.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2exmp.R
import com.example.dagger2exmp.databinding.ActivityMovieBinding
import com.example.dagger2exmp.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory

    lateinit var moviewViewModel: MovieViewModel

    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        moviewViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        moviewViewModel.getMovies().observe(this, Observer {
            Log.d("TAG","VALUEEEEE->>>> ")
        })
    }
}