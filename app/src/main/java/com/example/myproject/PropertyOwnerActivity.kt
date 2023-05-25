package com.example.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PropertyOwnerActivity : AppCompatActivity() {
    lateinit var mMenu:TextView
    lateinit var mChoice:TextView
    lateinit var mPlumber:Button
    lateinit var mCarpenter:Button
    lateinit var mMechanic:Button
    lateinit var mSignOut:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_owner)
        mMenu = findViewById(R.id.mEdtMenu)
        mChoice = findViewById(R.id.mTvChoice)
        mPlumber = findViewById(R.id.mBtnPlumber)
        mCarpenter = findViewById(R.id.mBtnCarpenter)
        mMechanic = findViewById(R.id.mBtnMechanic)
        mSignOut = findViewById(R.id.mBtnSignoute)
        // Set onclick listeners
        mPlumber.setOnClickListener {
            val plumber = Intent(this@PropertyOwnerActivity, PropertyPlumberActivity::class.java)
            startActivity(plumber)
        }
        mCarpenter.setOnClickListener {
            val carpenter = Intent(this@PropertyOwnerActivity, PropertyCarpenterActivity::class.java)
            startActivity(carpenter)
        }
        mMechanic.setOnClickListener {
            val mechanic = Intent(this@PropertyOwnerActivity, PropertyMechanicActivity::class.java)
            startActivity(mechanic)
        }
        mSignOut.setOnClickListener {
            val signout = Intent(this@PropertyOwnerActivity, MainActivity::class.java)
            startActivity(signout)
        }
    }
}