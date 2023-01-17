package com.example.kotlinrush.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinrush.R
import com.example.kotlinrush.model.Animal

class AnimalAdapter() : RecyclerView.Adapter<AnimalAdapter.MyViewHolder>() {

    private var animalList: List<Animal> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameText.text = animalList[position].getName()
        holder.heightText.text = animalList[position].getHeight().toString()
        holder.weightText.text = animalList[position].getWeight().toString()
    }

    override fun getItemCount(): Int = animalList.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.name)
        val heightText: TextView = itemView.findViewById(R.id.height)
        val weightText: TextView = itemView.findViewById(R.id.weight)
    }

    fun setList(newAnimalList: ArrayList<Animal>) {
        animalList = newAnimalList
        notifyDataSetChanged()
    }
}