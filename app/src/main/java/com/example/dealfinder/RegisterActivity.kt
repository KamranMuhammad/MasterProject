package com.example.dealfinder


import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
//import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth
    lateinit var reg_email_input: EditText
    lateinit var reg_password_input: EditText
    private lateinit var btnRegister: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister = findViewById(R.id.register_btn)
        reg_email_input = findViewById(R.id.register_email_input)
        reg_password_input = findViewById(R.id.register_password_input)

        auth = Firebase.auth


        btnRegister.setOnClickListener {
            registerUser()
        }


    }

    private fun registerUser() {
        val email = reg_email_input.text.toString()
        val password = reg_password_input.text.toString()

        if (email.isBlank() || password.isBlank()) {
            Toast .makeText(this, "Email or Password can't be empty" , Toast.LENGTH_SHORT).show()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()){
            Toast .makeText(this, "Enter valid Email " , Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast .makeText(this, "Successfully Register " , Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Registration failed try again", Toast.LENGTH_SHORT).show()

                }
            }


    }
}