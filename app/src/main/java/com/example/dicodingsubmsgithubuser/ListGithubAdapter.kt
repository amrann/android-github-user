package com.example.dicodingsubmsgithubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListGithubAdapter (private var itemList: ArrayList<GithubUser>, private val listener: AdapterView.OnItemClickListener) :
    RecyclerView.Adapter<ListGithubAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var poto: ImageView = view.findViewById(R.id.poto)
        var txtname: TextView = view.findViewById(R.id.txtName)
        var txtlocation: TextView = view.findViewById(R.id.txtLocation)
        var txtcompany: TextView = view.findViewById(R.id.txtCompany)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val githubUser = itemList[position]
        holder.poto.setImageResource(githubUser.avatar)
        holder.txtname.text =githubUser.name
        holder.txtcompany.text =githubUser.comp
        holder.txtlocation.text =githubUser.loc

        // code ini berfungsi utk menunjukkan aksi ketika list item di klik
        holder.itemView.setOnClickListener(View.OnClickListener {
            listener.onItemClick(null, holder.itemView, position, holder.itemId)
        })
    }
}

