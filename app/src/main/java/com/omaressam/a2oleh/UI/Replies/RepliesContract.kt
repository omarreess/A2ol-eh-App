package com.omaressam.a2oleh.UI.Replies

interface RepliesContract {

    var  replyType : String?
     fun copyReplies(reply:String)
    fun changeGender(gender:String)
    fun fetchRepliesList (type:String)
     fun chechAdFlag():Boolean
}