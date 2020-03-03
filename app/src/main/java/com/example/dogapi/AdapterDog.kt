package com.example.dogapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dog_card.view.*

class AdapterDog(var list:ArrayList<String>):RecyclerView.Adapter<AdapterDog.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDog.ViewHolder {
        val layout = LayoutInflater.from(parent?.context).inflate(R.layout.dog_card,parent,false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterDog.ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(data:String){
            Glide.with(itemView.context).load(data).into(itemView.imvDog)
        }
    }
}