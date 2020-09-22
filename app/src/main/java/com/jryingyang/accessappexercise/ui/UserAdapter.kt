package com.jryingyang.accessappexercise.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jryingyang.accessappexercise.api.UserResponse

class UserAdapter : ListAdapter<UserResponse, RecyclerView.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            (holder as UserViewHolder).bind(item)
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<UserResponse>() {
            override fun areItemsTheSame(oldItem: UserResponse, newItem: UserResponse): Boolean =
                oldItem.login == newItem.login

            override fun areContentsTheSame(oldItem: UserResponse, newItem: UserResponse): Boolean =
                oldItem == newItem
        }
    }
}