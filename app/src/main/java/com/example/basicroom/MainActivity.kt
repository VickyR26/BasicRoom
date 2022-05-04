package com.example.basicroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.basicroom.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*mainViewModel.saveUser(User(
            "Userid0002",
        "name0002",
        1.72,
        72.2,
            "user002emaill.com",
            "passworduser0002"
        )
        )*/

        mainViewModel.getUsers()
        //es con viewLifecycleOwner en lugar de this
        mainViewModel.savedUsers.observe(this, { usersList ->
            if (!usersList.isNullOrEmpty()) {
                for (user in usersList) {
                    Log.d("thesearretheusers", user.user_name)
                }
            }else{
                    Log.d("thesearretheusers", "null or empty")
            }
        })
    }
}