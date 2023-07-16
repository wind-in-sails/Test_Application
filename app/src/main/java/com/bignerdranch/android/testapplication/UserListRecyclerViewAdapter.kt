package com.bignerdranch.android.testapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bignerdranch.android.testapplication.databinding.UserItemBinding
import com.bignerdranch.android.testapplication.DSOmodels.DSOUser
import com.bignerdranch.android.testapplication.utils.IndexClickListener

class UserListRecyclerViewAdapter: RecyclerView.Adapter<UserListRecyclerViewAdapter.UserViewHolder>() {

    private var users: List<DSOUser> = listOf()

    private var selectedUserId: Int? = null

    fun setUsers(users: List<DSOUser>) {
        this.users = users
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        val isSelected = selectedUserId == user.id
        holder.bind(user, isSelected, IndexClickListener {
            selectedUserId = it
            val itemIndex = users.indexOf(user)
            notifyItemChanged(itemIndex)
        })
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UserViewHolder private constructor(private val binding: UserItemBinding): ViewHolder(binding.root) {
        fun bind(user: DSOUser, selectedUser: Boolean, clickListener: IndexClickListener) {
            binding.textView.text = user.name
            val textColor = when (selectedUser) {
                true -> Color.RED
                false -> Color.BLACK
            }
            binding.textView.setTextColor(textColor)
        }
        companion object {
            fun from(parent: ViewGroup): UserViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = UserItemBinding.inflate(inflater, parent, false)
                return UserViewHolder(binding)
            }
        }
    }
}
