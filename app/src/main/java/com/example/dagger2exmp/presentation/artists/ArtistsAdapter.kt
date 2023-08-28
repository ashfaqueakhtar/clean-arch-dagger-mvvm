package com.example.dagger2exmp.presentation.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dagger2exmp.R
import com.example.dagger2exmp.data.model.artist.Person
import com.example.dagger2exmp.databinding.ListItemBinding

class ArtistsAdapter : RecyclerView.Adapter<ArtistsAdapter.MyViewHolder>() {

    private var mList = ArrayList<Person>()

    fun setList(list: List<Person>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person) {
            binding.titleTextView.text = person.name
            binding.descriptionTextView.text = person.knownForDepartment
            val posterUrl = "https://image.tmdb.org/t/p/w500/" + person.profilePath
            Glide.with(binding.imageView.context)
                .load(posterUrl)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ArtistsAdapter.MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }
}