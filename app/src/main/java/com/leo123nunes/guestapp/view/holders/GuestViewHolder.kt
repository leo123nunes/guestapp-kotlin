package com.leo123nunes.guestapp.view.holders

import android.app.AlertDialog
import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.leo123nunes.guestapp.R
import com.leo123nunes.guestapp.services.model.GuestModel
import com.leo123nunes.guestapp.view.listener.GuestListener
import kotlinx.android.synthetic.main.row_guest.view.*

class GuestViewHolder(itemView: View, val listener: GuestListener) : RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel){
        var textName = itemView.findViewById<TextView>(R.id.textNameResource)
        textName.text = guest.name

        textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        textName.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover){
                    dialog, which ->
                    listener.onDelete(guest.id)
                }.setNeutralButton(R.string.cancelar, null).show()
            true
        }
    }
}