package com.hka.bloodrecommendationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hka.bloodrecommendationapp.Database.DatabaseHelper

class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        productAdapter = ProductAdapter(emptyList())
        recyclerView.adapter = productAdapter

        databaseHelper = DatabaseHelper(this)
        val productList = databaseHelper.getAllProducts()
        productAdapter = ProductAdapter(productList)
        recyclerView.adapter = productAdapter
    }
}