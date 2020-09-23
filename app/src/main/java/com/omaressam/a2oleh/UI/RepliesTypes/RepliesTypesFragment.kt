package com.omaressam.a2oleh.UI.RepliesTypes

import android.R.attr.logo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.omaressam.a2oleh.R
import kotlinx.android.synthetic.main.fragment_replies_types.*


class RepliesTypesFragment : Fragment() , RepliesTypesView {
    private lateinit var  repliesTypesPresenter:RepliesTypesPresenter

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repliesTypesPresenter = RepliesTypesPresenter(this)

        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //regester btns
        infoClicked()
        //init ads
        loadingInistAd()
        loadingBannerAd()
        //make list
        repliesTypesPresenter.makeList()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_replies_types, container, false)
    }

    override fun bindList(arr: Array<String>) {

         list_types.setHasFixedSize(true)
        list_types.layoutManager=GridLayoutManager(context, 2)
        list_types.adapter=RepliesTypesListAdapter(arr, this)




    }

    override fun replyClicked(postion: Int) {
        //check to show InistAd or not
         if (repliesTypesPresenter.chechAdFlag()) {showInistAd()}

        //Switch to next screen
        val bundle = Bundle()
        bundle.putInt("position", postion)
        val extras = FragmentNavigator.Extras.Builder()
            .addSharedElement(logo_name, "logo_translate").build()


        view!!.findNavController().navigate(
            R.id.action_repliesTypesFragment_to_repliesFragment,bundle ,null,extras

        )
     }

    override fun loadingInistAd() {

        MobileAds.initialize(context)
        mInterstitialAd = InterstitialAd(context)
        mInterstitialAd.adUnitId = resources.getString(R.string.replies_types_init_ad)

        mInterstitialAd.loadAd(AdRequest.Builder().build())
    }

    override fun loadingBannerAd() {


        MobileAds.initialize(context)

        val adRequest = AdRequest.Builder().build()
        adbanner_types.loadAd(adRequest)
    }

    override fun showInistAd() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        }
    }

    fun infoClicked()
    {dev_info_imgbtn.setOnClickListener {view!!.findNavController().navigate(
        R.id.action_repliesTypesFragment_to_devInfoFragment

    )  }}
}