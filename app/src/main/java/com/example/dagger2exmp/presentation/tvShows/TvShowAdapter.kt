package com.example.dagger2exmp.presentation.tvShows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dagger2exmp.R
import com.example.dagger2exmp.data.model.tv.Tv
import com.example.dagger2exmp.databinding.ListItemBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {
    private val mList = ArrayList<Tv>()


    inner class MyViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: Tv) {
            binding.titleTextView.text = tv.name
            binding.descriptionTextView.text = tv.overview
            val posterUrl = "https://image.tmdb.org/t/p/w500/" + tv.posterPath
            Glide.with(binding.imageView.context)
                .load(posterUrl)
                .into(binding.imageView)
        }
    }

    fun setList(list: List<Tv>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tv = mList[position])
    }
}