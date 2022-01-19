package com.example.lab6_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image = findViewById<ImageView>(R.id.photo)
        Picasso.get().load("https://i.postimg.cc/ry7LSF8V/7532821624224d0ca7745204e904dce3.jpg").into(image)
    }
}