package com.example.animationapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animationapp.Model.Data
import kotlinx.coroutines.withContext

class AdapterClass(private val myList: List<Data>):RecyclerView.Adapter<AdapterClass.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val imageView: ImageView = itemView.findViewById(R.id.animationImage)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row1,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = myList[position]
        Glide.with(holder.itemView.context).load(model.images.downsized.url)
            .into(holder.imageView)
        holder.imageView.setOnClickListener {
            val intent=Intent(holder.imageView.context,DetailedActivity::class.java)
        intent.putExtra("detailed page",model.images.downsized.url)
       holder.itemView.context.startActivity(intent) }
    }
    override fun getItemCount(): Int {
        return myList.size
    }
}