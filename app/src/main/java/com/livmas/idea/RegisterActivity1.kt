package com.livmas.idea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register1)

        val emailEditText : EditText = findViewById(R.id.userEmail)
        val nameEditText : EditText = findViewById(R.id.userName)
        val nextButton : Button = findViewById(R.id.nextButton)
        val avatarSelectButton : Button = findViewById(R.id.avatarSelectButton)

        nextButton.setOnClickListener() {

            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()

            if ( isEmailValid(email) && isNameValid(name)  ) {
                val intent1 = Intent(this, RegisterActivity2::class.java)

                intent1.putExtra("name", name)
                intent1.putExtra("email", email)
                startActivity(intent1)
            }
        }
    }

    private fun isNameValid(name : String) : Boolean {
        if ( name.length < 3 ) {
            Toast.makeText(this, "Длина имени меньше 3 символов", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
    fun isEmailValid(email : String): Boolean {
        if ( TextUtils.isEmpty(email) ) {
            Toast.makeText(this, "Email пуст", Toast.LENGTH_SHORT).show()
            return false
        }
        if ( !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() ) {
            Toast.makeText(this, "Неверный email адрес", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}