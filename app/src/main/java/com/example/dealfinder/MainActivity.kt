package com.example.dealfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.dealfinder.LoginActivity
import java.time.Instant

class MainActivity : AppCompatActivity()
{

    private lateinit var loginBtn : Button
    private lateinit var joinNow : Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginBtn = findViewById(R.id.main_login_button) as Button;

        joinNow   = findViewById(R.id.main_join_inputs) as Button;


        loginBtn.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        joinNow.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}