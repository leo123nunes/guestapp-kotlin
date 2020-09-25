package com.leo123nunes.guestapp.ui.absents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AbsentsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is absents Fragment"
    }
    val text: LiveData<String> = _text
}