package com.lalosapps.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lalosapps.recyclerview.databinding.CardItemBinding

class CardAdapter(
    private val cards: List<CardItem>
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cards[position])
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CardItemBinding.bind(view)

        fun bind(card: CardItem) {
            binding.apply {
                title.text = card.title
                description.text = card.description
                val resource =
                    if (card.favorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
                icon.setImageResource(resource)
            }
        }
    }
}