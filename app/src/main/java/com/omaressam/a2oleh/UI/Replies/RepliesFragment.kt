package com.omaressam.a2oleh.UI.Replies

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.omaressam.a2oleh.Data.AdsFlags
import com.omaressam.a2oleh.Data.RoomDb.*
import com.omaressam.a2oleh.R
import com.omaressam.a2oleh.UI.ShareApp.ShareFragment
import kotlinx.android.synthetic.main.fragment_replies.*
import kotlinx.android.synthetic.main.reply_copy_adbanner.*


class RepliesFragment : Fragment() , RepliesView {

    override lateinit var   viewContext: Context
    override lateinit var viewRoot: View

    private lateinit var mInterstitialAd: InterstitialAd


    lateinit  var   RepliesPresenter :RepliesPresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewRoot= getView()!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewContext = this.getContext()!!
        RepliesPresenter =  RepliesPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return inflater.inflate(R.layout.fragment_replies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Show Shimmer loading
        progressShowHide(true)
        //logo translate
        logoAnimation()
        //init ads
        loadingInistAd()
         // loadingBannerAd()

        //Register Toogle Btn Listener
        registerListners()

    }

    override fun onStart() {
        super.onStart()
        //make list
        RepliesPresenter.fetchRepliesList(TypeWhich(arguments!!.getInt("position")))
    }

    override fun toBack() {
        flagInc()
        findNavController(this@RepliesFragment).navigateUp()
     }

    override fun progressShowHide(show: Boolean) {
        if (show){ shimmerloading.visibility = View.VISIBLE
            shimmerloading.startShimmerAnimation()

           }
        else {  shimmerloading.visibility = View.INVISIBLE
            shimmerloading.stopShimmerAnimation()}
             }

    override fun showShareDiaolge() {
        val ShareFragment = ShareFragment()

         ShareFragment.show(childFragmentManager, ShareFragment.tag)

     }

    override fun BindRepliesList(arr: ArrayList<String>) {
        list_replies.setHasFixedSize(true)
        list_replies.layoutManager= LinearLayoutManager(context)
        list_replies.adapter= RepliesListAdapter(arr, this)
     }

    override fun itemClicked(reply: String) {
        //check to show InistAd or not
        if (RepliesPresenter.chechAdFlag()) {showInistAd()}
        //copy text
        RepliesPresenter.copyReplies(reply)


    }

    override fun logoAnimation() {
        val transition: Transition = TransitionInflater.from(context)
            .inflateTransition(R.transition.logo_translate)
        sharedElementEnterTransition = transition
    }

    override fun loadingBannerAd() {
        MobileAds.initialize(context)

        val adRequest = AdRequest.Builder().build()
        reply_adbanner.loadAd(adRequest)
     }

    override fun loadingInistAd() {
        MobileAds.initialize(context)
        mInterstitialAd = InterstitialAd(context)
        mInterstitialAd.adUnitId = resources.getString(R.string.replies_init_ad)

        mInterstitialAd.loadAd(AdRequest.Builder().build())
    }

    override fun showInistAd() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        }

    }

    override fun flagInc() {
        if(!AdsFlags.flagInc)
        {
            AdsFlags.adInitRequest++
            AdsFlags.flagInc=true
        }
    }

    override fun TypeWhich(postion: Int): String {
        return when (postion) {
            0 -> type_congrats
            1 -> type_birthday
            2 -> type_newpic
            3 -> type_funeral

            else -> type_newpic
        }
    }
     fun registerListners()
     {
         male .setOnClickListener{RepliesPresenter.changeGender(gender_male)}
         female.setOnClickListener{RepliesPresenter.changeGender(gender_female)}
         back_imgbtn.setOnClickListener{toBack()}
         share_btn.setOnClickListener{showShareDiaolge()}
     }


    override fun onPause() {
        super.onPause()
        flagInc()
    }
}