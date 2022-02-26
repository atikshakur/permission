package com.example.rajeshvhai

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rajeshvhai.databinding.ActivityMainBinding
import com.example.rajeshvhai.databinding.ListItemBinding

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var products = emptyList<Product>()

    fun setData(productList: List<Product>){
        products = productList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.listTitle.text = products[position].title
        holder.binding.listDescription.text = products[position].description
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {}
}