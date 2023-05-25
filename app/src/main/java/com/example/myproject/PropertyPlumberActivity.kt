package com.example.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

// Import the necessary classes
import com.example.myproject.databinding.ActivityPropertyPlumberBinding

class PropertyPlumberActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPropertyPlumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyPlumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(ProfileFragment())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.profile -> replaceFragment(ProfileFragment())
                // R.id.nav_inbox -> replaceFragment(InboxFragment())
                R.id.payment -> replaceFragment(PaymentFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
