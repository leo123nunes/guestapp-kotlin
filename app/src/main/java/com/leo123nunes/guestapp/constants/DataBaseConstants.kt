package com.leo123nunes.guestapp.constants

class DataBaseConstants private constructor() {
    object GUEST{
        var TABLE_NAME = "convidados"
        object COLUMNS{
            var ID = "id"
            var NAME = "name"
            var PRESENCE = "presence"
        }
    }
}