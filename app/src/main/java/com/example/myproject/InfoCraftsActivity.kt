package com.example.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class InfoCraftsActivity : AppCompatActivity() {
    lateinit var mNext:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crafts_info)
        mNext = findViewById(R.id.mBtnProceed)
        mNext.setOnClickListener {
                val proceed = Intent(this@InfoCraftsActivity, CraftsActivity::class.java)
                startActivity(proceed)
        }
    }
}