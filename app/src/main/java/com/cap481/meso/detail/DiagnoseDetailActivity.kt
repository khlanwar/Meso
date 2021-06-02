package com.cap481.meso.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cap481.meso.R

class DiagnoseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnose_detail)
        supportActionBar?.hide()
    }
}