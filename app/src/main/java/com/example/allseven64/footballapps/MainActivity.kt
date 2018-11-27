package com.example.allseven64.footballapps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private var items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter (this, items){
           // val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
           //toast.show()
            startActivity<DetailActivity>("name" to it.name, "image" to it.image, "title" to it.title)
        }

    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val title = resources.getStringArray(R.array.club_title)

        items.clear()
        for (i in name.indices){
            items.add(Item(name[i], image.getResourceId(i,0), title[i]))
        }

        //Recycle the typed array
        image.recycle()

    }
}
