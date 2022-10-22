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
                CardProvider.deleteCard(it)?.let { index ->
                    adapter.notifyDeletion(index)
                }
            },
            onFavoriteToggled = {
                CardProvider.toggleFavorite(it)?.let { index ->
                    adapter.notifyChange(index)
                }
            }
        )
        binding.recycler.adapter = adapter

        binding.addCardFab.setOnClickListener {
            val index = CardProvider.insertCard()
            adapter.notifyInsertion(index)
            binding.recycler.smoothScrollToPosition(index)
        }
    }
}