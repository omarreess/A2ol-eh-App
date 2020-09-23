package com.omaressam.a2oleh.UI.Splash

import android.content.Context
import com.omaressam.a2oleh.Data.RoomDb.RepliesTableModel

interface SplashContract {

    var context:Context?
    //Db
     fun InitDb()
    fun CheckInitDb() : Boolean
    //Share Pref
    fun InitDbFlag()
}