package com.example.apidemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apidemo.databinding.DataItemBinding
import com.example.apidemo.model.Result

class MainAdapter(var context: Context, var models : ArrayList<Result>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataItemBinding.inflate(layoutInflater,parent,false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = models[position]
        holder.binding.textView1.text = item.name
        holder.binding.textView2.text = item.url
    }

    override fun getItemCount(): Int {
        return models.size
    }

    class MainViewHolder(val binding: DataItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}