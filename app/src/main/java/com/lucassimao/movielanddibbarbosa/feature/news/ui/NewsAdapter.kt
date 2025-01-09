package com.lucassimao.movielanddibbarbosa.feature.news.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lucassimao.movielanddibbarbosa.R
import com.lucassimao.movielanddibbarbosa.core.data.createDiffCallback
import com.lucassimao.movielanddibbarbosa.core.ui.loadImage
import com.lucassimao.movielanddibbarbosa.databinding.ItemNewsBinding
import com.lucassimao.movielanddibbarbosa.feature.news.data.model.ArticleModel

class NewsAdapter : ListAdapter<
        ArticleModel, NewsViewHolder>
    (createDiffCallback<ArticleModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.setData(getItem(position))
    }
}

class NewsViewHolder(
    private val binding: ItemNewsBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun setData(article: ArticleModel) {
        with(binding) {
            ivNewsPoster.loadImage(
                article.urlToImage,
                R.drawable.placeholder_image
            )
            tvNewsTitle.text = article.title
            tvNewsSubtitle.text = article.description
        }
    }
}