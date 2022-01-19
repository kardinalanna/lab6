package com.example.lab6_1coroutine
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class MainCoroutine: AppCompatActivity() {
    var secondsElapsed: Int = 0
    private lateinit var prefernce: SharedPreferences
    lateinit var textSecondsElapsed: TextView

    companion object {
        const val TAG = "count"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefernce = getPreferences(MODE_PRIVATE)
        setContentView(R.layout.activity_main_coroutine)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)

        lifecycleScope.launchWhenResumed {
            Log.i(TAG, "start coroutine")
            while (true) {
                delay(1000)
                textSecondsElapsed.post {
                    textSecondsElapsed.text = "Seconds elapsed: " + secondsElapsed++
                    Log.i(TAG, "$secondsElapsed")
                }
            }
        }
    }

     override fun onStop() {
        super.onStop()
        prefernce.edit().putInt(TAG, secondsElapsed).apply()
    }

    override fun onResume() {
        super.onResume()
        secondsElapsed = prefernce.getInt(TAG, 0)
        Log.i(TAG, "not in onResume, coroutine stop in delay()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "cancel coroutine")
    }
}
