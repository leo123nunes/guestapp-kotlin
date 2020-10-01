package com.leo123nunes.guestapp.viewModel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leo123nunes.guestapp.GuestFormActivity
import com.leo123nunes.guestapp.services.model.GuestModel
import com.leo123nunes.guestapp.services.repositories.GuestRepository

class GuestFormViewModel: ViewModel() {
    lateinit private var mGuestFormViewModel: MutableLiveData<String>
    lateinit private var mPresenceGuestFormViewModel: MutableLiveData<Boolean>

    private var guestRepository = GuestRepository()

    var guestFormViewModel: LiveData<String> = mGuestFormViewModel
    var presenceGuestFormViewModel: LiveData<Boolean> = mPresenceGuestFormViewModel

    fun addGuest(guestName: String, guestPresence: Boolean){
        var newGuest = GuestModel(guestName, guestPresence)
        mGuestFormViewModel.value = guestName
        mPresenceGuestFormViewModel.value = guestPresence
        guestRepository.save(newGuest)
    }

}