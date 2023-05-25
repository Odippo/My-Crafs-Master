package com.example.myproject

import com.google.firebase.database.FirebaseDatabase
import android.content.Intent
import com.google.firebase.FirebaseApp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase

    // Initiate the elements on the user interface as variables
    lateinit var mAsk: TextView
    lateinit var mQueri: TextView
    lateinit var mBtnSignup: Button
    lateinit var mBtnSignin: Button
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = Firebase.auth
        // Initialize Firebase
        FirebaseApp.initializeApp(this)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        database = FirebaseDatabase.getInstance()
        val myDataRef = database.reference.child("data")

        // Example: Writing a single value
        myDataRef.setValue("Hello, Firebase!")

        // Example: Writing multiple values
        val dataMap = HashMap<String, Any>()
        dataMap["name"] = "John Doe"
        dataMap["age"] = 25
        dataMap["email"] = "john.doe@example.com"
        myDataRef.updateChildren(dataMap)

        // find views by Id's
        mBtnSignup = findViewById(R.id.btnSignup)
        mBtnSignin = findViewById(R.id.btnSignIn)
        mQueri = findViewById(R.id.mTvQueri)
        mAsk = findViewById(R.id.mtvAsk)

        mAuth = FirebaseAuth.getInstance()

        // Set OnClickListener to the Signup and Sign in button

        mBtnSignup.setOnClickListener {
            val signup = Intent(this@MainActivity, SignupActivity::class.java)
            startActivity(signup)
        }
        mBtnSignin.setOnClickListener {
            val sign = Intent(this@MainActivity, SigninActivity::class.java)
            startActivity(sign)
        }

    }
}
