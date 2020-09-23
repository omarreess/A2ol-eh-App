package com.omaressam.a2oleh.UI.RepliesTypes

import com.omaressam.a2oleh.Data.AdsFlags.adInitRequest
import com.omaressam.a2oleh.Data.RoomDb.gridListTypes

class RepliesTypesPresenter(repliesTypesView: RepliesTypesView) : RepliesTypesContract {
    val repliesTypesView:RepliesTypesView
    init {
        this.repliesTypesView=repliesTypesView
    }
    override fun getRepliesTypes():Array<String> {

        return gridListTypes
    }

    override fun makeList() {

       repliesTypesView.bindList(getRepliesTypes())

    }
    //if odd show ad
    override fun chechAdFlag(): Boolean = !(adInitRequest%2 == 0)







}