package com.kyawlinnthant.klt_jetpack.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kyawlinnthant.klt_jetpack.R
import com.kyawlinnthant.klt_jetpack.model.db.News
import com.kyawlinnthant.klt_jetpack.ui.view_holder.DataViewHolder

class NewsAdapter(
    private val onClick : (Int)->Unit
) : PagedListAdapter<News, RecyclerView.ViewHolder>(newsDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_data_layout,parent,false),onClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DataViewHolder).bind(getItem(position))
    }

    companion object {
        val newsDiffUtil = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun getClickItem(position: Int) = getItem(position)

}