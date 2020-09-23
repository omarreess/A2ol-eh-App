package com.omaressam.a2oleh.UI.ShareApp

import android.content.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.omaressam.a2oleh.R
import kotlinx.android.synthetic.main.fragment_share.*


class ShareFragment  : BottomSheetDialogFragment(), ShareView {

    var  fragmentView:View ?=null

    var SharePresenter =  SharePresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.BottomSheetDialogTheme)

        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          fragmentView = inflater.inflate(R.layout.fragment_share, container, false)






            return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         // init views






           bindLink(SharePresenter.fetchUri())
        //regester listners
        registerListners()
    }



    override fun toWhatsappShare(uri: String) {

        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, " الاختراع دة حوار \n $uri " )

        sendIntent.type = "text/plain"
        sendIntent.setPackage("com.whatsapp")
        try {
            startActivity(sendIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(context, "Please Install Whatsapp", Toast.LENGTH_LONG).show()
        }
    }

    override fun toMessngerShare(uri: String) {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, " الاختراع دة حوار \n $uri " )

        sendIntent.type = "text/plain"
        sendIntent.setPackage("com.facebook.orca")
        try {
            startActivity(sendIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(context, "Please Install Facebook Messenger", Toast.LENGTH_LONG).show()
        }    }

    override fun toInstaShare(uri: String) {
        try {
            // Check if the Twitter app is installed on the phone.
            //  activity!!.packageManager.getPackageInfo("com.twitter.android")
            val intent = Intent(Intent.ACTION_SEND)
            intent.setPackage("com.instagram.android")

            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, " الاختراع دة حوار \n $uri " )
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(activity, "Instagram is not installed on this device", Toast.LENGTH_LONG)
                .show()
        }

     }

    override fun toTwiiterShare(uri: String) {
        try {
            // Check if the Twitter app is installed on the phone.
          //  activity!!.packageManager.getPackageInfo("com.twitter.android")
            val intent = Intent(Intent.ACTION_SEND)
            intent.setPackage("com.twitter.android")

            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, " الاختراع دة حوار \n $uri " )
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(activity, "Twitter is not installed on this device", Toast.LENGTH_LONG)
                .show()
        }

    }

    override fun bindLink(uri: String) {
        share_link.text = uri    }

    override fun copylink(uri: String) {
        val clipboard =  context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("A2ol eh App", uri)
        clipboard.setPrimaryClip(clip)
        val snack = Snackbar.make(view?.rootView!!, "Copied ", Snackbar.LENGTH_SHORT)
        snack.show()
    }

    fun registerListners()
    {
        share_link.setOnClickListener{copylink(SharePresenter.fetchUri())}
        share_copy.setOnClickListener{copylink(SharePresenter.fetchUri())}
        whatsapp.setOnClickListener{toWhatsappShare(SharePresenter.fetchUri())}
        messanger.setOnClickListener{toMessngerShare(SharePresenter.fetchUri())}
        twitter.setOnClickListener{toTwiiterShare(SharePresenter.fetchUri())}
        insta.setOnClickListener{toInstaShare(SharePresenter.fetchUri())}


    }
}