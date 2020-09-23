package com.omaressam.a2oleh.UI.Replies

import android.content.res.ColorStateList
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.omaressam.a2oleh.R
import com.omaressam.a2oleh.UI.Replies.RepliesListAdapter.itemTypes.adItem
import com.omaressam.a2oleh.UI.Replies.RepliesListAdapter.itemTypes.lastItem
import com.omaressam.a2oleh.UI.Replies.RepliesListAdapter.itemTypes.normalItem
import kotlinx.android.synthetic.main.fragment_replies_types.*
import kotlinx.android.synthetic.main.reply_copy_adbanner.view.*
import kotlinx.android.synthetic.main.reply_copy_item.view.*
import kotlinx.android.synthetic.main.reply_copy_item.view.reply_copy_line

class RepliesListAdapter (val listItems : ArrayList<String>, val repliesView:RepliesView ) : RecyclerView.Adapter<RepliesListAdapter.ViewHolder>() {
   object itemTypes {
       val normalItem=0
       val adItem=1
       var lastItem:Int =0
   }



    init {
        lastItem=listItems.size


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater:View
        if(viewType==normalItem)
        { inflater = LayoutInflater.from(parent.context).inflate(R.layout.reply_copy_item, parent, false)}
        else{ inflater = LayoutInflater.from(parent.context).inflate(R.layout.reply_copy_adbanner, parent, false)}

        return ViewHolder(inflater, repliesView , viewType)    }

    override fun getItemCount() = listItems.size


    override fun getItemViewType(position: Int): Int {
        //so every 4 items , Bind a adbanner
        if(position%4==0){return super.getItemViewType(adItem)}
        else {return super.getItemViewType(normalItem)}

    }

    override fun onBindViewHolder(holder: RepliesListAdapter.ViewHolder, position: Int) {

        holder.bind (listItems.get(position)  , position )    }




    class ViewHolder (var view : View , var RepliesView: RepliesView , var viewType: Int): RecyclerView.ViewHolder(view)  {

        private var textview: TextView? = null


        init {

            if(viewType== normalItem)
            {
                textview = view.findViewById(R.id.reply_copy_text)
                val te:String = textview.toString()

            }
            else
            { MobileAds.initialize(RepliesView.viewContext)

                val adRequest = AdRequest.Builder().build()
                view.reply_adbanner.loadAd(adRequest)

            }


        }

        fun bind (item : String , postion:Int ){
            if(viewType== normalItem)
            {
                textview?.let { it.text=item }
                if(layoutPosition== lastItem-1){view.reply_copy_line.visibility=View.INVISIBLE}
                textview?.setOnClickListener {  RepliesView.itemClicked( item )}
                view.reply_copy_imgbtn?.setOnClickListener {  RepliesView.itemClicked( item )}

            }



        }
    }
}
