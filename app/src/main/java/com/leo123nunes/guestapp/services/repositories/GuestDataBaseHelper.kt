package com.leo123nunes.guestapp.services.repositories

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.leo123nunes.guestapp.constants.DataBaseConstants

class GuestDataBaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_GUEST)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    companion object{
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "Convidados.db"
    }

    private val CREATE_TABLE_GUEST = ("create table "+ DataBaseConstants.GUEST.TABLE_NAME+
                (" (")+ DataBaseConstants.GUEST.COLUMNS.ID+
                " integer primary key autoincrement "+
                DataBaseConstants.GUEST.COLUMNS.NAME+" text, "+
                DataBaseConstants.GUEST.COLUMNS.PRESENCE+" integer);")
    }
}