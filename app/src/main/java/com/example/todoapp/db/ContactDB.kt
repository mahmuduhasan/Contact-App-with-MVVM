package com.example.todoapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.Contact
import com.example.todoapp.daos.ContactDao

@Database(entities = [Contact::class], version = 1)
abstract class ContactDB : RoomDatabase() {
    abstract fun getDao() : ContactDao
    companion object{
        private var db : ContactDB? = null
        fun getDB(context: Context) : ContactDB{
            if(db == null){
                db = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDB::class.java,
                    "contact_table"
                ).allowMainThreadQueries().build()
                return db!!
            }
            return db!!
        }
    }
}