package com.example.bananaboxing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class BananaBoxingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banana_boxing)

        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) { }

            override fun onFinish() {
                startAct(inentNwe())
            }
        }
        timer.start()
    }

    private fun inentNwe(): Intent {
        val intent = Intent(this, HitBananaActivity::class.java)
        return intent
    }
    private fun startAct(intent: Intent) {
        startActivity(intent)
    }
}