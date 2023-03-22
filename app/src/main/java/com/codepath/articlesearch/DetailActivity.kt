package com.codepath.articlesearch

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var languageTextView: TextView
    private lateinit var abstractTextView: TextView
    private lateinit var releasedateTextView: TextView
    private lateinit var adultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.mediaImage)
        titleTextView = findViewById(R.id.mediaTitle)
        languageTextView = findViewById(R.id.mediaLanguage)
        abstractTextView = findViewById(R.id.mediaoverview)
        releasedateTextView = findViewById(R.id.mediaRelease)
        adultTextView = findViewById(R.id.mediaadult)


        // TODO: Get the extra from the Intent
        val article = intent.getSerializableExtra(ARTICLE_EXTRA) as Article


        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = article.title
        //languageTextView.text = article.language
        if(article.language=="en"){
            languageTextView.text="English"
        }
        abstractTextView.text = article.abstract
        releasedateTextView.text="Release Date: "+article.release
        if(article.adult.toString()=="true"){
            adultTextView.text="R"
        }
        else{
            adultTextView.setTextColor(Color.parseColor("#008000"))
            adultTextView.text="PG-13"
        }
        //adultTextView.text="Adult Rating: "+article.adult.toString()

        // TODO: Load the media image
        Glide.with(this)
            .load(article.mediaImageUrl)
            .into(mediaImageView)
    }
}