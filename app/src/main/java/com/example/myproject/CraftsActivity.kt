package com.example.myproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myproject.databinding.ActivityCraftsBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class CraftsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCraftsBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var emailEt: TextInputEditText
    private lateinit var PasswEt: TextInputEditText
    private lateinit var referralEt: TextInputEditText
    private lateinit var confirmEt: TextInputEditText
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCraftsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        firebaseAuth = FirebaseAuth.getInstance()
        emailEt = findViewById(R.id.emailEt)
        PasswEt = findViewById(R.id.PasswEt)
        referralEt = findViewById(R.id.referralEt)
        confirmEt = findViewById(R.id.confirmEt)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val email = emailEt.text.toString()
            val pass = PasswEt.text.toString()
            val reffer = referralEt.text.toString()
            val confirmPass = confirmEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty() && reffer.isNotEmpty()) {
                if (pass == confirmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val intent = Intent(this, MenuActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Fill In All The Fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_crafts, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_s1 -> {
                Toast.makeText(this, "Light Mode", Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_s2 -> {
                Toast.makeText(this, "SignOut", Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_s3 -> {
                Toast.makeText(this, "Dark Mode", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
