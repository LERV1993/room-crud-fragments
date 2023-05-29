package com.example.tp_room_fragments.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String,
    var age: Int,
    var email: String,
    var lenguaje: String

)