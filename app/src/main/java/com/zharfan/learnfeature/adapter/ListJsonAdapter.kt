package com.zharfan.learnfeature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zharfan.learnfeature.data.ListFeature
import com.zharfan.learnfeature.databinding.ItemListFeatureBinding
import com.zharfan.learnfeature.databinding.ItemListJsonBinding

class ListJsonAdapter:RecyclerView.Adapter<ListJsonAdapter.ViewHolder>() {

    private val listJson = ArrayList<String>()

    fun showListJson(listJson: ArrayList<String>){
        this.listJson.clear()
        this.listJson.addAll(listJson)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListJsonAdapter.ViewHolder {
       val inflater = ItemListJsonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ListJsonAdapter.ViewHolder, position: Int) {
        holder.bind(listJson[position])
    }

    inner class ViewHolder(private val  binding: ItemListJsonBinding ):
            RecyclerView.ViewHolder(binding.root){
                fun bind(str: String)= with(binding){
                    tvTitle.text = str
                }
            }

    override fun getItemCount(): Int {
        return listJson.size
    }

}