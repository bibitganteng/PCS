package com.bibitaries.sepakbola.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.databinding.DataBindingUtil
import com.bibitaries.sepakbola.R
import com.bibitaries.sepakbola.databinding.ActivityMainBinding
import com.bibitaries.sepakbola.ui.auth.AuthActivity
import com.bibitaries.sepakbola.ui.auth.SepakbolaAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLoguot.setOnClickListener {
            SepakbolaAuth.logout(this) {
                startActivity(Intent(this,AuthActivity::class.java))
                finish()
            }
        }
    }
}