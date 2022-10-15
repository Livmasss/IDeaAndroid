package com.livmas.idea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nameEditText : EditText = findViewById(R.id.userName)
        val passwordEditText : EditText = findViewById(R.id.userEmail)
    }
}