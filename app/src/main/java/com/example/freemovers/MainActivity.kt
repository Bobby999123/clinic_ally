package com.example.freemovers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide();
        val handler = Handler()
        val runnable = Runnable {
            val i = Intent(this, CreateAccount::class.java)
            startActivity(i)
        }
        handler.postDelayed(runnable, 5000)
    }
}