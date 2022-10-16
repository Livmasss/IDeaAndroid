package com.livmas.idea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register1)

        val emailEditText : EditText = findViewById(R.id.userEmail)
        val nameEditText : EditText = findViewById(R.id.userName)
        val nextButton : Button = findViewById(R.id.nextButton)

        nextButton.setOnClickListener() {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val intent = Intent(this, RegisterActivity2::class.java)

            intent.putExtra("name", name)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}