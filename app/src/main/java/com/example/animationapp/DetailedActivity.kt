package com.example.animationapp

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideContext

class DetailedActivity:AppCompatActivity() {
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        imageView = findViewById(R.id.detailedImageView)
        val intent = getIntent()
        val url = intent.extras?.getString("detailed page")
        Glide.with(this).load(url).into(imageView)

    }

}