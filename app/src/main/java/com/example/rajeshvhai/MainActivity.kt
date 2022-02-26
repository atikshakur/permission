package com.example.rajeshvhai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rajeshvhai.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var list = listOf<Product>(
            Product("Potato Crackers", "Chips"),
            Product("Lays", "Chips"),
            Product("Pran juice", "Mango Juice"),
            Product("Potato Crackers", "Chips"),
            Product("Lays", "Chips"),
            Product("Pran juice", "Mango Juice"),
            Product("Potato Crackers", "Chips"),
            Product("Lays", "Chips"),
            Product("Pran juice", "Mango Juice")
        )


        listAdapter = RecyclerAdapter()

        binding.recyclerview.adapter = listAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        listAdapter.setData(list)
    }
}