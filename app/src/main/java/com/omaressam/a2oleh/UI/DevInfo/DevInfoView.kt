package com.omaressam.a2oleh.UI.DevInfo

interface DevInfoView {
    fun toWhatsapp(uri:String)
    fun toGmail(mail : String)
    fun toOurApps(uri:String )
    fun toBack()
    fun toLinkidin(uri :String)
}