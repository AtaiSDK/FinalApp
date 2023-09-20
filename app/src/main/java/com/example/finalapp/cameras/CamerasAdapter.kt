package com.example.finalapp.cameras

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalapp.databinding.ItemRecyclerBinding

class CamerasAdapter(private val data: List<model>): RecyclerView.Adapter<CamerasAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerBinding
            .inflate(LayoutInflater
                .from(parent.context),
                parent,
                false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(private val binding: ItemRecyclerBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: model){
            binding.tvTitle.text = item.title
            Glide.with(itemView)
                .load(item.image)
                .into(binding.image)

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = data.size


}