package com.example.dagger2exmp.presentation.tvShows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger2exmp.R
import com.example.dagger2exmp.databinding.ActivityTvShowBinding
import com.example.dagger2exmp.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvViewModelFactory

    private lateinit var viewModel: TvViewModel

    private lateinit var binding: ActivityTvShowBinding

    private val adapter = TvShowAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]

        initView()
    }

    private fun initView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getTvShows().observe(this) {
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