package com.bibitaries.sepakbola.ui.olahraga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bibitaries.sepakbola.R

class OlahragaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_olahraga)
    }
    companion object {
        const val OPEN_OLAHRAGA="open_olahraga"
    }

}