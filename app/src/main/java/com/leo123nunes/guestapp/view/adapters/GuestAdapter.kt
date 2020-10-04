package com.leo123nunes.guestapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leo123nunes.guestapp.R
import com.leo123nunes.guestapp.services.model.GuestModel
import com.leo123nunes.guestapp.view.holders.GuestViewHolder
import com.leo123nunes.guestapp.view.listener.GuestListener

class GuestAdapter: RecyclerView.Adapter<GuestViewHolder>() {

    private var mGuestList: List<GuestModel> = arrayListOf()

    private lateinit var mListener: GuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        var item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest, parent, false)
        return GuestViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mGuestList.count()
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    fun updateGuest(list: List<GuestModel>){
        mGuestList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: GuestListener){
        mListener = listener
    }

}