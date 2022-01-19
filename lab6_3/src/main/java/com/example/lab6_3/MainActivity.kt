package com.example.lab6_3

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "download"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var profile_photo = findViewById<ImageView>(R.id.photo)

        lifecycleScope.launch(Dispatchers.IO) {
            Log.i(TAG, "can download")
            val newurl =
                URL("https://i.postimg.cc/ry7LSF8V/7532821624224d0ca7745204e904dce3.jpg")
            val mIcon_val =
                BitmapFactory.decodeStream(newurl.openConnection().getInputStream())
            withContext(Dispatchers.Main){
                profile_photo.setImageBitmap(mIcon_val)
                Log.i(TAG, "set photo in corountine")
            }
        }

    }
}