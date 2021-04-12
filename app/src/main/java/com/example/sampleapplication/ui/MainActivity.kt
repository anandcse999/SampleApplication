package com.example.sampleapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.util.Util
import com.example.sampleapplication.helpers.ItemClickListenr
import com.example.sampleapplication.R
import com.example.sampleapplication.helpers.Status
import com.example.sampleapplication.data.model.ProfileDetails
import com.example.sampleapplication.util.Utils
import com.example.sampleapplication.viewmodel.ProfileViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClickListenr {
    lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        attachObserver()
    }


    fun initViewModel() {
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        profileViewModel.requestData(this)
    }

    fun attachObserver() {
        profileViewModel.getProfiles().observe(this, {
            when (it.status) {
                Status.LOADING -> {
                    progress_circular.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    progress_circular.visibility = View.GONE
                    if (!Utils.isNetworkAvailable(this))
                        showToast()

                }
                Status.SUCCESS -> {
                    progress_circular.visibility = View.GONE
                    rvList.adapter = ProfileAdapter(it.data!!, this, this)

                }
            }
        })
    }

    override fun onItemClick(profile: ProfileDetails, acceptStatus: Boolean) {
        profileViewModel.updateData(profile.key, acceptStatus, this)
    }

    fun showToast() {
        val snack: Snackbar = Snackbar.make(
            clParent,
            "check your network connection",
            Snackbar.LENGTH_LONG
        )
        val view = snack.view
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP
        view.layoutParams = params
        snack.show()
    }

}