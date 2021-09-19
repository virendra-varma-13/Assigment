package com.example.assigment.ui.addNewContact

import androidx.lifecycle.LiveData
import com.example.assigment.db.ContactDao
import com.example.assigment.db.Contacts

class AddNewContactRepository(private val contactDao: ContactDao) {

    suspend fun addNewContact(contacts: Contacts){
        return contactDao.createNewContact(contacts)
    }
}