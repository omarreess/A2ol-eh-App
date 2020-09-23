package com.omaressam.a2oleh.Data.RoomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
val dbName = "A2ol-eh.db"
@Database(entities = arrayOf(RepliesTableModel::class), version = 1)
abstract class RepliesDatabase : RoomDatabase() {
    abstract fun DbQueries(): RepliesTableQueries



    companion object  {
        fun build( context: Context) = Room.databaseBuilder(
            context,
            RepliesDatabase::class.java, dbName
        ).build()
    }
 }