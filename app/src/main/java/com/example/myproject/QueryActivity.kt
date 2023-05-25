package com.example.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class QueryActivity : AppCompatActivity() {
    // Initiate the elements on the user interface as variables
    lateinit var mQuery:TextView
    lateinit var mAsk:TextView
    lateinit var mCraft:Button
    lateinit var mProperty:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_query)
    // Find views by ID's
        mQuery = findViewById(R.id.mTvQuery)
        mAsk = findViewById(R.id.mTvAsk)
        mCraft = findViewById(R.id.mBtnCraft)
        mProperty = findViewById(R.id.mBtnOwner)
        // Set onclick listeners to the buttons
        mCraft.setOnClickListener {
            val craft = Intent(this@QueryActivity, InfoCraftsActivity::class.java)
            startActivity(craft)
        }
        mProperty.setOnClickListener {
            val property = Intent(this@QueryActivity, HomeActivity::class.java)
            startActivity(property)
        }
    }
}