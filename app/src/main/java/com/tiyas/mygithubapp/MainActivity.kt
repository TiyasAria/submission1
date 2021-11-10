package com.tiyas.mygithubapp

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tiyas.mygithubapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  val list = ArrayList<User>()

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()

        list.addAll(getDataUser())
        mainBinding.rvUser.setHasFixedSize(true)
        showRecylerList()
    }

    private fun showRecylerList() {
        mainBinding.rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        mainBinding.rvUser.adapter = listUserAdapter
    }

    private fun getDataUser(): ArrayList<User> {
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataPhoto : TypedArray = resources.obtainTypedArray(R.array.avatar)
        val listUser = ArrayList<User>()
        for (position in dataName.indices){
            val user = User(
                dataName[position],
                dataUsername[position],
                dataPhoto.getResourceId(position, -1)
            )
            listUser.add(user)
        }
       return  listUser
    }
}