package com.example.jboxx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.buttonSignIn)
        val mEmail = findViewById<EditText>(R.id.email)
        val mPassword = findViewById<EditText>(R.id.password)
        val registerButton = findViewById<TextView>(R.id.registeraccount)

        intent?.let {
            it.getStringExtra("email")?.let { email ->
                mEmail.setText(email)
            }
            it.getStringExtra("password")?.let { password ->
                mPassword.setText(password)
            }
        }

        buttonLogin.setOnClickListener {
            val email = mEmail.text.toString()
            val password = mPassword.text.toString()
            val intent = Intent(this, DashboardActivity::class.java).apply {
                putExtra("email", email)
                putExtra("password", password)
            }
            Toast.makeText(this, "You have successfully, logged In", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()

        }

        registerButton.setOnClickListener {
            val intent = Intent (this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}