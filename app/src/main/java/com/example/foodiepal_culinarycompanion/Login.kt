package com.example.foodiepal_culinarycompanion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        loginBtn.setOnClickListener {
            if (username.text.toString() != "Abdel wehab" && password.text.toString() != "123456"){
            Toast.makeText(this, "Error with credentials", Toast.LENGTH_LONG).show()
            } else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}