package com.example.loginbyan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etEmail = findViewById<EditText>(R.id.emailtext)
        val btnNext = findViewById<Button>(R.id.loginButton)

        btnNext.setOnClickListener {
            val email = etEmail.text.toString()

            if (email.isNotEmpty()) {
                Log.d("MainActivity", "Email yang dimasukkan: $email") // Menampilkan email di Logcatt
                Toast.makeText(this, "Email: $email", Toast.LENGTH_SHORT).show() // Menampilkan email dalam layar

                // Email to MainActivity
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("USER_EMAIL", email) // Mengirim email
                startActivity(intent)

            } else {
                etEmail.error = "Email harus diisi"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}