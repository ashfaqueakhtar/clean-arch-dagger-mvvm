package com.example.dagger2exmp.presentation.movie

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger2exmp.R
import com.example.dagger2exmp.databinding.ActivityMovieBinding
import com.example.dagger2exmp.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory

    private lateinit var movieViewModel: MovieViewModel

    private lateinit var binding: ActivityMovieBinding

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)


        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        initView()
    }


    private fun initView() {
        adapter = MovieAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(this@MovieActivity)
        binding.recyclerView.adapter = adapter

        displayPopularMovie()
    }

    private fun displayPopularMovie() {
        binding.progressBar.visibility = View.VISIBLE
        movieViewModel.getMovies().observe(this) {
            it?.let { list ->
                binding.progressBar.visibility = View.GONE
                adapter.setList(list)
            } ?: run {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}