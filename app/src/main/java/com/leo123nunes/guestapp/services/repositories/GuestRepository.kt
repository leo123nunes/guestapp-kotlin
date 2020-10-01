package com.leo123nunes.guestapp.services.repositories

import com.leo123nunes.guestapp.services.model.GuestModel

class GuestRepository {
    private var guestList: MutableList<GuestModel> = ArrayList<GuestModel>()

    fun save(newGuest: GuestModel){
        guestList.add(newGuest)
    }

    fun delete(guest: GuestModel){
        guestList.remove(guest)
    }

    fun getListAll(): List<GuestModel>{
        var listAllGuests = guestList
        return listAllGuests
    }

    fun getListPresents(): List<GuestModel>{
        var presentsGuestsList = guestList.filter{it.presence == true}
        return presentsGuestsList
    }

    fun getListAbsences(): List<GuestModel>{
        var absenceListGuests = guestList.filter{it.presence == false}
        return absenceListGuests
    }
}