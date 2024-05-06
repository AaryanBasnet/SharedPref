package com.example.sharedpref

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpref.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var activityLoginBinding: ActivityLoginBinding
    private var email = "example@gmail.com"
    private var fileName = "sharedPref"
    private var password = "*******"
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        activityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        var view = activityLoginBinding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sharedPreferences = getSharedPreferences(fileName, MODE_PRIVATE)
        val fetchedEmail = sharedPreferences.getString(email,"")
        val fetchedPassword = sharedPreferences.getString(password,"")

        activityLoginBinding.logBtn.setOnClickListener {
            val emailFieldValue = activityLoginBinding.emailEdit.text.toString()
            val pwdFieldValue = activityLoginBinding.passwordEdit.text.toString()
            if (emailFieldValue.equals(fetchedEmail)&&pwdFieldValue.equals(fetchedPassword)){
                Toast.makeText(this,"Login successfully",Toast.LENGTH_LONG).show()
            }
        }
    }
}