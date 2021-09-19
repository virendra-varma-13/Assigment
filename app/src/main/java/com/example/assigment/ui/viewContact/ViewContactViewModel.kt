package com.example.assigment.ui.viewContact

import android.app.Application
import android.view.View
import androidx.databinding.Observable
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.assigment.db.AppDataBase
import com.example.assigment.db.Contacts

class ViewContactViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : ViewContactRepository
    var allContacts : LiveData<List<Contacts>>
    var emptyListMessageVisibility: ObservableInt

    init {
        val contactDb = AppDataBase.getDatabase(application)
        repository = ViewContactRepository(contactDb.contactDao())
        emptyListMessageVisibility = ObservableInt(View.GONE)
        allContacts = repository.getAllContacts()
    }
}