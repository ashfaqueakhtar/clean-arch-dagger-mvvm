package com.example.dagger2exmp.presentation.tvShows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.dagger2exmp.R
import com.example.dagger2exmp.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }
}