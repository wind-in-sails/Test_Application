package com.bignerdranch.android.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bignerdranch.android.testapplication.databinding.ActivityMainBinding
import com.bignerdranch.android.testapplication.DSOmodels.DSOUsers
import com.bignerdranch.android.testapplication.utils.ReadFileUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerViewAdapter = UserListRecyclerViewAdapter()
        binding.recyclerView.adapter = recyclerViewAdapter

        val users = ReadFileUtil.getJsonFromAssets(this, "users.json")
        val userList = ReadFileUtil.deserializeObject(users!!, DSOUsers::class.java)

        recyclerViewAdapter.setUsers(userList.users!!)
    }
}
