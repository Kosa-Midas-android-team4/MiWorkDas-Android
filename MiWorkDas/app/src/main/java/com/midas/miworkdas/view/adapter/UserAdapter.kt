package com.midas.miworkdas.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.midas.miworkdas.R
import com.midas.miworkdas.databinding.ItemUsersBinding
import com.midas.miworkdas.model.response.User
import com.midas.miworkdas.view.activity.UserDetailActivity
import com.midas.miworkdas.view.adapter.diffutil.DiffUtil

class UserAdapter(val context: Context): ListAdapter<User, UserAdapter.ViewHolder>(DiffUtil.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemUsersBinding>(LayoutInflater.from(parent.context), R.layout.item_users, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(val binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User){
            binding.usersDepart.text = user.memberDepart
            binding.usersPhone.text = user.memberPhone
            binding.usersWorkView.isVisible = user.isWorking > 0
            binding.usersName.text = "${user.memberName} ${user.memberRank}"

            binding.usersView.setOnClickListener {
                val intent = Intent(context, UserDetailActivity::class.java)
                intent.putExtra("memberCode", user.memberCode)
                context.startActivity(intent)
            }
        }

    }
}