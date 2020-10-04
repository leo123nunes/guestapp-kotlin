package com.leo123nunes.guestapp.services.repositories

import android.content.Context
import android.provider.ContactsContract
import androidx.core.content.contentValuesOf
import com.leo123nunes.guestapp.constants.DataBaseConstants
import com.leo123nunes.guestapp.services.model.GuestModel

class GuestRepository private constructor(context: Context) {
    private val mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun get(id: Int): GuestModel? {
        var db = mGuestDataBaseHelper.writableDatabase

        var guest: GuestModel? = null

        return try {

            var columns = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            var selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"

            var args = arrayOf(id.toString())

            var cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME,
                columns,
                selection,
                args,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {

                cursor.moveToFirst()

                var name =
                    cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                var presence =
                    (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)) == 1)

                guest = GuestModel(id, name, presence)
            }

            cursor?.close()

            guest
        } catch (E: Exception) {
            guest
        }
    }

    fun save(newGuest: GuestModel): Boolean {

        var db = mGuestDataBaseHelper.writableDatabase

        return try {
            var contentValues = contentValuesOf()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, newGuest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, newGuest.presence)
            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValues)
            true
        } catch (E: Exception) {
            false
        }
    }

    fun delete(id: Int): Boolean {
        var db = mGuestDataBaseHelper.writableDatabase

        return try {

            var selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"

            var args = arrayOf(id.toString())
            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)
            true
        } catch (E: Exception) {
            false
        }
    }

    fun getListAll(): List<GuestModel> {
        var list: MutableList<GuestModel> = ArrayList()
        var db = mGuestDataBaseHelper.writableDatabase
        var guest: GuestModel ?= null

        return try {

            var columns = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            var cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {

                while (cursor.moveToNext()) {
                    var name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    var presence = (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))==1)
                    var id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    guest = GuestModel (id, name, presence)
                    list.add(guest)
                }

            }

            cursor?.close()

            list
        } catch (E: Exception) {
            list
        }
    }

    fun getListPresents(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()

        return try {
            var db = mGuestDataBaseHelper.writableDatabase

            val cursor = db.rawQuery("SELECT id, name, presence FROM convidados WHERE presence = 1",null)

            if (cursor != null && cursor.count > 0) {

                while (cursor.moveToNext()) {
                    var name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    var presence = (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))==1)
                    var id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val guest = GuestModel (id, name, presence)
                    list.add(guest)
                }

            }

            cursor?.close()

            list
        } catch (E: Exception) {
            list
        }
    }

    fun getListAbsences(): List<GuestModel> {
        var list: MutableList<GuestModel> = ArrayList()


        return try {
            var db = mGuestDataBaseHelper.writableDatabase

            val cursor = db.rawQuery("SELECT id, name, presence FROM convidados WHERE presence = 0",null)

            if (cursor != null && cursor.count > 0) {

                while (cursor.moveToNext()) {
                    var name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    var presence = (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))==1)
                    var id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    var guest = GuestModel (id, name, presence)
                    list.add(guest)
                }

            }

            cursor?.close()

            list
        } catch (E: Exception) {
            list
        }
    }

    fun update(guest: GuestModel): Boolean {
        var db = mGuestDataBaseHelper.writableDatabase

        return try {
            var contentValues = contentValuesOf()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            var selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"

            var args = arrayOf(guest.id.toString())
            db.update(DataBaseConstants.GUEST.TABLE_NAME, contentValues, selection, args)
            true
        } catch (E: Exception) {
            false
        }
    }
}