package com.example.basicroom.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val TABLE_USERS = "users"
const val DATABASE_NAME = "appdatabase.sqlite"

@Database(entities = [UserEntity::class],
version = 1
)

abstract class AppDatabase: RoomDatabase(){
    abstract fun userDao(): UserDao

}