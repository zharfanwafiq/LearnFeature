package com.zharfan.learnfeature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zharfan.learnfeature.data.ListFeature
import com.zharfan.learnfeature.databinding.ItemListFeatureBinding
import java.util.*

class ListFeatureAdapter(private val listFeature: ArrayList<ListFeature>):
    RecyclerView.Adapter<ListFeatureAdapter.MyViewHolder>(),Filterable{

    var featureFilterList = ArrayList<ListFeature>()

    init {
        featureFilterList = listFeature
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListFeatureAdapter.MyViewHolder {
        return MyViewHolder(
            ItemListFeatureBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ListFeatureAdapter.MyViewHolder, position: Int) {
        holder.bind(featureFilterList[position])
    }

    override fun getItemCount(): Int = featureFilterList.size

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

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()){
                   featureFilterList = listFeature
                }else{
                    val resultList = ArrayList<ListFeature>()
                        for (row in listFeature) {
                            if (row.listName.lowercase()
                                    .contains(constraint.toString().lowercase())
                            ) {
                                resultList.add(row)
                            }
                        }
                    featureFilterList = listFeature
                }
                val filterResults = FilterResults()
                filterResults.values = listFeature
                return filterResults
            }

            override fun publishResults(constrain: CharSequence?, results: FilterResults?) {
                featureFilterList = results?.values as ArrayList<ListFeature>
                notifyDataSetChanged()
            }
        }
    }
}