package com.example.tp_room_fragments.adapter

import com.example.tp_room_fragments.model.User

interface AdapterListener {

    fun onEditItemClick(user: User)
    fun onDeleteItemClick(user: User)

}