package com.midas.miworkdas.view.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.midas.miworkdas.model.response.User

object DiffUtil {
    val diffUtil = object: DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem.memberCode == newItem.memberCode

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
            oldItem == newItem

    }
}