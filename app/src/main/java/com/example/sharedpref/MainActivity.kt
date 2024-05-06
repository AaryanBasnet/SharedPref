package com.example.sharedpref

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val fruitList = arrayOf(
        "Apple",
        "Orange",
        "Banana",
        "Grapes",
        "Strawberry",
        "Watermelon",
        "Pineapple",
        "Mango",
        "Kiwi",
        "Peach",
        "Plum",
        "Cherry",
        "Blueberry",
        "Raspberry",
        "Pear",
        "Lemon",
        "Lime",
        "Coconut",
        "Pomegranate"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}