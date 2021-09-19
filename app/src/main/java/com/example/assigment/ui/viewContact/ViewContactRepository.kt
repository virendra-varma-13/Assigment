package com.example.assigment.ui.viewContact

import androidx.lifecycle.LiveData
import com.example.assigment.db.ContactDao
import com.example.assigment.db.Contacts

class ViewContactRepository(private val contactDao: ContactDao) {
    fun getAllContacts(): LiveData<List<Contacts>> {
        return contactDao.getContacts()
    }
}