package com.wazwazz.doadandzikirapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wazwazz.doadandzikirapp.databinding.ItemArtikelBinding

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    private var listArtikel = ArrayList<ArticleItem>()

    inner class ArticleViewHolder(val view:ItemArtikelBinding) : RecyclerView.ViewHolder(view.root)

    fun setData(list: List<ArticleItem>) {
        listArtikel.clear()
        listArtikel.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder(
        ItemArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount()= listArtikel.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = listArtikel[position]
        holder.view.itemArtikel.setImageResource(data.imageArtikel)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("Title", data.titleArtikel)
            intent.putExtra("Image", data.imageArtikel)
            intent.putExtra("Content", data.contentArtikel)

            it.context.startActivity(intent)
        }
    }
}