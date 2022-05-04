package com.example.basicroom

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicroom.database.DatabaseManager
import com.example.basicroom.database.MyCoroutines
import com.example.basicroom.database.User
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    fun saveUser(user: User) {
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).save(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).delete(user)
        }
    }

    val savedUsers = MutableLiveData<List<User>>()
    fun getUsers(){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            savedUsers.value= MyCoroutines(userDao).getUsers().value
        }
    }

}