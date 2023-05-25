package com.example.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    lateinit var mHead:TextView
    lateinit var mChoice:TextView
    lateinit var mbPlumber:Button
    lateinit var mbMechanic:Button
    lateinit var mbCarpenter:Button
    lateinit var mbSignout:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        // Proceed to fid the views by ID's
        mHead = findViewById(R.id.mEdtMenu)
        mChoice = findViewById(R.id.mTvChoice)
        mbPlumber = findViewById(R.id.mBtnPlumber)
        mbMechanic = findViewById(R.id.mBtnMechanic)
        mbCarpenter = findViewById(R.id.mBtnCarpenter)
        mbSignout = findViewById(R.id.mBtnSignoute)
        // Set Oncklick listeners to the buttons
        mbPlumber.setOnClickListener {
            val signup = Intent(this@MenuActivity, PlumbersActivity::class.java)
            startActivity(signup)
        }
        mbMechanic.setOnClickListener {
//            val signup = Intent(this@MenuActivity, MechanicsActivity::class.java)
//            startActivity(signup)
        }
        mbCarpenter.setOnClickListener {
//            val signup = Intent(this@MenuActivity, CarpenterActivity::class.java)
//            startActivity(signup)
        }
        mbSignout.setOnClickListener {
            val signup = Intent(this@MenuActivity, MainActivity::class.java)
            startActivity(signup)
        }
    }
}