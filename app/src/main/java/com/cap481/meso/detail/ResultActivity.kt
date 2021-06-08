package com.cap481.meso.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cap481.meso.databinding.ActivityResultBinding
import com.cap481.meso.home.HomeActivity

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
        if (extras != null) {
            val result = extras.getBoolean(EXTRA_DATA)
            if (result) {
                binding.needConsultation.visibility = View.VISIBLE
            }
            else{
                binding.noneedConsultation.visibility = View.VISIBLE
            }
        }

        binding.finish.setOnClickListener{
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}