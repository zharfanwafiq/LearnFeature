package com.zharfan.learnfeature.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zharfan.learnfeature.data.response.ResponseItem
import com.zharfan.learnfeature.databinding.ItemListRetrofitBinding

class ListRetrofitAdapter(
    val clickListener: (ResponseItem) -> Unit
) : RecyclerView.Adapter<ListRetrofitAdapter.ListRetrofitAdapterViewHolder>() {

    private val listRetrofit = ArrayList<ResponseItem>()

    fun setListUsers(data: List<ResponseItem>) {
        this.listRetrofit.clear()
        this.listRetrofit.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListRetrofitAdapter.ListRetrofitAdapterViewHolder {
        return ListRetrofitAdapterViewHolder(
            ItemListRetrofitBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(
        holder: ListRetrofitAdapter.ListRetrofitAdapterViewHolder,
        position: Int
    ) {
        holder.onBind(listRetrofit[position])
    }

    override fun getItemCount(): Int {
        return listRetrofit.size
    }

    inner class ListRetrofitAdapterViewHolder(private val binding : ItemListRetrofitBinding) :
            RecyclerView.ViewHolder(binding.root){
                fun onBind(item: ResponseItem) = with(binding){
                    tvTitle.text = item.name
                    tvDescription.text = item.email
                    itemView.setOnClickListener{
                        clickListener(item)
                    }
                }
            }
}