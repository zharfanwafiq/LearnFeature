package com.zharfan.learnfeature.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zharfan.learnfeature.data.ListFeature
import com.zharfan.learnfeature.databinding.ItemListFeatureBinding

class ListFeatureAdapter(private val listFeature: ArrayList<ListFeature>):
    RecyclerView.Adapter<ListFeatureAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListFeatureAdapter.MyViewHolder {
        return MyViewHolder(
            ItemListFeatureBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ListFeatureAdapter.MyViewHolder, position: Int) {
        holder.bind(listFeature[position])
    }

    override fun getItemCount(): Int = listFeature.size

    inner class MyViewHolder(private val binding: ItemListFeatureBinding):
            RecyclerView.ViewHolder(binding.root){

                fun bind(listFeature: ListFeature){
                    binding.apply {
                        Glide.with(itemView.context)
                            .load(listFeature.listImage)
                            .into(imgFeature)

                        tvTitle.text = listFeature.listName
                        tvDescription.text = listFeature.listDescription

                    }

                }
            }
}