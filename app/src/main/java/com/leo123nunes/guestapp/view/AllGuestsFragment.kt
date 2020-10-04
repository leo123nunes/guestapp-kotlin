package com.leo123nunes.guestapp.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.leo123nunes.guestapp.R
import com.leo123nunes.guestapp.constants.GuestConstants
import com.leo123nunes.guestapp.view.adapters.GuestAdapter
import com.leo123nunes.guestapp.view.listener.GuestListener
import com.leo123nunes.guestapp.viewModel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {

    private lateinit var mViewModel: AllGuestsViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mViewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_all, container, false)

        var recycle = root.findViewById<RecyclerView>(R.id.recycle_All_Guests)

        recycle.layoutManager = LinearLayoutManager(context)

        recycle.adapter = mAdapter

        mListener = object: GuestListener{
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)

                var bundle = Bundle()

                bundle.putInt(GuestConstants.GUESTID,id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int){
                mViewModel.delete(id)
                mViewModel.load()
            }

        }

        mAdapter.attachListener(mListener)

        mViewModel.load()

        observer()

        return root
    }

    override fun onResume() {
        mViewModel.load()
        super.onResume()
    }

    private fun observer(){
        mViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuest(it)
        })
    }
}