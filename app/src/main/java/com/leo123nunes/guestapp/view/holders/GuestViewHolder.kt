package com.leo123nunes.guestapp.view.holders

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.leo123nunes.guestapp.R
import com.leo123nunes.guestapp.services.model.GuestModel
import kotlinx.android.synthetic.main.row_guest.view.*

class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel){
        var textName = itemView.findViewById<TextView>(R.id.textNameResource)
        textName.text = guest.name
    }
}