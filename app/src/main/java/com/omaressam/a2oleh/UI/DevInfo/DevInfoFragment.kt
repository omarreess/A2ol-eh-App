package com.omaressam.a2oleh.UI.DevInfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.omaressam.a2oleh.R
import kotlinx.android.synthetic.main.fragment_dev_info.*


class DevInfoFragment : Fragment() ,DevInfoView  {

    //Here i'm using Data without presenter layer , to be comptable with ma all projects
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerBtns()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return inflater.inflate(R.layout.fragment_dev_info, container, false)
    }

     //
    override fun toWhatsapp(uri: String)   {
        try {


            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_VIEW
             sendIntent.setData(Uri.parse(uri))
            sendIntent.setPackage("com.whatsapp")

                startActivity(sendIntent)

        } catch (e: Exception) {
            Toast.makeText(
                context,
                "Please install whatsapp ",
                Toast.LENGTH_LONG
            ).show()
           }
    }

    override fun toLinkidin(uri: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(uri)
        context!!.startActivity(intent)    }
    override fun toGmail(mail: String) {
         val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$mail"))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Slamme For Apps")
        emailIntent.putExtra(Intent.EXTRA_TEXT, "")

        startActivity(Intent.createChooser(emailIntent, "Chooser Title"))    }

    override fun toOurApps(uri: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(
                uri)
            setPackage("com.android.vending")
        }
        startActivity(intent)    }

    override fun toBack() {
        NavHostFragment.findNavController(this@DevInfoFragment).navigateUp()    }

     fun registerBtns()
     {
         whatsappdev.setOnClickListener {toWhatsapp("https://wa.me/+201097081508 ") }
         gmaildev.setOnClickListener { toGmail("omarreess@gmail.com") }
         linkiddev.setOnClickListener { toLinkidin("https://www.linkedin.com/in/omarreess/") }
         playstore.setOnClickListener {  toOurApps("https://play.google.com/store/apps/developer?id=Slamme+-+%D8%B3%D9%84%D8%A7%D9%85%D9%8A")}
         backdev.setOnClickListener{toBack()}



     }

}