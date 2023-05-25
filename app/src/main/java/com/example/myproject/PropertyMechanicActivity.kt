package com.example.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myproject.databinding.ActivityPropertyMechanicBinding

class PropertyMechanicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPropertyMechanicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyMechanicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(ProfileFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.profile -> replaceFragment(ProfileFragment())
//                R.id.inbox -> replaceFragment(InboxFragment())
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
