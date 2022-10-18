package com.livmas.idea

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri

class RegisterActivity1 : AppCompatActivity() {
    lateinit var avatarView : ImageView
    private val imagePickerLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        uri: Uri? -> uri.let { avatarView.setImageURI(uri) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register1)

        val emailEditText : EditText = findViewById(R.id.userEmail)
        val nameEditText : EditText = findViewById(R.id.userName)
        val nextButton : Button = findViewById(R.id.nextButton)
        val avatarSelectButton : Button = findViewById(R.id.avatarSelectButton)
        avatarView = findViewById(R.id.avatar)

        avatarSelectButton.setOnClickListener {
            uploadImage(avatarView)
        }

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

    private fun uploadImage(avatarView: ImageView) {

        imagePickerLauncher.launch("image/*")
    }

    private fun isNameValid(name : String) : Boolean {
        if ( name.length < 3 ) {
            Toast.makeText(this, "Длина имени меньше 3 символов", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
    private fun isEmailValid(email : String): Boolean {
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
