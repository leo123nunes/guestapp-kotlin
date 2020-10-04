package com.leo123nunes.guestapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leo123nunes.guestapp.services.model.GuestModel
import com.leo123nunes.guestapp.services.repositories.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestsRepository = GuestRepository.getInstance(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()

    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(){
        mGuestList.value = mGuestsRepository.getListAll()
    }

    fun delete(id: Int){
        mGuestsRepository.delete(id)
    }
}