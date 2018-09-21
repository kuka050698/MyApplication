package com.example.user.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ListAdapter
import android.widget.Toast
import com.example.user.myapplication.R.id.recyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val sizeOfArray = 8
    private lateinit var linearLayoutManager: LinearLayoutManager

    private var actors: ArrayList<Actor> = ArrayList()
    val adapter = RecylerAdapter(actors,this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        if (savedInstanceState != null){
//            Log.d("TAG", "list " + savedInstanceState.getSerializable("key"))
            actors = savedInstanceState.getSerializable("key") as ArrayList<Actor>
        }else{
            addingActors()
        }
        recyclerView.adapter = adapter
        fab.setOnClickListener{
            Toast.makeText(this,"Fab is clicked",Toast.LENGTH_SHORT).show()
            val actor = Actor("Abc${actors.size}","It")
            actors.add(actor)
            //adapter.notifyItemInserted(actors.size)

        }
    }

    private fun addingActors() {
        for(i in 0 until 5){
            val actor = Actor("Johnny$i","Pirates of the Caribbean sea")
            actors.add(actor)
            adapter.notifyItemInserted(actors.size)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putSerializable("key",actors)
    }
}
