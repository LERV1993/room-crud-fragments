package com.example.tp_room_fragments.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.tp_room_fragments.data.UserDB
import com.example.tp_room_fragments.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository() {

    private val userDao = UserDB.getDatabase().userDao()

    val readAllData: LiveData<List<User>> = liveData {
        withContext(Dispatchers.IO) {
            val data = userDao.readAllData()
            emitSource(data)
        }
    }

    suspend fun addUser(user: User) {
        userDao.addUser(user = user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }


    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

}