package com.example.tp_room_fragments.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp_room_fragments.model.User
import com.example.tp_room_fragments.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel: ViewModel() {


    private val userRepository = UserRepository()
    val readAllData: LiveData<List<User>> = userRepository.readAllData


    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addUser(user = user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.updateUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch (Dispatchers.IO) {
            userRepository.deleteUser(user = user)
        }
    }

}