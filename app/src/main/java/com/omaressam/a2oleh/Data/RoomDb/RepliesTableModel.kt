package com.omaressam.a2oleh.Data.RoomDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "replies_table")
data class RepliesTableModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "replies") var replies: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "gender") var gender: String



)