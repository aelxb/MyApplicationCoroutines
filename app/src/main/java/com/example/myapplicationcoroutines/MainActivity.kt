package com.example.myapplicationcoroutines

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.bsearch)
        button.setOnClickListener(){
            val intent = Intent(this@MainActivity, Web::class.java)
            val text = findViewById<EditText>(R.id.et)
            startActivity(intent)
        }
    }
}
