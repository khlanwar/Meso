package com.cap481.meso.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cap481.meso.databinding.ActivityDiagnoseDetailBinding

class DiagnoseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnoseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiagnoseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnSubmit.setOnClickListener {
            intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }
    }
}