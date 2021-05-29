package com.example.meso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        var intent = Intent(this@WelcomeActivity, MainActivity::class.java)
        startActivity(intent)
    }
}