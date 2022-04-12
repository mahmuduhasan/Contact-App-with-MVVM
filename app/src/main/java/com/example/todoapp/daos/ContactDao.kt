package com.example.todoapp.daos

import androidx.room.*
import com.example.todoapp.Contact

@Dao
interface ContactDao {
    @Insert
    fun addContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("select * from tbl_contact")
    fun getAllContact() : List<Contact>
}