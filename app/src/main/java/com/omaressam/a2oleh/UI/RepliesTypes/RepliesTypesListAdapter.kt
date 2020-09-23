package com.omaressam.a2oleh.UI.RepliesTypes

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.omaressam.a2oleh.R

class RepliesTypesListAdapter ( val listItems : Array<String> , val repliesView:RepliesTypesView ) : RecyclerView.Adapter<RepliesTypesListAdapter.ViewHolder>() {
     init {
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.replies_types_item, parent, false)
        return ViewHolder(inflater, repliesView)    }

    override fun getItemCount() = listItems.size



    override fun onBindViewHolder(holder: RepliesTypesListAdapter.ViewHolder, position: Int) {
        holder.bind (listItems.get(position)  , position )    }




    class ViewHolder (var view : View , RepliesView: RepliesTypesView): RecyclerView.ViewHolder(view)  {

        private var textview: TextView? = null


        init {

            textview = view.findViewById(R.id.types_item)
            view.setOnClickListener {  RepliesView.replyClicked(layoutPosition)}
        }

        fun bind (item : String , postion:Int ){
            when (postion) {
                0 -> textview!!.background.setTint(view.resources.getColor(R.color.pirpule))
                1 -> textview!!.background.setTint(view.resources.getColor(R.color.pink_darker))
                2-> textview!!.background.setTint(view.resources.getColor(R.color.green_lighter))
                3 -> textview!!.background.setTint(view.resources.getColor(R.color.grey))

            }

            textview?.let { it.text=item }

        }
    }
}
