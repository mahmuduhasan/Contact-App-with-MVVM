package com.example.todoapp.repository

import com.example.todoapp.Contact
import com.example.todoapp.daos.ContactDao

class ContactRepository(val contactDao: ContactDao)  {
    fun addContact(contact: Contact){
        contactDao.addContact(contact)
    }

    fun updateContact(contact: Contact){
        contactDao.updateContact(contact)
    }

    fun deleteContact(contact: Contact){
        contactDao.deleteContact(contact)
    }

    fun getAllContact() : List<Contact> = contactDao.getAllContact()
}