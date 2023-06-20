package com.hka.recommendationbloodbasedapp.database

import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import com.hka.recommendationbloodbasedapp.model.ProductList

class DbManager(c: Context) {
    private lateinit var dbHelper: DatabaseHelper
    private var context: Context = c
    private lateinit var  database: SQLiteDatabase


    @Throws(SQLException::class)
    fun open(): DbManager? {
        dbHelper = DatabaseHelper(context)
        database = dbHelper.writableDatabase
        return this
    }
    fun close() {
        dbHelper.close()
    }

    fun getAllFruits(): List<ProductList> {
        return dbHelper.getAllFruits()
    }

    fun getAllVegetables(): List<ProductList> {
        return dbHelper.getAllVegetables()
    }

    fun getAllProducts(): ArrayList<ProductList> {
        return dbHelper.getAllProducts()
    }

    fun search(keyword: String): List<ProductList?>? {
        return dbHelper.search(keyword)
    }

}