package com.omaressam.a2oleh.UI.Splash

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.omaressam.a2oleh.R
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.lang.Boolean.FALSE
import kotlin.math.log


class SplashFragment : Fragment() ,   SplashView {
    override   var viewContext: Context? =null
  lateinit  var SplashPresenter : SplashPresenter



     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         viewContext = this.context
         SplashPresenter= SplashPresenter(this)
     }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }




    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        ProgressShowHide( show = true)



    }

    override fun onStart() {
        super.onStart()
        //Courtine Scope for manging Checking , init process of DB
        runBlocking {

            launch { val checked =  async(Dispatchers.IO) {SplashPresenter.CheckInitDb()}.await()


                if (!checked) {   async (Dispatchers.IO){    SplashPresenter.InitDb()}.await()

                }
                SplashPresenter.InitDbFlag()
            }


        }
        //Coroutine for holding Screen for secs , then switch toS econd Screen
        GlobalScope.launch {
            async { delay(1850)  }.await()
            ToNextScreen()
        }
    }

    override fun ProgressShowHide(show: Boolean) {
    if (show)   {SplashProgress.visibility = ProgressBar.VISIBLE}
    else {SplashProgress.visibility=ProgressBar.INVISIBLE}                    }

    override fun ToNextScreen() {

         findNavController(this).navigate(R.id.action_splashFragment_to_repliesTypesFragment)    }




}