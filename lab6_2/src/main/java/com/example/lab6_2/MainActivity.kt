package com.example.lab6_2

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import java.net.URL
import java.util.concurrent.Future

class MainActivity : AppCompatActivity() {
    lateinit var profile_photo: ImageView
    lateinit var future: Future<*>

    companion object{
        const val TAG = "download"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "in onCreat")
        setContentView(R.layout.activity_main)
        profile_photo = findViewById(R.id.photo)
        future =  (application as ExecuteService).executeService.submit {
            Log.i(TAG, "can download")
            val newurl =
                URL("https://i.postimg.cc/ry7LSF8V/7532821624224d0ca7745204e904dce3.jpg")
            val mIcon_val =
                BitmapFactory.decodeStream(newurl.openConnection().getInputStream())
            profile_photo.post {
                profile_photo.setImageBitmap(mIcon_val)
                Log.i(TAG, "set photo")
            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        future.cancel(true)
        Log.i(TAG, "cancel in onDestroy")
    }
}