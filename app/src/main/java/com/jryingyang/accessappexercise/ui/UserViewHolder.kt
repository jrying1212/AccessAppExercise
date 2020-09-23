package com.jryingyang.accessappexercise.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jryingyang.accessappexercise.databinding.UserItemBinding
import com.jryingyang.accessappexercise.model.User

class UserViewHolder(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: User) {
        binding.user = item
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): UserViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = UserItemBinding.inflate(layoutInflater, parent, false)
            return UserViewHolder(binding)
        }
    }
}