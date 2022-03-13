package com.peachgenz.mvvm.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.peachgenz.mvvm.databinding.ViewHolderNewsItemBinding
import com.peachgenz.mvvm.model.NewsResponse
import com.peachgenz.mvvm.ui.main.viewHolder.NewsItemViewHolder

class NewsAdapter(

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var newsData: List<NewsResponse.Article?> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsItemViewHolder(
            ViewHolderNewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        newsData[position].let { item ->
            if (holder is NewsItemViewHolder && item != null) {
                holder.bind(item)
            }
        }
    }

    override fun getItemCount(): Int = newsData.size
}