package com.leo123nunes.guestapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leo123nunes.guestapp.services.model.GuestModel
import com.leo123nunes.guestapp.services.repositories.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {
    private var context = application.applicationContext

    private var guestRepository: GuestRepository = GuestRepository.getInstance(context)

    fun save(guestName: String, guestPresence: Boolean){
        var newGuest = GuestModel(name = guestName, presence = guestPresence)
        guestRepository.save(newGuest)
    }

}