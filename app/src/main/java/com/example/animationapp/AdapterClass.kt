package com.example.animationapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animationapp.Model.Data
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context

//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

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

    }

    override fun getItemCount(): Int {
        return myList.size

    }
}