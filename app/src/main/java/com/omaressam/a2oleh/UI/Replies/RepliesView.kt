package com.omaressam.a2oleh.UI.Replies

import android.content.Context
import android.view.View

interface RepliesView {


    var  viewContext:Context
    var  viewRoot: View
    fun toBack()
    fun progressShowHide(show:Boolean)
    fun showShareDiaolge()
    fun BindRepliesList(arr:ArrayList<String>)
    fun itemClicked(reply:String)
    fun logoAnimation()

    //Ads
    fun  loadingBannerAd()
    fun  loadingInistAd()
    fun  showInistAd()
    fun flagInc()

    //get type is choosen
    fun TypeWhich(postion:Int):String
}