package com.omaressam.a2oleh.UI.ShareApp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.google.android.material.snackbar.Snackbar
import com.omaressam.a2oleh.Data.ShareLink

class SharePresenter   : ShareContract {





    override fun fetchUri() : String {


      return ShareLink()
    }


}