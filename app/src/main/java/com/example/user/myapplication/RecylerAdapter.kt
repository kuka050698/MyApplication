package com.example.user.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class RecylerAdapter(private val actor: ArrayList<Actor>,private val context:Context): RecyclerView.Adapter<RecylerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.list_item,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
     return actor.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.itemView!!.actor_name.text = actor[p1].name
        p0.itemView!!.film_name.text = actor[p1].film
    }

    class ViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
    }
}


