package com.example.listapp

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val recycler = findViewById<RecyclerView>(R.id.recyclerCards)
        adapter = CardAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, columnsCount())

        adapter.updateCount(viewModel.count)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            viewModel.addCard()
            adapter.updateCount(viewModel.count)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val recycler = findViewById<RecyclerView>(R.id.recyclerCards)
        recycler.layoutManager = GridLayoutManager(this, columnsCount())
    }
    private fun columnsCount(): Int {
        val orientation = resources.configuration.orientation
        return if (orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 3
    }
}