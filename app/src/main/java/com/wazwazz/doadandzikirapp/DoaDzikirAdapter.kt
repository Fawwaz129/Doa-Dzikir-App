package com.wazwazz.doadandzikirapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// Adapter is a subclass from RecyclerView which take responsibility

// ViewHolder take responsibility for initialize item view from layout
// In this class we will describes our item view from layout
class DoaDzikirAdapter(listDzikir: List<DoaDzikir>) : RecyclerView.Adapter<DoaDzikirAdapter.DzikirViewHolder>(){

    private val listData = ArrayList<DoaDzikir>()

    // set data from data source from adapter
    fun setData(list: List<DoaDzikir>) {
        listData.clear()
        listData.addAll(list)
    }

    inner class  DzikirViewHolder(view: View ) : RecyclerView.ViewHolder(view){
        val  itemTitle = view.findViewById<TextView>(R.id.item_title)
        val itemArabic = view.findViewById<TextView>(R.id.item_arabic)
        val itemTranslate = view.findViewById<TextView>(R.id.item_translate)
    }
// onCreateViewHolder provides layout to be used by ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DzikirViewHolder {
        return DzikirViewHolder (
            LayoutInflater.from(parent.context).inflate(R.layout.item_doa, parent, false))
    }

    override fun getItemCount() = listData.size


    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
        holder.apply {
            itemTitle.text = listData[position].title
            itemArabic.text = listData[position].arabic
            itemTranslate.text = listData[position].translate
        }
    }
}