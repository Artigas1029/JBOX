package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val mEmail = findViewById<EditText>(R.id.emailreg)
        val mPassword = findViewById<EditText>(R.id.passwordreg)
        val mConPassword = findViewById<EditText>(R.id.confirmpasswordreg)
        val signUpButton = findViewById<TextView>(R.id.signup)

        signUpButton.setOnClickListener {
            val email = mEmail.text.toString()
            val password = mPassword.text.toString()
            val conPassword = mConPassword.text.toString()
            if(password == conPassword){
                val intent = Intent(this, LoginActivity::class.java).apply {
                    putExtra("email", email)
                    putExtra("password", password)
                }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Password do not match", Toast.LENGTH_SHORT).show()
            }
        }
    }
}