package com.example.assigment.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {

    @Query("SELECT * FROM Contacts")
    fun getContacts(): LiveData<List<Contacts>>

    @Insert
    fun createNewContact(contact: Contacts)
}