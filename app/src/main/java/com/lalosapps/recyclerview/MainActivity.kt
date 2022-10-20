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

        adapter = CardAdapter(CardProvider.cards) {
            binding.root.snack(it.title)
        }
        binding.recycler.adapter = adapter
    }
}