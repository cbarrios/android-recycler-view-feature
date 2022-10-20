package com.lalosapps.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lalosapps.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CardAdapter(
            cards = CardProvider.cards,
            onCardClicked = {
                binding.root.snack(it.title)
            },
            onCardLongClicked = {
                val index = CardProvider.deleteCard(it)
                adapter.notifyDeletion(index)
            },
            onFavoriteToggled = {
                val (index, card) = CardProvider.toggleFavorite(it)
                adapter.notifyChange(index, card)
            }
        )
        binding.recycler.adapter = adapter
    }
}