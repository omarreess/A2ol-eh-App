package com.omaressam.a2oleh.UI.Replies

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.omaressam.a2oleh.Data.AdsFlags
import com.omaressam.a2oleh.Data.RoomDb.RepliesDatabase
import com.omaressam.a2oleh.Data.RoomDb.type_birthday
import com.omaressam.a2oleh.Data.RoomDb.type_funeral
import com.omaressam.a2oleh.Data.RoomDb.type_newpic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class RepliesPresenter (repliesView:RepliesView) :RepliesContract {
      var  repliesView : RepliesView
      val dbClient:RepliesDatabase
      override var  replyType :String ?=null
     init {

        this.repliesView =repliesView
        dbClient= RepliesDatabase.build(repliesView.viewContext)
     }


    override fun copyReplies(reply: String) {


        val clipboard = repliesView.viewContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("A2ol eh App",reply)
        clipboard.setPrimaryClip(clip)
        val snack = Snackbar.make(repliesView.viewRoot.rootView," نسخت  -  Copied ",Snackbar.LENGTH_LONG)
        snack.show()
    }

    override fun changeGender(gender: String) {
         GlobalScope.launch(Dispatchers.Main) {
            repliesView.progressShowHide(true)


            val  arr =async(IO) { replyType?.let { dbClient.DbQueries().getRepliesGender(it,gender) } } .await()



             repliesView.BindRepliesList(arr as ArrayList<String>)

            repliesView.progressShowHide(false)

        }

     }

    override fun fetchRepliesList( type: String) {
        replyType = type

        GlobalScope.launch (Dispatchers.Main){

          val arr= async(IO) { replyType?.let { dbClient.DbQueries().getReplies(it) } } .await()
          repliesView.BindRepliesList(arr as ArrayList<String>)
             repliesView.progressShowHide(false)

        }



    }

    //if even show ad
    override fun chechAdFlag(): Boolean =  (AdsFlags.adInitRequest %2 == 0)

}