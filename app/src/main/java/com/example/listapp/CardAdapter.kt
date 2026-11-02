package com.example.listapp
import com.example.listapp.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    // Текущ. кол-во карточек
    private var itemCount: Int = 0

    // Обновл. кол-ва и перерисовка
    fun updateCount(newCount: Int) {
        itemCount = newCount
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemCount

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        // Нумерац. с 1
        val number = position + 1
        holder.tvNumber.text = number.toString()

        val colorRes = if (number % 2 == 0) R.color.even_background else R.color.odd_background
        val color = holder.itemView.context.getColor(colorRes)
        holder.itemView.setBackgroundColor(color)
    }

    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNumber: TextView = view.findViewById(R.id.tvNumber)
    }
}