package com.leo123nunes.guestapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leo123nunes.guestapp.constants.GuestConstants
import com.leo123nunes.guestapp.services.model.GuestModel
import com.leo123nunes.guestapp.services.repositories.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestsRepository = GuestRepository.getInstance(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()

    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: Int){
        when (filter) {
            GuestConstants.FILTER.EMPTY -> mGuestList.value = mGuestsRepository.getListAll()
            GuestConstants.FILTER.PRESENTS -> mGuestList.value = mGuestsRepository.getListPresents()
            GuestConstants.FILTER.ABSENTS -> mGuestList.value = mGuestsRepository.getListAbsences()
        }
    }

    fun delete(id: Int){
        mGuestsRepository.delete(id)
    }
}