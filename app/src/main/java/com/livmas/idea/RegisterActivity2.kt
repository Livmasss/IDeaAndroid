package com.livmas.idea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class RegisterActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        val name = intent.getStringExtra("name")

        if (name != null) {
            Log.d("reg", name)
        }
    }
}