package com.cap481.meso.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.cap481.meso.databinding.ActivityMentalDetailBinding
import com.cap481.meso.utils.DataDummy
import com.cap481.meso.utils.MentalEntity

class MentalDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMentalDetailBinding

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMentalDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val extras = intent.extras
        if (extras != null) {
            val mentalId = extras.getString(EXTRA_DATA)
            if (mentalId != null) {
                for (mental in DataDummy.generateDummyMental()) {
                    if (mental.mentalId == mentalId) {
                        populateMental(mental)
                    }
                }
            }
        }
    }

    private fun populateMental(mentalEntity: MentalEntity) {
        binding.tvDetailTitle.text = mentalEntity.title
        binding.tvDetailDescription.text = mentalEntity.description

        Glide.with(this)
            .load(mentalEntity.image)
            .into(binding.ivDetailImage)
    }
}