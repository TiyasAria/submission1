package com.tiyas.mygithubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.tiyas.mygithubapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        private  var EXTRA_USERNAME = "extra_username"
    }

    private  lateinit var  detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.hide()

        var user = intent.getParcelableExtra<User>(EXTRA_USERNAME) as User
        Glide.with(this).load(user.photo).into(detailBinding.ivProfileDetail)
        detailBinding.tvNameDetail.text = user.name
        detailBinding.tvUsernameDetail.text = user.username
        detailBinding.tvCompany.text = user.company
        detailBinding.tvLocation.text = user.location
        detailBinding.tvRepo.text = user.repository
        detailBinding.tvFollowers.text = user.followers
        detailBinding.tvFollowing.text = user.following


    }
}