package com.example.todoapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.Contact
import com.example.todoapp.db.ContactDB
import com.example.todoapp.repository.ContactRepository

class ContactModel(application: Application) : AndroidViewModel(application) {
    private lateinit var repository : ContactRepository
    init {
        val dao = ContactDB.getDB(application).getDao()
        repository = ContactRepository(dao)
    }
    
    fun addContact(contact: Contact){
        repository.addContact(contact)
    }

    fun updateContact(contact: Contact){
        repository.updateContact(contact)
    }
    fun deleteContact(contact: Contact){
        repository.deleteContact(contact)
    }

    fun getAllContact() : List<Contact> = repository.getAllContact()
}