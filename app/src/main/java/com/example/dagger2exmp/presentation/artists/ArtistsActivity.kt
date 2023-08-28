package com.example.dagger2exmp.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger2exmp.R
import com.example.dagger2exmp.databinding.ActivityArtistsBinding
import com.example.dagger2exmp.presentation.di.Injector
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory

    private lateinit var viewModel: ArtistViewModel

    private lateinit var binding: ActivityArtistsBinding

    private val adapter = ArtistsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artists)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)

        (application as Injector).createArtistSubComponent().inject(this)

        viewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]

        initView()
    }

    private fun initView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getArtists().observe(this, Observer {
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