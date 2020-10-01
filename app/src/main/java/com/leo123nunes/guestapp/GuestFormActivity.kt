package com.leo123nunes.guestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.leo123nunes.guestapp.viewModel.GuestFormViewModel
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var guestViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        guestViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
        observers()
    }

    fun observers(){
        guestViewModel.guestFormViewModel.observe(this, Observer{
            if(guestViewModel.presenceGuestFormViewModel.value==true){
                Toast.makeText(applicationContext,"Convidado $it adicionado.",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext,"Convidado $it não confirmação.",Toast.LENGTH_LONG).show()
            }
        })
    }

    fun setListeners(){
        buttonSave.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        var id = v.id
        if (id == R.id.buttonSave){
            guestViewModel.addGuest(guestName.text.toString(),button_presence.isChecked())
        }
    }



}