package com.jryingyang.accessappexercise.ui

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jryingyang.accessappexercise.model.User

class UserAdapter(private val listener: UserItemClickListener) :
    PagingDataAdapter<User, RecyclerView.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            (holder as UserViewHolder).bind(item, listener)
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem.login == newItem.login

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem == newItem
        }
    }

}