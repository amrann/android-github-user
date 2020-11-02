package com.example.dicodingsubmsgithubuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener{
    private lateinit var dataPoto: TypedArray
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataRepository: Array<String>
    private var githubUsers = arrayListOf<GithubUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        idListLayout.adapter = ListGithubAdapter(githubUsers, this)
        idListLayout.layoutManager = LinearLayoutManager(this)
        idListLayout.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        prepare()
        tambahItem()
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, i: Int, id: Long) {
        val intent = Intent(this, DetailActivity::class.java)
        val guser = githubUsers[i]
        intent.putExtra("keyGithubUser", guser)
        startActivity(intent)
    }

    private fun prepare() {
        dataPoto = resources.obtainTypedArray(R.array.data_avatar)
        dataName = resources.getStringArray(R.array.data_name)
        dataLocation = resources.getStringArray(R.array.data_location)
        dataCompany = resources.getStringArray(R.array.data_company)
        dataUsername = resources.getStringArray(R.array.data_username)
        dataFollowers = resources.getStringArray(R.array.data_followers)
        dataFollowing = resources.getStringArray(R.array.data_following)
        dataRepository = resources.getStringArray(R.array.data_repository)
    }

    private fun tambahItem() {
        for (x in dataName.indices) {
            val gu = GithubUser(
                dataName[x],
                dataLocation[x],
                dataCompany[x],
                dataPoto.getResourceId(x, -1),
                dataUsername[x],
                dataFollowers[x],
                dataFollowing[x],
                dataRepository[x]
            )
            githubUsers.add(gu)
        }
    }
}