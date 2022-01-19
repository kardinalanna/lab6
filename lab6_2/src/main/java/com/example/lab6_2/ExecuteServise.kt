package com.example.lab6_2

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ExecuteService : Application() {
   var executeService: ExecutorService = Executors.newSingleThreadExecutor()
}