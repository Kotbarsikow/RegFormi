package com.example.stanapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val enterName = findViewById<EditText>(R.id.enterName_auth)
        val enterPassword = findViewById<EditText>(R.id.enterPassword_auth)
        val enterbutton = findViewById<Button>(R.id.enter_auth)
        val registerlink = findViewById<TextView>(R.id.link_to_reg)

        registerlink.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        enterbutton.setOnClickListener{
            val login = enterName.text.toString().trim()
            val pass = enterPassword.text.toString().trim()

            if(login == "" ||  pass=="")
                Toast.makeText(this, "not all fields are filled", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)
                Toast.makeText(this, "User $login was added", Toast.LENGTH_LONG)

                if(isAuth){
                    Toast.makeText(this, "User $login was added", Toast.LENGTH_LONG).show()
                } else
                    Toast.makeText(this, "User $login wasn't added", Toast.LENGTH_LONG).show()

                enterName.text.clear()

                enterPassword.text.clear()
            }
        }


    }

}