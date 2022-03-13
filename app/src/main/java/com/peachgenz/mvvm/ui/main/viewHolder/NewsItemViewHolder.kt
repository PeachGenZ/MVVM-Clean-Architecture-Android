package com.peachgenz.mvvm.ui.main.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peachgenz.mvvm.databinding.ViewHolderNewsItemBinding
import com.peachgenz.mvvm.model.NewsResponse

class NewsItemViewHolder(
    private val binding: ViewHolderNewsItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(articleItem: NewsResponse.Article) {
        binding.apply {
            Glide
                .with(binding.root.context)
                .load(articleItem.image)
                .centerCrop()
                .into(ivNews);
            tvTitle.text = articleItem.title
            tvDes.text = articleItem.description
        }
    }
}