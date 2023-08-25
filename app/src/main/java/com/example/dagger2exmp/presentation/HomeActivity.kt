package com.example.dagger2exmp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.dagger2exmp.R
import com.example.dagger2exmp.databinding.ActivityHomeBinding
import com.example.dagger2exmp.presentation.artists.ArtistsActivity
import com.example.dagger2exmp.presentation.movie.MovieActivity
import com.example.dagger2exmp.presentation.tvShows.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.btArtist.setOnClickListener {
            startActivity(Intent(this, ArtistsActivity::class.java))
        }

        binding.btMovie.setOnClickListener {
            startActivity(Intent(this, MovieActivity::class.java))
        }

        binding.btTvShow.setOnClickListener {
            startActivity(Intent(this, TvShowActivity::class.java))
        }
    }


}