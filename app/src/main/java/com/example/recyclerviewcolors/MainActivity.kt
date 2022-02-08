package com.example.recyclerviewcolors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    var planetsList = arrayListOf<String>("Mercury", "Venus", "Earth", "Mars", "Jupiter")

    // val colorsList = mutableListOf(Color.YELLOW, Color.RED, Color.GREEN, Color.MAGENTA)
    val colorsList = resources.getIntArray(R.array.colors).toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // пример использования ListView
        val lv = findViewById<ListView>(R.id.list)
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, planetsList)
        lv.adapter = adapter

        // пример использования RecyclerView с собственным адаптером
        val rv = findViewById<RecyclerView>(R.id.rview)
        val colorAdapter = ColorAdapter(LayoutInflater.from(this))
        // добавляем данные в список для отображения
        colorAdapter.submitList(colorsList)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = colorAdapter


        /*
        val button = findViewById<Button>(R.id.generate)
        button.setOnClickListener {
            planetsList.shuffle()
            adapter.notifyDataSetChanged()
        }
         */

    }

}
