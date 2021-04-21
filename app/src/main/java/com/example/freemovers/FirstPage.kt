package com.example.freemovers

import android.app.Notification
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_first_page.*
import kotlinx.android.synthetic.main.activity_login.*

class FirstPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)

        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")
//        val name = intent.getStringExtra("name")

        tvv.text = "Hii, You are registered Successfully."
        button.setOnClickListener {
            startActivity(Intent(this,MapsActivity::class.java))
//            onBackPressed()
        }
//        notify.setOnClickListener {
//            val message="This is a notification example"
//            NotificationCompat.Builder builder=new NotificationCompat.Builder{
//
//            }
//        }
    }
}