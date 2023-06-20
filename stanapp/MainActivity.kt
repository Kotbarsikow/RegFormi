package com.example.stanapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Name = findViewById<EditText>(R.id.name)
        val emailUser = findViewById<EditText>(R.id.email)
        val Pass = findViewById<EditText>(R.id.pass)
        val Register = findViewById<Button>(R.id.register)
        val auth = findViewById<TextView>(R.id.link_to_auth)

        auth.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        Register.setOnClickListener{
            val login = Name.text.toString().trim()
            val email = emailUser.text.toString().trim()
            val pass = Pass.text.toString().trim()

            if(login == "" || email== ""|| pass=="")
                Toast.makeText(this, "not all fields are filled",Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "User $login was added", Toast.LENGTH_LONG)

                Name.text.clear()
                emailUser.text.clear()
                Pass.text.clear()
            }
        }

    }
}