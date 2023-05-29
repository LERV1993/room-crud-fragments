package com.example.tp_room_fragments.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tp_room_fragments.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM usuarios ORDER BY id ASC")
    suspend fun readAllData(): LiveData<List<User>>

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User): Int

}