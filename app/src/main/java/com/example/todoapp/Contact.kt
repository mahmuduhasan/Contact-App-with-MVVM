package com.example.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val name : String,
    val phone : String,
    val email : String,
    val address : String
)

