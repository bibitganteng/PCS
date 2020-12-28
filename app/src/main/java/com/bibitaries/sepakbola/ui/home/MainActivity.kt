package com.bibitaries.sepakbola.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.bibitaries.sepakbola.R
import com.bibitaries.sepakbola.databinding.ActivityMainBinding
import com.bibitaries.sepakbola.ui.auth.AuthActivity
import com.bibitaries.sepakbola.ui.auth.SepakbolaAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> navigate(R.id.homeFragment)
                R.id.ic_olahraga -> navigate (R.id.olahragaFragment)
                R.id.ic_favorite -> navigate(R.id.favoriteFragment)
                R.id.ic_profile -> navigate(R.id.profileFragment)
                else -> false
            }
        }
    }

    private fun navigate(id: Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true
    }
}