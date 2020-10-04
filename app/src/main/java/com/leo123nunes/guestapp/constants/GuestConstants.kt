package com.leo123nunes.guestapp.constants

class GuestConstants private constructor() {
    companion object{
        val GUESTID = "guestID"
    }

    object FILTER{
        val EMPTY = 0
        val PRESENTS = 1
        val ABSENTS = 2
    }
}