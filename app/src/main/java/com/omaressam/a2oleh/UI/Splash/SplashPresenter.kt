package com.omaressam.a2oleh.UI.Splash

import android.content.Context
import android.content.SharedPreferences
import com.omaressam.a2oleh.Data.AdsFlags.adInitRequest
import com.omaressam.a2oleh.Data.RoomDb.DbStaticData
import com.omaressam.a2oleh.Data.RoomDb.RepliesDatabase
import com.omaressam.a2oleh.Data.RoomDb.RepliesTableModel
import com.omaressam.a2oleh.Data.RoomDb.dbName
 import java.io.File

class SplashPresenter(view: SplashView) :SplashContract {

    var splashView :SplashView
    override  var context: Context?=null
    val dbClient: RepliesDatabase
       var  dbList: ArrayList<RepliesTableModel>?

    init {

        splashView=view
        context= splashView.viewContext
        dbClient= RepliesDatabase.build(context!!)
        dbList = DbStaticData()

    }





    override fun InitDb() {
   dbClient.DbQueries().insertReply(dbList)
     }

    override fun CheckInitDb() : Boolean {
        val dbFile: File = context!!.getDatabasePath(dbName)
        return dbFile.exists()
     }

    override fun InitDbFlag() {
        //check pref exit  -> nav graph
        val sharedPreferences: SharedPreferences = context!!.getSharedPreferences("initAdFlag" , Context.MODE_PRIVATE )
        val editor:SharedPreferences.Editor =  sharedPreferences.edit()

        if( sharedPreferences.contains("adFlag"))
        {//not 1st time
            if (sharedPreferences.getInt("adFlag",0) == 1)
            { editor.putInt("adFlag" , 2)
                adInitRequest=2
                editor.apply()
                editor.commit()}

             else { editor.putInt("adFlag" , 1)
                adInitRequest=1
                editor.apply()
                editor.commit()}
        }

        else
        {     //1st time
            editor.putInt("adFlag" , 2)
            adInitRequest=2
            editor.apply()
            editor.commit()
        }
    }
}