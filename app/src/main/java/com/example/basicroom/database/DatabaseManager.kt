package com.example.basicroom.database

import android.content.Context
import androidx.room.Room


class DatabaseManager {
    lateinit var database: AppDatabase


    fun initializeDb(context: Context){
        createDB(context)
    }

    private fun createDB(context: Context){
        database = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }

    companion object{
        val instance= DatabaseManager()
    }
}