package com.cap481.meso.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.cap481.meso.databinding.ActivityDiagnoseDetailBinding

class DiagnoseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnoseDetailBinding
    private val delayTime: Long = 4000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiagnoseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val result = binding.rbMhiYes.text.toString().trim()

        binding.btnSubmit.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            Handler(mainLooper).postDelayed({
                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra(ResultActivity.EXTRA_DATA, result)
                startActivity(intent)
                finish()
            }, delayTime)
        }

    }
}