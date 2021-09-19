package com.example.assigment.ui.addNewContact

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.assigment.db.AppDataBase
import com.example.assigment.db.Contacts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class AddContactViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : AddNewContactRepository
    private val _navigateToSleepTracker = MutableLiveData<Boolean?>()

    init {
        val contactDb = AppDataBase.getDatabase(application)
        repository = AddNewContactRepository(contactDb.contactDao())
    }

    /**
     * When true immediately navigate back to the [SleepTrackerFragment]
     */
    val navigateToSleepTracker: LiveData<Boolean?>
        get() = _navigateToSleepTracker

    /**
     * Call this immediately after navigating to [SleepTrackerFragment]
     */
    fun doneNavigating() {
        _navigateToSleepTracker.value = null
    }

    fun saveContact(contactName : String, contactNumber : String, contactType : String){

        val contact = Contacts();
        contact.contactName = contactName
        contact.contactNo = contactNumber
        contact.contactType = contactType

        viewModelScope.launch(Dispatchers.IO) {
            repository.addNewContact(contact)
            viewModelScope.launch(Dispatchers.Main) {
                _navigateToSleepTracker.value = true
            }
        }

    }
}