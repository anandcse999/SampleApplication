package com.example.sampleapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.sampleapplication.helpers.ItemClickListenr
import com.example.sampleapplication.R
import com.example.sampleapplication.data.model.ProfileDetails
import com.example.sampleapplication.databinding.ProfileItemBinding

class ProfileAdapter(
    val profileList: List<ProfileDetails>,
    val mContext: Context,
    val onItemClickListener: ItemClickListenr
) :
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    inner class ProfileViewHolder(itemView: View, profileItemBinding: ProfileItemBinding) :
        RecyclerView.ViewHolder(itemView) {
        lateinit var profileItemBinding: ProfileItemBinding

        init {
            this.profileItemBinding = profileItemBinding
            setOnClickLister()
        }

        private fun setOnClickLister() {
            profileItemBinding.llAccept.setOnClickListener {
                onItemClickListener.onItemClick(profileList[adapterPosition], true)
                profileItemBinding.tvStatus.visibility=View.VISIBLE
                profileItemBinding.llReject.visibility=View.GONE
                profileItemBinding.llAccept.visibility=View.GONE
                profileItemBinding.tvStatus.text="Profile Accepted"

            }
            profileItemBinding.llReject.setOnClickListener {
                onItemClickListener.onItemClick(profileList[adapterPosition], false)
                profileItemBinding.tvStatus.visibility=View.VISIBLE
                profileItemBinding.llReject.visibility=View.GONE
                profileItemBinding.llAccept.visibility=View.GONE
                profileItemBinding.tvStatus.text="Profile Rejected"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val profileItemBinding =
            ProfileItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileViewHolder(profileItemBinding.root, profileItemBinding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profileDetail = profileList.get(position)
        holder.profileItemBinding.profile = profileDetail
        Glide.with(mContext)
            .load(profileDetail.picture?.large)
            .apply(
                RequestOptions().centerCrop().dontAnimate().placeholder(R.color.black)
                    .diskCacheStrategy(DiskCacheStrategy.ALL).error(R.color.black)
            )
            .into(holder.profileItemBinding.ivProfile)
    }

    override fun getItemCount(): Int {
        return profileList.size
    }
}