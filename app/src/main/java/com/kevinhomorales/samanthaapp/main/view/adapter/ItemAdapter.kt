package com.kevinhomorales.samanthaapp.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kevinhomorales.samanthaapp.databinding.ItemRowBinding
import com.kevinhomorales.samanthaapp.sample.model.posts.PostsItem

class ItemAdapter(var itemClickListener: OnPostClickListener): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private lateinit var binding: ItemRowBinding
    private var dataList = mutableListOf<PostsItem>()

    fun setListData(data: MutableList<PostsItem>) {
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val list = dataList[position]
        holder.bindView(list)
    }

    override fun getItemCount(): Int {
        return if(dataList.size > 0) {
            dataList.size
        } else {
            0
        }
    }

    inner class ItemViewHolder(private val itemBinding: ItemRowBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bindView(postsItem: PostsItem) {
            itemBinding.titleItemId.setText(postsItem.title)
            itemBinding.bodyItemId.setText(postsItem.body)
            itemView.setOnClickListener { itemClickListener.postClick(postsItem) }
        }
    }



}
