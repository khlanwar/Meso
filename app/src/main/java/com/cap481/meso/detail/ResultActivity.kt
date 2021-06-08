package com.cap481.meso.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cap481.meso.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val extras = intent.extras
        val result = extras?.getString(EXTRA_DATA)

        binding.result.text = result
    }
}