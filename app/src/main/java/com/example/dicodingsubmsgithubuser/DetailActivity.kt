package com.example.dicodingsubmsgithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.elevation = 0f

        val gguser = intent.getParcelableExtra<GithubUser>("keyGithubUser")

        supportActionBar?.subtitle = gguser?.name
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        idName.text = gguser?.name
        idUsername.text = gguser?.username
        idRepo.text = gguser?.repo
        idFolowers.text = gguser?.followers
        idFolowing.text = gguser?.following
        idComp.text = gguser?.comp
        idLoc.text = gguser?.loc
        gguser?.avatar?.let { idAva.setImageResource(it) }
    }
}


