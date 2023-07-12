package com.example.bananaboxing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultsGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results_game)

        val res = intent.getIntExtra("result", 0)
        val score = findViewById<TextView>(R.id.score)
        score.text = res.toString()
    }
}