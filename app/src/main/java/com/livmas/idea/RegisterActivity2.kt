package com.livmas.idea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        val passwordView : EditText = findViewById(R.id.userPassword)
        val passConfirmView : EditText = findViewById(R.id.userPasswordConfimation)
        val nextButton : Button = findViewById(R.id.nextButton)
        var password : String

        nextButton.setOnClickListener {
            password = passwordView.text.toString()

            if ( isPasswordValid(password, passConfirmView.text.toString() ) ) {
                val intent2 = Intent(this, RegisterActivity3::class.java)
                intent2.apply {
                    putExtra("name", intent.getStringExtra("name"))
                    putExtra("email", intent.getStringExtra("email"))
                    putExtra("password", password)
                }
                startActivity(intent2)
            }
        }
    }

    fun isPasswordValid (password : String, passConfirm : String) : Boolean {
        val passLen = password.length
        if ( passLen < 8 ) {
            Toast.makeText(this, "Пароль должен быть не менее 8 символов", Toast.LENGTH_SHORT).show()
            return false
        }

        if ( password != passConfirm ) {
            Toast.makeText(this, "Пароли не совпадают!", Toast.LENGTH_SHORT).show()
            return false
        }

        for ( i in password ) {
            if ( i.isDigit() ) {
                return true
            }
        }
        Toast.makeText(this, "Пароль должен содержать цифру", Toast.LENGTH_SHORT).show()
        return false
    }
}