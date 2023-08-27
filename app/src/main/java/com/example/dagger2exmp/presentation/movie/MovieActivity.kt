package com.example.dagger2exmp.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger2exmp.R
import com.example.dagger2exmp.databinding.ActivityMovieBinding
import com.example.dagger2exmp.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory

    private lateinit var moviewViewModel: MovieViewModel

    private lateinit var binding: ActivityMovieBinding

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        moviewViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

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
        moviewViewModel.getMovies().observe(this, Observer {
            Log.d("TAG", "VALUEEEEE->>>> ${it?.size}")
            it?.let { list ->
                binding.progressBar.visibility = View.GONE
                adapter.setList(list)
            } ?: run {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data found", Toast.LENGTH_SHORT).show()
            }
        })
    }
}