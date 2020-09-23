package com.omaressam.a2oleh.UI.Splash

import android.content.Context
import android.widget.ProgressBar

interface SplashView {
    var viewContext:Context?
    fun ProgressShowHide( show:Boolean)
    fun ToNextScreen()

}