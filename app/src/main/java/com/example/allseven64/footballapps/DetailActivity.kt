package com.example.allseven64.footballapps

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.*
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private  var name: String = ""
    private  var title: String = ""
    lateinit var nameTextView: TextView
    lateinit var titleTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout{

            val image = intent.getIntExtra("image", 0)
            imageView{
                imageResource = image
            }.lparams(width= matchParent) {
                padding = dip(20)
                height = dip(70)
                width = dip(70)
                gravity = Gravity.CENTER_HORIZONTAL
            }

            nameTextView = textView{
                gravity = Gravity.CENTER_HORIZONTAL
                textSize = sp(12).toFloat()
                typeface = Typeface.DEFAULT_BOLD
            }

            titleTextView = textView{

            }.lparams{
                topMargin = 20
            }

        }

        val intent = intent
        name = intent.getStringExtra("name")
        title = intent.getStringExtra("title")
        nameTextView.text = name
        titleTextView.text = title


    }
}
