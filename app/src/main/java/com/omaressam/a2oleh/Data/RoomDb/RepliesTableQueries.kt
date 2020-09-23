package com.omaressam.a2oleh.Data.RoomDb

import androidx.room.*

@Dao
interface RepliesTableQueries {
    //the base get call
    @Query("SELECT replies FROM replies_table WHERE type = :type")
    fun getReplies(type:String): List<String>


   // when gender was choosen
    @Query("SELECT replies FROM replies_table WHERE type = :type and (gender = :gender or gender='all')")
    fun getRepliesGender(type: String , gender:String): List<String>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertReply(  reply: ArrayList<RepliesTableModel>?)

    @Delete
    fun delete(reply: RepliesTableModel)

    @Update
    fun updateTodo(vararg reply: RepliesTableModel)
}
